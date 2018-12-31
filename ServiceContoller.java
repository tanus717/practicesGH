package com.es.SpringBootApp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class ServiceContoller {
	private static final String HOST = "search-hitech-tuxhxhzzt4sw2d5sak3l6e2mny.ap-south-1.es.amazonaws.com";
	private static final int PORT = 443;
	private static final String PROTOCOL = "https";
	
	@Autowired
	AllResource res;

	private static final RestHighLevelClient client = new RestHighLevelClient(
			RestClient.builder(new HttpHost(HOST, PORT, PROTOCOL)));

	@RequestMapping(value = "/getdata/{type}", method = RequestMethod.POST)
	public String getData(@PathVariable String type, @RequestBody String insert,
			@RequestParam(value = "perpage", required = false) Integer perpage,
			@RequestParam(value = "sortDate", required = false) String sortDate,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "next", required = false) Integer next)
			throws URISyntaxException, JSONException, IOException {

		JSONObject json = new JSONObject(insert);
		SearchRequest searchRequest = new SearchRequest();
		SearchRequest sr = new SearchRequest();
		SearchSourceBuilder builder = new SearchSourceBuilder();
		Map<String, Object> fields = JsonToMap.jsonToMap(json);
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

		for (Map.Entry<String, Object> entry : fields.entrySet()) {
			boolQuery.must(QueryBuilders.matchQuery(entry.getKey(), entry.getValue()));
			// boolQuery.must(QueryBuilders.termQuery(entry.getKey(), entry.getValue()));
		}
		builder.query(boolQuery);
		searchRequest.indices(type);
		sr.indices(type);
		if (perpage != null && next != null) {
			int from = perpage * (next - 1);
			int size = perpage;
			builder.from(from);
			builder.size(size);
		}
		if (sort != null) {
			if (sort.endsWith("d"))
				builder.sort(
						new FieldSortBuilder(sort.substring(0, sort.length() - 1) + ".keyword").order(SortOrder.DESC));
			else if (sort.endsWith("a"))
				builder.sort(
						new FieldSortBuilder(sort.substring(0, sort.length() - 1) + ".keyword").order(SortOrder.ASC));
			searchRequest.source(builder);
		} else if (sortDate != null) {
			if (sortDate.endsWith("d"))
				builder.sort(new FieldSortBuilder(sortDate.substring(0, sortDate.length() - 1)).order(SortOrder.DESC));
			else if (sortDate.endsWith("a"))
				builder.sort(new FieldSortBuilder(sortDate.substring(0, sortDate.length() - 1)).order(SortOrder.ASC));
			searchRequest.source(builder);
		}
		searchRequest.source(builder);
		SearchResponse searchResponse = null;
		try {
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONArray s = new JSONArray();
		SearchHit[] hits = searchResponse.getHits().getHits();
		for (SearchHit hit : hits) {
			Map<String, Object> map = new HashMap<>();
			map = hit.getSourceAsMap();
			s.put(map);
		}
		JSONObject js = new JSONObject();

		js.put("Count", client.search(searchRequest, RequestOptions.DEFAULT).getHits().totalHits);
		js.put("TotalCount", client.search(sr, RequestOptions.DEFAULT).getHits().totalHits);
		js.put("resp", s);
		return js.toString();
	}

	@RequestMapping(value = "/postdata/{type}", method = RequestMethod.POST)
	public String postData(@PathVariable String type, @RequestParam(value = "type2", required = false) String type2,
			@RequestHeader HttpHeaders headers, @RequestBody String insert)
			throws URISyntaxException, IOException, JSONException {

		String id = "";
		IndexRequest indexRequest = null;
		IndexResponse indexResponse = null;
		ArrayList<String> arrayList = new ArrayList<>();
		JSONArray array = new JSONArray(insert);
		for (int i = 0; i < array.length(); i++) {
			JSONObject jsonObject = (JSONObject) array.get(i);
			if (jsonObject.has("id"))
				id = jsonObject.get("id").toString();
			indexRequest = new IndexRequest(type, "data", id).source(array.get(i).toString(), XContentType.JSON);
			try {
				indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
				arrayList.add("ID : " + indexResponse.getId().toString());
			} catch (Exception e) {
				return "Errors : "+e.fillInStackTrace();
			}
			if (type2 != null && type2 != "") {
				String deleted = jsonObject.getString("deleted");
				if (deleted.equals("0")) {
					jsonObject.remove("deleted");
				}
				jsonObject.put("deleted", 1);
				indexRequest = new IndexRequest(type2, "data", id).source(array.get(i).toString(), XContentType.JSON);
				client.index(indexRequest, RequestOptions.DEFAULT);
			}
		}
		return arrayList.toString();
	}

	@RequestMapping(value = "/get/{type}", method = RequestMethod.GET)
	public String get(@PathVariable String type, @RequestParam(value = "id", required = false) Object id,
			@RequestParam(value = "accountId", required = false) String id1,
			@RequestParam(value = "findByName", required = false) String name,
			@RequestParam(value = "perpage", required = false) Integer perpage,
			@RequestParam(value = "next", required = false) Integer next)
			throws JsonParseException, JsonMappingException, IOException, JSONException {

		if (type.startsWith("count"))
			return res.getCount(type);
		else if (type.startsWith("path") & id != null || id1 != null)
			return res.getHierarchy(type, id, id1);
		else if (type.startsWith("del") || type.startsWith("noti")& id != null)
			return res.deletedStatus(type, Integer.parseInt((String) id));
		else if (type.startsWith("relation"))
			return res.relation(type, id);
		else if (id != null || id1 != null)
			return res.getById(type, id, id1);
		else if (name != null)
			return res.find(type, name);
		else {
			return res.getAll(type, next, perpage);
		}
	}

	@RequestMapping(value = "/post/{type}", method = RequestMethod.POST)
	public String post(@RequestBody String json, @PathVariable String type,
			@RequestParam(value = "id", required = false) String id
			) {
		try {
			return res.persist(type, json,id);
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return "Plz enter a valid format....!!!!!\n Thank You.....!!!!!!!!";
	}

}

package com.es.SpringBootApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.es.SpringBootApp.model.*;
import com.es.SpringBootApp.repository.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
@EnableJpaRepositories("com.es.SpringBootApp.repository")
public class AllResource {
	@Autowired
	IndustryRepository industryRepository;
	@Autowired
	AccountBlackListRepository accountBlackListRepository;
	@Autowired
	AccountnopoachRepository accountnopoachRepository;
	@Autowired
	AccIndRelRepository accIndRelRepository;
	@Autowired
	AccountOrgStructureRepository accountOrgStructureRepository;
	@Autowired
	AccountTargetEmployerRepository accountTargetEmployerRepository;
	@Autowired
	BrandsRepository brandsRepository;
	@Autowired
	ClassificationRepository classificationRepository;
	@Autowired
	CompanyBrandRepository companyBrandRepository;
	@Autowired
	CurrentCompanyRepository currentCompanyRepository;
	@Autowired
	FunctionalRepository functionalRepository;
	@Autowired
	FunctionGroupRepository functionGroupRepository;
	@Autowired
	HitechAccountsRepository hitechAccountsRepository;
	@Autowired
	IndustryGroupRepository industryGroupRepository;
	@Autowired
	IndustryOrgStructureRepository industryOrgStructureRepository;
	@Autowired
	MergeCompanyRepository mergeCompanyRepository;
	@Autowired
	ProductBrandRepository productBrandRepository;
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	SubClassificationRepository subClassificationRepository;
	@Autowired
	SubFunctionalRepository subFunctionalRepository;
	@Autowired
	SuperClassificationRepository superClassificationRepository;
	@Autowired
	SupFunctionalRepository supFunctionalRepository;
	@Autowired
	RolesRepository rolesRepository;
	@Autowired
	UserRolesRepository userRolesRepository;
	@Autowired
	RoleAccessActionRepository roleAccessActionRepository;
	@Autowired
	AccountprocessRepository accountprocessRepository;
	@Autowired
	AccountservicesRepository accountservicesRepository;
	@Autowired
	AccounttooltechRepositroy accounttooltechRepositroy;
	@Autowired
	LinkedinindustryRepository linkedinindustryRepository;
	@Autowired
	MonsterindustryRepository monsterindustryRepository;
	@Autowired
	NaukriindustryRepository naukriindustryRepository;
	@Autowired
	RelLinkedinIndusRepository relLinkedinIndusRepository;
	@Autowired
	RelMonsterIndusRepository relMonsterIndusRepository;
	@Autowired
	RelNaukriIndusRepository relNaukriIndusRepository;
	@Autowired
	ModuleListRepository moduleListRepository;
	@Autowired
	ServicesRepository servicesRepository;
	@Autowired
	TooltechRepository tooltechRepository;
	@Autowired
	IndustryservicesRepository industryservicesRepository;
	
	
	
	public String getAll(String type, Integer pages, Integer size)
			throws JSONException, JsonParseException, JsonMappingException, IOException {
		List list = null;
		Page page = null;
		Pageable pageable = null;

		if (size != null && pages != null) {
			int perpage = size;
			int next = pages;
			pageable = PageRequest.of(next, perpage, Sort.by("id").descending());
		}

		if (type.equalsIgnoreCase("industry"))
			if (pageable != null)
				page = industryRepository.findAll(pageable);
			else
				list = industryRepository.findAll();

		else if (type.equalsIgnoreCase("accountBlackList"))
			if (pageable != null)
				page = accountBlackListRepository.findAll(pageable);
			else
				list = accountBlackListRepository.findAll();

		else if (type.equalsIgnoreCase("accountnopoach"))
			if (pageable != null)
				page = accountnopoachRepository.findAll(pageable);
			else
				list = accountnopoachRepository.findAll();

		else if (type.equalsIgnoreCase("accountorgstructure"))
			if (pageable != null)
				page = accountOrgStructureRepository.findAll(pageable);
			else
				list = accountOrgStructureRepository.findAll();

		else if (type.equalsIgnoreCase("accounttargetemployer"))
			if (pageable != null)
				page = accountTargetEmployerRepository.findAll(pageable);
			else
				list = accountTargetEmployerRepository.findAll();

		else if (type.equalsIgnoreCase("accIndRel"))
			if (pageable != null)
				page = accIndRelRepository.findAll(pageable);
			else
				list = accIndRelRepository.findAll();

		else if (type.equalsIgnoreCase("brands"))
			if (pageable != null)
				page = brandsRepository.findAll(pageable);
			else
				list = brandsRepository.findAll();

		else if (type.equalsIgnoreCase("classification"))
			if (pageable != null)
				page = classificationRepository.findAll(pageable);
			else
				list = classificationRepository.findAll();

		else if (type.equalsIgnoreCase("companyBrand"))
			if (pageable != null)
				page = companyBrandRepository.findAll(pageable);
			else
				list = companyBrandRepository.findAll();

		else if (type.equalsIgnoreCase("currentCompany"))
			if (pageable != null)
				page = currentCompanyRepository.findAll(pageable);
			else
				list = currentCompanyRepository.findAll();

		else if (type.equalsIgnoreCase("functional"))
			if (pageable != null)
				page = functionalRepository.findAll(pageable);
			else
				list = functionalRepository.findAll();

		else if (type.equalsIgnoreCase("functiongroup"))
			if (pageable != null)
				page = functionGroupRepository.findAll(pageable);
			else
				list = functionGroupRepository.findAll();

		else if (type.equalsIgnoreCase("hitechAccounts"))
			if (pageable != null)
				page = hitechAccountsRepository.findAll(pageable);
			else
				list = hitechAccountsRepository.findAll();

		else if (type.equalsIgnoreCase("supfunctional"))
			if (pageable != null)
				page = supFunctionalRepository.findAll(pageable);
			else
				list = supFunctionalRepository.findAll();

		else if (type.equalsIgnoreCase("industrygroup"))
			if (pageable != null)
				page = industryGroupRepository.findAll(pageable);
			else
				list = industryGroupRepository.findAll();

		else if (type.equalsIgnoreCase("industryorgstructure"))
			if (pageable != null)
				page = industryOrgStructureRepository.findAll(pageable);
			else
				list = industryOrgStructureRepository.findAll();

		else if (type.equalsIgnoreCase("mergeCompany"))
			if (pageable != null)
				page = mergeCompanyRepository.findAll(pageable);
			else
				list = mergeCompanyRepository.findAll();

		else if (type.equalsIgnoreCase("products"))
			if (pageable != null)
				page = productsRepository.findAll(pageable);
			else
				list = productsRepository.findAll();

		else if (type.equalsIgnoreCase("productBrand"))
			if (pageable != null)
				page = productBrandRepository.findAll(pageable);
			else
				list = productBrandRepository.findAll();

		else if (type.equalsIgnoreCase("subclassification"))
			if (pageable != null)
				page = subClassificationRepository.findAll(pageable);
			else
				list = subClassificationRepository.findAll();

		else if (type.equalsIgnoreCase("subfunctional"))
			if (pageable != null)
				page = subFunctionalRepository.findAll(pageable);
			else
				list = subFunctionalRepository.findAll();

		else if (type.equalsIgnoreCase("superclassification"))
			if (pageable != null)
				page = superClassificationRepository.findAll(pageable);
			else
				list = superClassificationRepository.findAll();

		else if (type.equalsIgnoreCase("userroles"))
			if (pageable != null)
				page = userRolesRepository.findAll(pageable);
			else
				list = userRolesRepository.findAll();

		else if (type.equalsIgnoreCase("roles"))
			if (pageable != null)
				page = rolesRepository.findAll(pageable);
			else
				list = rolesRepository.findAll();

		else if (type.equalsIgnoreCase("RoleAccessAction"))
			if (pageable != null)
				page = roleAccessActionRepository.findAll(pageable);
			else
				list = roleAccessActionRepository.findAll();

		else if (type.equalsIgnoreCase("accountprocess"))
			if (pageable != null)
				page = accountprocessRepository.findAll(pageable);
			else
				list = accountprocessRepository.findAll();

		else if (type.equalsIgnoreCase("accountservices"))
			if (pageable != null)
				page = accountservicesRepository.findAll(pageable);
			else
				list = accountservicesRepository.findAll();

		else if (type.equalsIgnoreCase("accounttooltech"))
			if (pageable != null)
				page = accounttooltechRepositroy.findAll(pageable);
			else
				list = accounttooltechRepositroy.findAll();

		else if (type.equalsIgnoreCase("linkedinindustry"))
			if (pageable != null)
				page = linkedinindustryRepository.findAll(pageable);
			else
				list = linkedinindustryRepository.findAll();

		else if (type.equalsIgnoreCase("monsterindustry"))
			if (pageable != null)
				page = monsterindustryRepository.findAll(pageable);
			else
				list = monsterindustryRepository.findAll();

		else if (type.equalsIgnoreCase("naukriindustry"))
			if (pageable != null)
				page = naukriindustryRepository.findAll(pageable);
			else
				list = naukriindustryRepository.findAll();

		else if (type.equalsIgnoreCase("relLinkedinIndus"))
			if (pageable != null)
				page = relLinkedinIndusRepository.findAll(pageable);
			else
				list = relLinkedinIndusRepository.findAll();

		else if (type.equalsIgnoreCase("relMonsterIndus"))
			if (pageable != null)
				page = relMonsterIndusRepository.findAll(pageable);
			else
				list = relMonsterIndusRepository.findAll();

		else if (type.equalsIgnoreCase("relNaukriIndus"))
			if (pageable != null)
				page = relNaukriIndusRepository.findAll(pageable);
			else
				list = relNaukriIndusRepository.findAll();

		else if (type.equalsIgnoreCase("tooltech"))
			if (pageable != null)
				page = tooltechRepository.findAll(pageable);
			else
				list = tooltechRepository.findAll();
		
		else if (type.equalsIgnoreCase("services"))
			if (pageable != null)
				page = servicesRepository.findAll(pageable);
			else
				list =servicesRepository.findAll();
		
		else if (type.equalsIgnoreCase("moduleList"))
			if (pageable != null)
				page = moduleListRepository.findAll(pageable);
			else
				list =moduleListRepository.findAll();
		
		else if (type.equalsIgnoreCase("industryservices"))
			if (pageable != null)
				page = industryservicesRepository.findAll(pageable);
			else
				list =industryservicesRepository.findAll();
		
		
		
		
		else
			return "Plz Enter a valid TYPE.....!!!!!!!!!";
		if (page != null)
			list = page.getContent();

		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		for (int i = 0; i < list.size(); i++) {
			map = mapper.readValue(gson.toJson(list.get(i)), new TypeReference<Map<String, String>>() {
			});
			array.put(map);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Response", array);
		jsonObject.put("TotalCount", list.size());
		return jsonObject.toString();

	}

	public String getById(String type, Object id, String id1)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		List list = null;

		if (type.equalsIgnoreCase("industry"))
			list = industryRepository.findByIndusgrpId(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("accountblacklist"))
			list = accountBlackListRepository.findByParentid((String) id);
		else if (type.equalsIgnoreCase("accountnopoach"))
			list = accountnopoachRepository.findByParentid((String) id);

		else if (type.equalsIgnoreCase("accountorgstructure"))
			list = accountOrgStructureRepository.findByAccountid((String) id);
		else if (type.equalsIgnoreCase("accounttargetemployer"))
			list = accountTargetEmployerRepository.findByParentid((String) id);
		else if (type.equalsIgnoreCase("accIndRel")) {
			if (id1 != null)
				list = accIndRelRepository.findByAccountId((String) id1);
			else
				list = accIndRelRepository.findByIndustryId(Integer.parseInt((String) id));
		} else if (type.equalsIgnoreCase("brands"))
			list = brandsRepository.findByBrandName((String) id);
		else if (type.equalsIgnoreCase("classification"))
			list = classificationRepository.findByIndustryId(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("companyBrand"))
			list = companyBrandRepository.findByCompanyId((String) id);

		else if (type.equalsIgnoreCase("currentCompany"))
			list = currentCompanyRepository.findByCompanyId((String) id);
		else if (type.equalsIgnoreCase("functional"))
			list = functionalRepository.findByFunctiongroupid(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("supfunctional"))
			list = supFunctionalRepository.findBySubfunctionalid(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("industryorgstructure"))
			list = industryOrgStructureRepository.findByAccountid((String) id);
		else if (type.equalsIgnoreCase("mergeCompany"))
			list = mergeCompanyRepository.findByParentcompanyId((String) id);
		else if (type.equalsIgnoreCase("products"))
			list = productsRepository.findByIndusId(Integer.parseInt((String) id));

		else if (type.equalsIgnoreCase("productBrand"))
			list = productBrandRepository.findByProductId((String) id);
		else if (type.equalsIgnoreCase("subclassification"))
			list = subClassificationRepository.findByClassificationId(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("subfunctional"))
			list = subFunctionalRepository.findByFunctionalid(Integer.parseInt((String) id));

		else if (type.equalsIgnoreCase("superclassification"))
			list = superClassificationRepository.findBySubClassificationId(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("userRoles"))
			list = userRolesRepository.findByRoleId((String) id);

		/*
		 * else if (type.equalsIgnoreCase("RoleAccessAction")) return
		 * roleAccessActionRepository.persists();
		 */

		else
			return "Enter valid TYPE.....!!!!!!!!";
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		for (int i = 0; i < list.size(); i++) {
			map = mapper.readValue(gson.toJson(list.get(i)), new TypeReference<Map<String, String>>() {
			});
			array.put(map);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Response", array);
		jsonObject.put("TotalCount", list.size());
		return jsonObject.toString();
	}

	public String persist(String type, String json, String roleid)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		List list;
		List role;

		ObjectMapper mapper = new ObjectMapper();
		if (type.equalsIgnoreCase("industry"))
			industryRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Industry.class)));
		else if (type.equalsIgnoreCase("accountblacklist"))
			accountBlackListRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, AccountBlackList.class)));
		else if (type.equalsIgnoreCase("AccIndRel"))
			accIndRelRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, AccIndRel.class)));

		else if (type.equalsIgnoreCase("Accountnopoach"))
			accountnopoachRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Accountnopoach.class)));
		else if (type.equalsIgnoreCase("AccountOrgStructure"))
			accountOrgStructureRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, AccountOrgStructure.class)));
		else if (type.equalsIgnoreCase("AccountTargetEmployer"))
			accountTargetEmployerRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, AccountTargetEmployer.class)));

		else if (type.equalsIgnoreCase("Brands"))
			brandsRepository.saveAll(
					mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Brands.class)));
		else if (type.equalsIgnoreCase("Classification"))
			classificationRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Classification.class)));
		else if (type.equalsIgnoreCase("CompanyBrand"))
			companyBrandRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, CompanyBrand.class)));

		else if (type.equalsIgnoreCase("CurrentCompany"))
			currentCompanyRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, CurrentCompany.class)));
		else if (type.equalsIgnoreCase("Functional"))
			functionalRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Functional.class)));
		else if (type.equalsIgnoreCase("FunctionGroup"))
			functionGroupRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, FunctionGroup.class)));

		else if (type.equalsIgnoreCase("HitechAccounts")) {
			if (json.contains("id"))
				hitechAccountsRepository.saveAll(mapper.readValue(json,
						mapper.getTypeFactory().constructCollectionType(List.class, HitechAccounts.class)));
			else
				return "Plz ID also inserted.....!!!!!!!!";
		} else if (type.equalsIgnoreCase("IndustryGroup"))
			industryGroupRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, IndustryGroup.class)));
		else if (type.equalsIgnoreCase("IndustryOrgStructure"))
			industryOrgStructureRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, IndustryOrgStructure.class)));

		else if (type.equalsIgnoreCase("MergeCompany"))
			mergeCompanyRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, MergeCompany.class)));
		else if (type.equalsIgnoreCase("ProductBrand"))
			productBrandRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, ProductBrand.class)));
		else if (type.equalsIgnoreCase("Products"))
			productsRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Products.class)));

		else if (type.equalsIgnoreCase("SubClassification"))
			subClassificationRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, SubClassification.class)));
		else if (type.equalsIgnoreCase("SubFunctional"))
			subFunctionalRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, SubFunctional.class)));
		else if (type.equalsIgnoreCase("SuperClassification"))
			superClassificationRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, SuperClassification.class)));

		else if (type.equalsIgnoreCase("SupFunctional"))
			supFunctionalRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, SupFunctional.class)));

		else if (type.equalsIgnoreCase("roles")) {	
			  rolesRepository.saveAll( mapper.readValue(json,
			  mapper.getTypeFactory().constructCollectionType(List.class, Roles.class)));
			  
			JSONObject obj = new JSONObject();
			JSONArray obj1 = new JSONArray(json);
			list = moduleListRepository.findAll();
			
			Gson gson = new Gson();
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < obj1.length(); i++) {
				JSONObject js =obj1.getJSONObject(i);
                     String ids = js.get("id").toString();
                     ArrayList l = new ArrayList();
				for (int j = 0; j < list.size(); j++) {
					map = mapper.readValue(gson.toJson(list.get(j)), new TypeReference<Map<String, String>>() {
					});

					String s = map.get("modulename").toString();
					obj.put("roleid", ids);
					obj.put("category", s);
					
					l.add(obj.toString());
			}
			String json1 =  l.toString();
			  roleAccessActionRepository.saveAll(mapper.readValue(json1,
			  mapper.getTypeFactory().constructCollectionType(List.class,RoleAccessAction.class)));
			 l.removeAll(l);
			}
		} else if (type.equalsIgnoreCase("userroles"))
			userRolesRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, UserRoles.class)));

		else if (type.equalsIgnoreCase("RoleAccessAction"))
			roleAccessActionRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, RoleAccessAction.class)));

		else if (type.equalsIgnoreCase("accountprocess"))
			accountprocessRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Accountprocess.class)));
		else if (type.equalsIgnoreCase("accountservices"))
			accountservicesRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Accountservices.class)));
		else if (type.equalsIgnoreCase("accounttooltech"))
			accounttooltechRepositroy.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Accounttooltech.class)));

		else if (type.equalsIgnoreCase("linkedinindustry"))
			linkedinindustryRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Linkedinindustry.class)));
		else if (type.equalsIgnoreCase("monsterindustry"))
			monsterindustryRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Monsterindustry.class)));
		else if (type.equalsIgnoreCase("naukriindustry"))
			naukriindustryRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Naukriindustry.class)));

		else if (type.equalsIgnoreCase("relLinkedinIndus"))
			relLinkedinIndusRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, RelLinkedinIndus.class)));

		else if (type.equalsIgnoreCase("relMonsterIndus"))
			relMonsterIndusRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, RelMonsterIndus.class)));

		else if (type.equalsIgnoreCase("relNaukriIndus"))
			relNaukriIndusRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, RelNaukriIndus.class)));

		else if (type.equalsIgnoreCase("services"))
			servicesRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Services.class)));

		else if (type.equalsIgnoreCase("tooltech"))
			tooltechRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Tooltech.class)));
		
		else if (type.equalsIgnoreCase("moduleList"))
			moduleListRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, ModuleList.class)));
		
		else if (type.equalsIgnoreCase("industryservices"))
			industryservicesRepository.saveAll(mapper.readValue(json,
					mapper.getTypeFactory().constructCollectionType(List.class, Industryservices.class)));
		
		else
			return "Plz Enter valid TYPE....!!!!!!!";

		return "Data Inserted Successfully.........!!!!!!!!!!!!!";
	}

	public String getCount(String type) throws JsonParseException, JsonMappingException, IOException, JSONException {
		List list = null;
		if (type.equalsIgnoreCase("countindustry"))
			list = industryRepository.getLIst();
		else if (type.equalsIgnoreCase("countaccountBlackList"))
			list = accountBlackListRepository.getLIst();
		else if (type.equalsIgnoreCase("countaccountnopoach"))
			list = accountnopoachRepository.getLIst();

		else if (type.equalsIgnoreCase("countaccounttargetemployer"))
			list = accountTargetEmployerRepository.getLIst();
		else if (type.equalsIgnoreCase("countaccIndRel"))
			list = accIndRelRepository.getLIst();
		else if (type.equalsIgnoreCase("countclassification"))
			list = classificationRepository.getLIst();
		else if (type.equalsIgnoreCase("countcompanyBrand"))
			list = companyBrandRepository.getLIst();
		else if (type.equalsIgnoreCase("countfunctional"))
			list = functionalRepository.getLIst();
		else if (type.equalsIgnoreCase("countfunctiongroup"))
			list = functionGroupRepository.getLIst();
		else if (type.equalsIgnoreCase("countindustrygroup"))
			list = industryGroupRepository.getLIst();
		else if (type.equalsIgnoreCase("countmergeCompany"))
			list = mergeCompanyRepository.getLIst();
		else if (type.equalsIgnoreCase("countproducts"))
			list = productsRepository.getLIst();

		else if (type.equalsIgnoreCase("countproductBrand"))
			list = productBrandRepository.getLIst();
		else if (type.equalsIgnoreCase("countsubclassification"))
			list = subClassificationRepository.getLIst();
		else if (type.equalsIgnoreCase("countsubfunctional"))
			list = subFunctionalRepository.getLIst();

		else if (type.equalsIgnoreCase("countAccountservices"))
			list = accountservicesRepository.getLIst();
		else if (type.equalsIgnoreCase("countservices"))
			list = servicesRepository.getLIst();
		else if (type.equalsIgnoreCase("countTooltech"))
			list = tooltechRepository.getLIst();

		else if (type.equalsIgnoreCase("countmonsterindustry"))
			list = monsterindustryRepository.getLIst();
		else if (type.equalsIgnoreCase("countLinkedinindustry"))
			list = linkedinindustryRepository.getLIst();
		else if (type.equalsIgnoreCase("countNaukriindustry"))
			list = naukriindustryRepository.getLIst();
		
		else if (type.equalsIgnoreCase("countIndustryServices"))
			list = industryservicesRepository.getLIst();
		else if (type.equalsIgnoreCase("countHitechAccounts"))
			list = hitechAccountsRepository.getLIst();

		else
			return "Plz Enter a valid TYPE.....!!!!!!!!!";
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		for (int i = 0; i < list.size(); i++) {
			map = mapper.readValue(gson.toJson(list.get(i)), new TypeReference<Map<String, String>>() {
			});
			array.put(map);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Response", array);
		jsonObject.put("TotalCount", list.size());
		return jsonObject.toString();
	}

	public String getHierarchy(String type, Object id1, String ids)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		List list = null;
		int id;
		if (id1 != null) {
			id = Integer.parseInt((String) id1);
			if (type.equalsIgnoreCase("pathindustry"))
				list = industryRepository.getHierarchy(id);
			else if (type.equalsIgnoreCase("pathclassification"))
				list = classificationRepository.getHierarchy(id);
			else if (type.equalsIgnoreCase("pathsubclassification"))
				list = subClassificationRepository.getHierarchy(id);
			else if (type.equalsIgnoreCase("pathsuperclassification"))
				list = superClassificationRepository.getHierarchy(id);
			/*
			 * else if (type.equalsIgnoreCase("countHitechAccounts")) list =
			 * hitechAccountsRepository.getHierarchy(id);
			 */

			else if (type.equalsIgnoreCase("pathfunctional"))
				list = functionalRepository.getHierarchy(id);
			else if (type.equalsIgnoreCase("pathsubfunctional"))
				list = subFunctionalRepository.getHierarchy(id);
			else if (type.equalsIgnoreCase("pathsupfunctional"))
				list = supFunctionalRepository.getHierarchy(id);
		} else if (type.equalsIgnoreCase("pathHitechAccounts"))
			list = hitechAccountsRepository.getHierarchy(ids);

		else
			return "Plz Enter a valid TYPE.....!!!!!!!!!";
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		for (int i = 0; i < list.size(); i++) {
			map = mapper.readValue(gson.toJson(list.get(i)), new TypeReference<Map<String, String>>() {
			});
			array.put(map);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Response", array);
		return jsonObject.toString();
	}

	public String deletedStatus(String type, Integer id) {

		int list = 0;
		if (type.equalsIgnoreCase("delIndustry"))
			list = industryRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delaccountblacklist"))
			list = accountBlackListRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delaccountnopoach"))
			list = accountnopoachRepository.updateDeleted(id);

		else if (type.equalsIgnoreCase("delaccountorgstructure"))
			list = accountOrgStructureRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delaccounttargetemployer"))
			list = accountTargetEmployerRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delaccIndRel"))
			list = accIndRelRepository.updateDeleted(id);

		else if (type.equalsIgnoreCase("delbrands"))
			list = brandsRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delclassification"))
			list = classificationRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delcompanyBrand"))
			list = companyBrandRepository.updateDeleted(id);

		else if (type.equalsIgnoreCase("delcurrentCompany"))
			list = currentCompanyRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delfunctional"))
			list = functionalRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delsupfunctional"))
			list = supFunctionalRepository.updateDeleted(id);

		else if (type.equalsIgnoreCase("delindustryorgstructure"))
			list = industryOrgStructureRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delmergeCompany"))
			list = mergeCompanyRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delproducts"))
			list = productsRepository.updateDeleted(id);

		else if (type.equalsIgnoreCase("delproductBrand"))
			list = productBrandRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delsubclassification"))
			list = subClassificationRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delsubfunctional"))
			list = subFunctionalRepository.updateDeleted(id);

		else if (type.equalsIgnoreCase("delsuperclassification"))
			list = superClassificationRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delindustrygroup"))
			list = industryGroupRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delhitechAccounts"))
			list = hitechAccountsRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delfunctiongroup"))
			list = functionGroupRepository.updateDeleted(id);

		else if (type.equalsIgnoreCase("delaccountprocess"))
			list = accountprocessRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delaccountservices"))
			list = accountservicesRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delaccounttooltech"))
			list = accounttooltechRepositroy.updateDeleted(id);
		else if (type.equalsIgnoreCase("delrelLinkedinIndus"))
			list = relLinkedinIndusRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delrelMonsterIndus"))
			list = relMonsterIndusRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delrelNaukriIndus"))
			list = relNaukriIndusRepository.updateDeleted(id);
		
		else if (type.equalsIgnoreCase("delrelMonsterIndus"))
			list = relMonsterIndusRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delrelNaukriIndus"))
			list = relNaukriIndusRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delservices"))
			list = servicesRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("deltooltech"))
			list = tooltechRepository.updateDeleted(id);
		
		else if (type.equalsIgnoreCase("delnaukriindustry"))
			list = naukriindustryRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("dellinkedinindustry"))
			list = linkedinindustryRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delmonsterindustry"))
			list =monsterindustryRepository.updateDeleted(id);

		else if (type.equalsIgnoreCase("delmoduleList"))
			list = moduleListRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delroles"))
			list = rolesRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("deluserRoles"))
			list = userRolesRepository.updateDeleted(id);
		else if (type.equalsIgnoreCase("delRoleAccessAction"))
			list = roleAccessActionRepository.updateDeleted(id);
		
		else if (type.equalsIgnoreCase("delIndustryservices"))
			list = industryservicesRepository.updateDeleted(id);
		

		else if (type.equalsIgnoreCase("notiindustrygroup"))
			list = industryGroupRepository.updateNotification(id);
		else if (type.equalsIgnoreCase("notiIndustry"))
			list = industryRepository.updateNotification(id);
		else if (type.equalsIgnoreCase("noticlassification"))
			list = classificationRepository.updateNotification(id);

		else if (type.equalsIgnoreCase("notisubclassification"))
			list = subClassificationRepository.updateNotification(id);
		else if (type.equalsIgnoreCase("notisuperclassification"))
			list = superClassificationRepository.updateNotifaction(id);

		
		
		else
			return "Invalid Type....!!!!!";

		return "Deleted Status Changed\n	Updated ID : " + id;

	}

	public String find(String type, String name)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		List list = null;

		if (type.equalsIgnoreCase("CurrentCompany"))
			list = currentCompanyRepository.findByPresentEmployer(name);
		else if (type.equalsIgnoreCase("HitechAccounts"))
			list = hitechAccountsRepository.findByName(name);

		else if (type.equalsIgnoreCase("accountBlackList"))
			list = accountBlackListRepository.findByName(name);
		else if (type.equalsIgnoreCase("accountnopoach"))
			list = accountnopoachRepository.findByName(name);
		else if (type.equalsIgnoreCase("brands"))
			list =brandsRepository.findByName(name);
		
		else if (type.equalsIgnoreCase("classification"))
			list = classificationRepository.findByName(name);
		else if (type.equalsIgnoreCase("functional"))
			list = functionalRepository.findByName(name);
		else if (type.equalsIgnoreCase("functiongroup"))
			list = functionGroupRepository.findByName(name);
		
		else if (type.equalsIgnoreCase("industry"))
			list = industryRepository.findByName(name);
		else if (type.equalsIgnoreCase("industryGroup"))
			list = industryGroupRepository.findByName(name);
		else if (type.equalsIgnoreCase("roles"))
			list = rolesRepository.findByName(name);
		
		else if (type.equalsIgnoreCase("subclassification"))
			list = subClassificationRepository.findByName(name);
		else if (type.equalsIgnoreCase("subfunctional"))
			list = subFunctionalRepository.findByName(name);
		else if (type.equalsIgnoreCase("superclassification"))
			list = superClassificationRepository.findByName(name);
		
		else if (type.equalsIgnoreCase("supFunctional"))
			list = supFunctionalRepository.findByName(name);
		
		
		
		else
			return "Enter valid TYPE.....!!!!!!!!";

		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		for (int i = 0; i < list.size(); i++) {
			map = mapper.readValue(gson.toJson(list.get(i)), new TypeReference<Map<String, String>>() {
			});
			array.put(map);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Response", array);
		return jsonObject.toString();
	}

	public String relation(String type, Object id)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		List list = null;
String s ="";
		if (type.equalsIgnoreCase("relationaccIndRel"))
			list = accIndRelRepository.getRelation((String) id);
		else if (type.equalsIgnoreCase("relationproducts"))
			list = productsRepository.getRelation(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("relationIndustry"))
			list = industryRepository.getRelation(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("relationBrands"))
			list = brandsRepository.getRelation(Integer.parseInt((String) id));

		else if (type.equalsIgnoreCase("relationRole")) {
			if(id!=null)
				list = rolesRepository.getRelation((String) id);
			else
			list = rolesRepository.getRelation();
		}
		else if (type.equalsIgnoreCase("relationRelLinkedinIndus"))
			list = relLinkedinIndusRepository.getRelation(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("relationRelMonsterIndus"))
			list = relMonsterIndusRepository.getRelation(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("relationRelNaukriIndus"))
			list = relNaukriIndusRepository.getRelation(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("relationaccountprocess"))
			list = accountprocessRepository.getRelation((String) id);
		else if (type.equalsIgnoreCase("relationaccountservices"))
			list = accountservicesRepository.getRelation((String) id);
		else if (type.equalsIgnoreCase("relationaccounttooltech"))
			list = accounttooltechRepositroy.getRelation((String) id);

		else if (type.equalsIgnoreCase("relationlinkedinindustry"))
			list = linkedinindustryRepository.getRelation(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("relationmonsterindustry"))
			list = monsterindustryRepository.getRelation(Integer.parseInt((String) id));
		else if (type.equalsIgnoreCase("relationnaukriindustry"))
			list = naukriindustryRepository.getRelation(Integer.parseInt((String) id));

		else if (type.equalsIgnoreCase("relationRoleAccessAction"))
			list = rolesRepository.getRoleAccess((String) id);
		
		else if (type.equalsIgnoreCase("relationIndustryServices"))
			list = industryservicesRepository.getRelation(Integer.parseInt((String) id));
		
		
		
		else
			return "Plz Enter a Valid TYpe...!!!!";

		
		
		
		
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		for (int i = 0; i < list.size(); i++) {
			map = mapper.readValue(gson.toJson(list.get(i)), new TypeReference<Map<String, String>>() {
			});
			if(type.equalsIgnoreCase("relationRole")) {
				String d = map.get("roleId").toString();
				s = rolesRepository.data(d);
				if(s!=null)
			map.replace("userId", s);
			}
			array.put(map);
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Response", array);
		return jsonObject.toString();

	}

}

package com.es.SpringBootApp.model.path;

public class BrandProduct  {

	private int productBrandId;
	private int brandId;
	private int productId;
	private String productName;
	private String brandName;
	
	public BrandProduct(int productBrandId, int brandId, int productId, String productName, String brandName) {
		super();
		this.productBrandId = productBrandId;
		this.brandId = brandId;
		this.productId = productId;
		this.productName = productName;
		this.brandName = brandName;
	}

	public int getProductBrandId() {
		return productBrandId;
	}

	public void setProductBrandId(int productBrandId) {
		this.productBrandId = productBrandId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
	
	
}

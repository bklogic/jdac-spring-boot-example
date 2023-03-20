package net.backlogic.persistence.springboot.classic.model;

public class DuplicateProductLineRequest {
	
	private String sourceProductLineName;
	
	private String targetProductLineName;
	
	private String productCodePrefix;

	public String getSourceProductLineName() {
		return sourceProductLineName;
	}

	public void setSourceProductLineName(String sourceProductLineName) {
		this.sourceProductLineName = sourceProductLineName;
	}

	public String getTargetProductLineName() {
		return targetProductLineName;
	}

	public void setTargetProductLineName(String targetProductLineName) {
		this.targetProductLineName = targetProductLineName;
	}

	public String getProductCodePrefix() {
		return productCodePrefix;
	}

	public void setProductCodePrefix(String productCodePrefix) {
		this.productCodePrefix = productCodePrefix;
	}

}

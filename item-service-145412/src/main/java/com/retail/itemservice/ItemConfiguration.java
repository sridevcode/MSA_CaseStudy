package com.retail.itemservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="item-service-145412")
@Component
public class ItemConfiguration {
	
	private String defaultItemName;
	private String defaultItemDescription;
	public String getDefaultItemName() {
		return defaultItemName;
	}
	public void setDefaultItemName(String defaultItemName) {
		this.defaultItemName = defaultItemName;
	}
	public String getDefaultItemDescription() {
		return defaultItemDescription;
	}
	public void setDefaultItemDescription(String defaultItemDescription) {
		this.defaultItemDescription = defaultItemDescription;
	}
	
	
	
	
	
	
	

}

package com.optus.restapi.model;

import java.util.Map;

public class SearchTextTopNBeanReply {
	Map<String,Long> results;

	public Map<String, Long> getMap() {
		return results;
	}

	public void setMap(Map<String, Long> results) {
		this.results = results;
	}
	
}

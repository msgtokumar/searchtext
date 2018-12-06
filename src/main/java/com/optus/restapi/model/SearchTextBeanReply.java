package com.optus.restapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchTextBeanReply {
	  List<Map<String, Integer>> counts = new ArrayList<Map<String, Integer>>();

	public List<Map<String, Integer>> getCounts() {
		return counts;
	}

	public void setCounts(List<Map<String, Integer>> counts) {
		this.counts = counts;
	}




}

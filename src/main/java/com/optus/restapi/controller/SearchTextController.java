package com.optus.restapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.optus.restapi.model.SearchTextBean;
import com.optus.restapi.model.SearchTextBeanReply;
import com.optus.restapi.model.SearchTextTopNBeanReply;
import com.optus.restapi.service.SearchTextService;

@RestController
@RequestMapping("/counter-api")
public class SearchTextController {

	public static final Logger logger = LoggerFactory.getLogger(SearchTextController.class);

	@RequestMapping(value = "/top/{id}", method = RequestMethod.GET)
	public SearchTextTopNBeanReply getTopValues(@PathVariable("id") long id) {
		logger.info("Fetching top {}", id);
	
		SearchTextTopNBeanReply search = new SearchTextTopNBeanReply();
		Map<String,Long> map = null;
		try {
			map=SearchTextService.getTopString(id);
			
		}catch(Exception e) { logger.info("Error in searchtext while process the request(getTopValues) : {}", e.getMessage());}
		search.setMap(map);
		return search;
	}



	
	@RequestMapping(method = RequestMethod.POST, value="/search")
	@ResponseBody
	SearchTextBeanReply SearchText(@RequestBody SearchTextBean searchText) {
		logger.info("Creating searchtext : {}", searchText);
		SearchTextBeanReply search = new SearchTextBeanReply();
		Map<String,Integer> result=new HashMap<String,Integer>();
		List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
		try {
		    String[] strarray = searchText.getSearchText().toArray(new String[0]);
		    searchText.getSearchText().toArray(strarray );
			logger.info("Array searchtext : {}", strarray.length);
			for (String s:strarray) {
			result=SearchTextService.wordCount(s);
			list.add(result);
		}
		}catch(Exception e) {logger.info("Error in searchtext while process the request(SearchText) : {}", e.getMessage());}
		search.setCounts(list);
	return search;
	}

    @RequestMapping("/userlogin")
    public String userValidation() {
        return "User: Successfully logged in!";

    }

    @RequestMapping("/adminlogin")
    public String adminValidation() {
        return "Admin: Successfully logged in!";

    }

}
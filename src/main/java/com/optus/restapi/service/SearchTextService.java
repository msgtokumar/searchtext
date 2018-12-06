package com.optus.restapi.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchTextService {

	public static String readStringFromFile(String filePath) throws IOException {
	    String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
	    return fileContent;
	}
	public static int count(String string, String substr) {
	    return (string.length() - string.replaceAll(substr, "").length()) / substr.length() ;
	}

	
	public static Map<String, Integer> wordCount(String strings) throws IOException {

		  Map<String, Integer> map = new HashMap<String, Integer>();
	      map.put(strings, SearchTextService.count(SearchTextService.readStringFromFile("src\\main\\Content.txt"),strings));

		  return map;
	}
	
	public static Map<String,Long> getTopString(long topN) throws IOException {
		Map<String,Long> map=new HashMap<String,Long>();
		
		
		Arrays.stream(new String(Files.readAllBytes(new File("src\\main\\Content.txt").toPath()), StandardCharsets.UTF_8).split("\\W+"))
        .collect(Collectors.groupingBy(Function.<String>identity(), HashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(((o1, o2) -> o2.getValue().compareTo(o1.getValue())))
        .limit(topN)
        .forEach(e-> map.put(e.getKey(), e.getValue()));
		
		//Sort
        Map<String,Long> topNMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return topNMap;
	}

}
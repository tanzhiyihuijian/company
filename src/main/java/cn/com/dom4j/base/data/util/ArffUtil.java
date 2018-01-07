package cn.com.dom4j.base.data.util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;


public class ArffUtil {
	
	public static final String ATTR_PARSE_PATTERN = "@attribute(.*)[{](.*?)[}]";
	
	/**
	 * 仅针对决策属性适用
	 * @param decAttributeName
	 * @param decAttributeValue
	 * @param attrNameList
	 * @param dataList
	 * @return
	 */
	public int count(String decAttributeName, String decAttributeValue, List<String> attrNameList, List<String[]> dataList) {
		int decAttrIndex = getValueIndex(decAttributeName, attrNameList);
		int count = 0;
		for(String[] data : dataList) {
			if( data[decAttrIndex].trim().equals(decAttributeValue)) count ++;
		}
		return count;
	}
	
	/**
	 * 只有1个决策属性1个目标属性
	 * @param calcAttributeName
	 * @param calcAttributeValue
	 * @param decAttributeName
	 * @param decAttributeValue
	 * @param attrNameList
	 * @param dataList
	 * @return
	 */
	public int count(String calcAttributeName, String calcAttributeValue, String decAttributeName, String decAttributeValue, List<String> attrNameList, List<String[]> dataList) {
		int targetAttrIndex = getValueIndex(calcAttributeName, attrNameList);
		int decAttrIndex = getValueIndex(decAttributeName, attrNameList);
		int count = 0;
		for(String[] data : dataList) {
			if( data[targetAttrIndex].trim().equals(calcAttributeValue) &&
				data[decAttrIndex].trim().equals(decAttributeValue)) count ++;
		}
		return count;
	}
	/**
	 * 不区分 决策属性 与 目标属性
	 * @param calcAttributeNameArr
	 * @param calcAttributeValueArr
	 * @param decAttributeName
	 * @param decAttributeValue
	 * @param attrNameList
	 * @param dataList
	 * @return <br>
	 * -1: 两个数组的长度不相等 <br>
	 * -2: 数组之中的属性名在属性列表之中找不到<br>
	 */
	public int count(String[] calcAttributeNameArr, String[] calcAttributeValueArr, List<String> attrNameList, List<String[]> dataList) {
		int count = 0;
		if(calcAttributeNameArr.length != calcAttributeValueArr.length) return -1;
		int[] targetIndexArr = new int[calcAttributeNameArr.length];
		for(int i = 0; i < calcAttributeNameArr.length; i++) {
			targetIndexArr[i] = getValueIndex(calcAttributeNameArr[i], attrNameList);
			if(targetIndexArr[i] == -1) return -2;
		}
		
		for(String[] data : dataList) {
			Boolean valid = true;
			for(int i  = 0; i < targetIndexArr.length; i++) {
				if(!data[targetIndexArr[i]].trim().equals(calcAttributeValueArr[i])) {
					valid = false;
					break;
				} 
			}
			if(valid) count++; 
		}
		return count;
	}
	
	public int getValueIndex(String name, List<String> list) {
		int index = -1;
		if(list == null || name == null) return index;
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).trim().equals(name.trim())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void retrieveAttributes(File arffFile, Map<String, List<String>> attributeOptionMap, List<String> attributeList) {
		int step = 0;
		if(arffFile.exists() && arffFile.isFile()) {
			try {
				List<String> fileContent = FileUtils.readLines(arffFile);
				Pattern pattern = Pattern.compile(ATTR_PARSE_PATTERN);
				for(String line : fileContent) {
					Matcher matcher = pattern.matcher(line);
					if (matcher.find()) {
						step++;
						String key = matcher.group(1).trim();
						attributeList.add(key);			// add key into result list
	                    String[] values = matcher.group(2).split(",");
	                    ArrayList<String> optionList = new ArrayList<String>(values.length);
	                    for (String value : values) {
	                        optionList.add(value.trim());
	                    }
	                    attributeOptionMap.put(key, optionList);  // add option into result map
	                }
					else if(step > 0) {
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Read data from arff file
	 * @return
	 */
	public List<String[]> getData(File arffFile) {
		List<String[]> dataList = new ArrayList<String[]>();
		
		if(arffFile.exists() && arffFile.isFile()) {
			try {
				List<String> fileContent = FileUtils.readLines(arffFile);
				Boolean foundData = false;
				for(String line : fileContent) {
					if(line.startsWith("@data")) {
						foundData = true;
						continue;
					}
					if(foundData && line.length() > 0) {
						String[] values = line.split(",");
						dataList.add(values);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return dataList;
	}
	
	public static void main(String[] args) {
		ArffUtil util = new ArffUtil();
		File arff = new File("D:\\Program Files\\Weka-3-7\\data\\weather.nominal.arff");
		Map<String, List<String>> optionMap = new HashMap<String, List<String>>();
		List<String> attrList = new ArrayList<String>();
		List<String[]> dataList = util.getData(arff);
		util.retrieveAttributes(arff, optionMap, attrList);
		// test get attribute list
//		System.out.println(new Gson().toJson(attrList));
//		System.out.println(new Gson().toJson(util.getData(arff)));
		
		System.out.println(util.count(new String[]{"play","outlook"}, new String[]{"no","sunny"}, attrList, dataList));;
		
	}

}



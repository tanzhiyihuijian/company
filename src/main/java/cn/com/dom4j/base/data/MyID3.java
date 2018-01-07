package cn.com.dom4j.base.data;

import cn.com.dom4j.base.data.bean.TreeNode;
import cn.com.dom4j.base.data.classifier.ID3Util;
import cn.com.dom4j.base.data.classifier.NBCUtil;
import cn.com.dom4j.base.data.util.ArffUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyID3 {

	public static void main(String[] args) {
		// Step 1: 从arff文件之中读取值
		ArffUtil util = new ArffUtil();
		File arff = new File("C:/software/workspace/weather.nominal.arff");
		Map<String, List<String>> optionMap = new HashMap<String, List<String>>();
		List<String> attrList = new ArrayList<String>();
		List<String[]> dataList = util.getData(arff);
		List<String> skipAttrList = new ArrayList<String>();
		util.retrieveAttributes(arff, optionMap, attrList);
		
		// Step 2 : 开始递归的创建决策树
		ID3Util id3Util = new ID3Util("play", "yes", "no");
		TreeNode decistionTree =  id3Util.buildDecistionTree(attrList, dataList, optionMap, skipAttrList);
//		System.out.println(new Gson().toJson(tree));
		
		// Step 3: 使用决策树进行预测
		Map<String, String> predictData = new HashMap<String, String>();
		predictData.put("outlook", "sunny");
		predictData.put("temperature", "mild");
		predictData.put("humidity", "normal");
		predictData.put("windy", "TRUE");
		
		String result = id3Util.predict(predictData, decistionTree);
		System.out.println("ID3 predict result =" + result);
		
		// Step 4: 使用朴素贝叶斯进行预测
		NBCUtil nbcUtil = new NBCUtil("play", attrList, dataList);
		System.out.println(nbcUtil.predict(predictData, "yes"));;
		
	}

}

package cn.com.dom4j.base.data.classifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import cn.com.dom4j.base.data.bean.Sample;
import cn.com.dom4j.base.data.bean.TreeLeaf;
import cn.com.dom4j.base.data.bean.TreeNode;
import cn.com.dom4j.base.data.util.ArffUtil;
import cn.com.dom4j.base.data.util.DataMiningMathUtil;

public class ID3Util {
	private ArffUtil util = new ArffUtil();
	private String decName;
	private String decPositiveValue;
	private String decNegativeValue;
	private Sample S;
	
	public ID3Util(String decName, String decPositiveValue, String decNegativeValue) {
		this.decName = decName;
		this.decNegativeValue = decNegativeValue;
		this.decPositiveValue = decPositiveValue;
		S = new Sample("", -1, -1);
	}
	
	/**
	 * 使用决策树进行预测
	 * @param dataSource <br>
	 * HashMap: <br>
	 * &nbsp;&nbsp; key: attribute name
	 * &nbsp;&nbsp; value: attribute value
	 * @param decistionTree 
	 * @return <br>
	 * 预测结果
	 */
	public String predict(Map<String, String> dataSource,  TreeNode decistionTree) {
		String result = null;
		if(dataSource.containsKey(decistionTree.attribute)) {
			String currentAttributeValue = dataSource.get(decistionTree.attribute);
			if(decistionTree.options.containsKey(currentAttributeValue)) {
				return predict(dataSource, decistionTree.options.get(currentAttributeValue)); 
			} else if(decistionTree.subLeafs.containsKey(currentAttributeValue)){
				result = decistionTree.subLeafs.get(currentAttributeValue).attributeValue;
			}
		}
		
		return result;
	}
	
	public TreeNode buildDecistionTree(List<String> attrList, List<String[]> dataList, Map<String, List<String>> optionMap, List<String> skipAttributeList) {
		// step1: 计算样本的总体熵
		S = new Sample("样本集合", util.count(decName, decPositiveValue, attrList, dataList), util.count(decName, decNegativeValue, attrList, dataList));
		
		double defaultInfoGain = 0;
		String rootAttributeName = "";
		int decAttributeIndex = util.getValueIndex(decName, attrList);
		
		for(String attr : attrList) {
			if(attr.equals(decName) || skipAttributeList.contains(attr)) continue;
			
			// 计算各个属性的信息增益
			List<Sample> sampleList = new ArrayList<Sample>();
			for(String option : optionMap.get(attr)) {
				int p = util.count(new String[]{attr, decName}, new String[]{option, decPositiveValue}, attrList, dataList);
				int n = util.count(new String[]{attr, decName}, new String[]{option, decNegativeValue}, attrList, dataList);
				sampleList.add(new Sample(option, p, n));
			}
			
			// 信息增益最大的属性成为根节点
			double currentInfoGain = DataMiningMathUtil.infoGain(S, sampleList);
//			System.out.println("!!attr=" + attr + "  infoGain=" + currentInfoGain);
			if(defaultInfoGain < currentInfoGain) {
				defaultInfoGain = currentInfoGain;
				rootAttributeName = attr;
			}
		}
		System.out.println("Root=" + rootAttributeName);
		int rootAttributeIndex = util.getValueIndex(rootAttributeName, attrList);
		TreeNode root = new TreeNode();
		root.attribute = rootAttributeName;
		
		List<String> subSkipList = new ArrayList<String>();
		subSkipList.addAll(skipAttributeList);
		subSkipList.add(rootAttributeName);
		
		// 开始从根节点开始递归的创建子节点
		// 创建outlook=sunny|rainy|overcast 的子 dataList 并分别计算infoGain(temperature) 等等
		for(String option : optionMap.get(rootAttributeName)) {
			List<String[]> subDataList = new ArrayList<String[]>();
			for(String[] data : dataList) {
				if(data[rootAttributeIndex].trim().equals(option)) subDataList.add(data);
			}
			// check if need to add sub-nodes
			if(subDataList.size() > 1 ) {
				String firstValue = subDataList.get(0)[decAttributeIndex];
//				System.out.println("~~ firstvalue=" + firstValue);
				Boolean needSubNodes = false;
				for(String[] data : subDataList) {
					if(!data[decAttributeIndex].equals(firstValue)) {
						needSubNodes = true;
						break;
					}
				}
				if(needSubNodes) {
					root.options.put(option, buildDecistionTree(attrList, subDataList, optionMap, subSkipList));
//					root.subLeafs = null;
				} else {
					TreeLeaf leaf = new TreeLeaf();
					leaf.count = subDataList.size();
					leaf.attributeValue = firstValue;
					leaf.option = option;
					
					root.subLeafs.put(option, leaf);
					
//					root.subNodes = null;
					
				}
			}
		}
		
		return root;
	}
	
	
	
}

package cn.com.dom4j.base.data.bean;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {
	public String attribute;
//	public 	Sample[] samples;
//	public List<TreeNode> subNodes;
	public Map<String, TreeNode> options;
	public Map<String, TreeLeaf> subLeafs;
	public TreeNode() {
		attribute = "";
//		samples = new Sample[]{};
//		subNodes = new ArrayList<TreeNode>();
		subLeafs = new HashMap<String, TreeLeaf>();
		options = new HashMap<String, TreeNode>();
	}
}

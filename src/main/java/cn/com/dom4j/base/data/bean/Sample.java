package cn.com.dom4j.base.data.bean;


import cn.com.dom4j.base.data.util.DataMiningMathUtil;

public class Sample {

	public String name;
	public int positiveCount;
	public int negativeCount;
	
	public Sample(String name, int p, int n) {
		this.name = name;
		this.positiveCount = p;
		this.negativeCount = n;
	}
	
	/**
	 * 计算当前样本的熵值 <br>
	 * 如果名字为null 则返回-1 表示这个样本未正常初始化
	 * @return
	 */
	public double entropy() {
		if(name == null) return -1.;
		return DataMiningMathUtil.entropy(positiveCount, negativeCount);
	}
	
}

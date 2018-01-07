package cn.com.dom4j.base.data.util;

import cn.com.dom4j.base.data.bean.Sample;

import java.util.List;


/**
 * From:<br>
 * entropy  http://blog.csdn.net/v_july_v/article/details/7577684 <br>
 * infoGain http://blog.csdn.net/v_july_v/article/details/7577684 <br>
 * @author wenjun_yang
 *
 */
public class DataMiningMathUtil {
	
	public static double entropy(int positiveCount, int negativeCount) {
		int sum = positiveCount + negativeCount;
		double positiveP = (double)positiveCount / (double)sum ;
		double negativeP = (double)negativeCount / (double)sum;
		return Math.abs(positiveP * log2(positiveP) + negativeP * log2(negativeP) );
	}
	
	public static double entropy(Sample s) {
		return entropy(s.positiveCount, s.negativeCount);
	}
	
	public static double infoGain( Sample totalSample, Sample... attributeSamples ) {
		double totalEntropy = entropy(totalSample);
//		System.out.println("****" + totalEntropy);
		if(attributeSamples.length == 0) {
			return totalEntropy;
		}
		double sampleTotalCount = totalSample.positiveCount + totalSample.negativeCount;
		double temp = 0;
		for(int i = 0; i < attributeSamples.length; i++) {
			Sample s = attributeSamples[i];
			temp += (double) (s.positiveCount + s.negativeCount) / (double) (sampleTotalCount) * entropy(s); 
		}
		
		return totalEntropy - temp;
	}
	
	public static double infoGain(Sample s, List<Sample> sampleList) {
		if(sampleList == null) return -1;
		
		Sample[] samples = new Sample[sampleList.size()];
		for(int i = 0; i < sampleList.size(); i++) {
			samples[i] = sampleList.get(i);
		}
		return infoGain(s, samples);
	}
	
	public static int sum(int... arr) {
		int sum = 0; 
		for(int number : arr) {
			sum += number; 
		}
		return sum;
	}
	
	
	public static double log2(double d) {
		if(d <= 0) return 0.;
		return Math.log(d) / Math.log(2);
	}
	
	
	public static void main(String[] args) {
		// test entropy
		System.out.println(log2( 0));
		System.out.println(entropy(3, 2));
//		Sample S = new Sample("样本", 9, 5);
//		Sample windy_weak = new Sample("windy_weak", 6, 2);
//		Sample windy_strong = new Sample("windy_weak", 3, 3);
//		System.out.println(infoGain(S, windy_weak, windy_strong));
	}

	
	
}

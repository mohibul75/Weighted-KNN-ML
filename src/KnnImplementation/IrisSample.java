package knnImplementation;

import java.util.Collections;
import java.util.List;

public class IrisSample  {
	
	private double sepal_length;
	private double sepal_width;
	private double petal_length;
	private double petal_width;
	private String irisClass;
	
	public IrisSample(double sepal_length, double sepal_width, double petal_length, double petal_width, String irisClass) {
		super();
		this.sepal_length = sepal_length;
		this.sepal_width = sepal_width;
		this.petal_length = petal_length;
		this.petal_width = petal_width;
		this.irisClass = irisClass;
	}

	public IrisSample(double sepal_length, double sepal_width, double petal_length, double petal_width) {
		super();
		this.sepal_length = sepal_length;
		this.sepal_width = sepal_width;
		this.petal_length = petal_length;
		this.petal_width = petal_width;
	}
	
	

	public IrisSample() {
		// TODO Auto-generated constructor stub
	}

	public double getSepal_length() {
		return sepal_length;
	}

	public double getSepal_width() {
		return sepal_width;
	}

	public double getPetal_length() {
		return petal_length;
	}

	public double getPetal_width() {
		return petal_width;
	}

	public String getIrisClass() {
		return irisClass;
	}
	
/*	public static <IrisSample> void sampleSort(List <IrisSample> sampleDistance) {
		Collections.sort((List<T>) sampleDistance);
	}*/

}

package knnImplementation;

public class WeightedKnn {
	
	private double weight;
	private String irisClass;
	public WeightedKnn(double weight, String irisClass) {
		super();
		this.weight = weight;
		this.irisClass = irisClass;
	}
	public double getWeight() {
		return weight;
	}
	public String getIrisClass() {
		return irisClass;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setIrisClass(String irisClass) {
		this.irisClass = irisClass;
	}
	
	

}

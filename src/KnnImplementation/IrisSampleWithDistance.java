package knnImplementation;

import java.util.Collections;

public class IrisSampleWithDistance implements Comperable<IrisSampleWithDistance> {
	private double distance ;
	private String irisClass;
	
	public IrisSampleWithDistance(double distance, String irisClass) {
		super();
		this.distance = distance;
		this.irisClass = irisClass;
	}

	@Override
	public int compare(IrisSampleWithDistance a, IrisSampleWithDistance b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getDistance() {
		return distance;
	}

	public String getIrisClass() {
		return irisClass;
	}

}

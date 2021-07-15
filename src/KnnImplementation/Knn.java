package knnImplementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Knn {
	
	private List <IrisSample> sampleList ;
	Set <String> set=new  HashSet<String>();
	//private List <IrisSample> sampleDistance ;
	public String[] sample_creating(String datasetFile , IrisSample query , int n) throws IOException {
		
		BufferedReader br=new BufferedReader(new FileReader(datasetFile));
		String line="";
		
		 sampleList = new ArrayList<IrisSample>();
		 int numOfSample=0;
		
		while((line=br.readLine())!=null) {
			numOfSample++;
			String []str=line.split(",");

		//	System.out.println(str[0]+str[1]+str[2]+str[3]+str[4]);
			set.add(str[4]);

			IrisSample iris=
					new IrisSample(Double.parseDouble(str[0]),Double.parseDouble(str[1])
							,Double.parseDouble(str[2]),Double.parseDouble(str[3]),str[4]);
			
			sampleList.add(iris);
		}
		
		// List <IrisSampleWithDistance> sampleDistance = null ;
		
		IrisSampleWithDistance []sampleDistance = new IrisSampleWithDistance[numOfSample];
		int count=0;
		for(IrisSample sample : sampleList) {
			
			double dis=0.0;
			
			for(int i=0 ; i<4 ; i++ ) {
				dis =Math.pow(sample.getPetal_length()-query.getPetal_length(), 2)+
						Math.pow(sample.getPetal_width()-query.getPetal_width(), 2)+
						Math.pow(sample.getSepal_length()-query.getSepal_length(), 2)+
						Math.pow(sample.getSepal_width()-query.getSepal_width(), 2);
			}
			
			double distance=Math.sqrt(dis);
			//sampleDistance.add(new IrisSampleWithDistance(distance,sample.getIrisClass()));
			sampleDistance[count++]=new IrisSampleWithDistance(distance,sample.getIrisClass());
		}
		
		int c=0;
		try {
		for(int i=0 ; i<sampleDistance.length ; i++) {
			for(int j=0 ; j<sampleDistance.length ; j++) {
				if((sampleDistance[j].getDistance()>sampleDistance[i].getDistance()) ) {
					//System.out.println(sampleDistance[i].getDistance()+"be"+sampleDistance[j].getDistance());
					IrisSampleWithDistance a=sampleDistance[i];
					sampleDistance[i]=sampleDistance[j];
					sampleDistance[j]=a;
					//System.out.println(sampleDistance[i].getDistance()+"after"+sampleDistance[j].getIrisClass());
				}
			}
		}
		}catch(Exception e) {
			System.out.print(e.toString());
		}
		
		String [] arr=new String[n];
		//System.out.println(n);
		
		for(int i=0 ; i<arr.length ; i++) {
			//System.out.println(sampleDistance[i].getDistance()+"  "+sampleDistance[i].getIrisClass());
			arr[i]=sampleDistance[i].getIrisClass();
		}
		
		//System.out.println("knn : "+findMaximum(arr));
		//System.out.println("Dudani weighted Knn  : "+dudaniKnn(sampleDistance,n));
		
		String [] output= {findMaximum(arr),dudaniKnn(sampleDistance,n)};
	//	System.out.println(output[1]);
		return output;
	}
	
	
	public String findMaximum(String []arr) {
		int numOfSetosa=0;
		int numOfVirginica=0;
		int numOfVersicolor=0;
		
		String [] IrisClass=new String[3];
		int y=0;
		for(Object obj : set) {
			IrisClass[y++]=(String) obj;
			//System.out.println(obj);
		}
		
		for(int i=0 ; i<arr.length ; i++) {
			//System.out.println(arr[i]);
			if(arr[i]==IrisClass[2]) {
				numOfSetosa++;
			}
			else if (arr[i]==IrisClass[1]) {
				numOfVirginica++;
			}
			
			else if(arr[i]==IrisClass[0]) {
				numOfVersicolor++;
			}
		}
		

		
		if(numOfSetosa<numOfVirginica && numOfVirginica>numOfVersicolor ) return IrisClass[1];
		else if(numOfVirginica<numOfVersicolor && numOfSetosa<numOfVersicolor) return IrisClass[0];
		else return IrisClass[2];
		
	}
	
	public String dudaniKnn(IrisSampleWithDistance [] sampleDistance , int k) {
		
		double weightSetosa=0.0;
		double weightVirginica=0.0;
		double weightVersicolor=0.0;
		
		WeightedKnn [] obj=new WeightedKnn [k];
		
		double divisor= sampleDistance[k-1].getDistance()- sampleDistance[0].getDistance();
		for(int i=0 ; i<k ;i++) {
			double w=(sampleDistance[k-1].getDistance()-sampleDistance[i].getDistance())/divisor;
			 obj[i] =new WeightedKnn(w,sampleDistance[i].getIrisClass());
			// System.out.println("weight : "+w);
		}
		String [] IrisClass=new String[3];
		int y=0;
		for(Object obj1 : set) {
			IrisClass[y++]=(String) obj1;
			//System.out.println(obj);
		}
		
		for(int i=0 ; i<k ; i++) {
			//System.out.println(arr[i]);
			
			if(obj[i].getIrisClass()==IrisClass[2]) {
				weightSetosa+=obj[i].getWeight();
			}
			else if (obj[i].getIrisClass()==IrisClass[1]) {
				weightVirginica+=obj[i].getWeight();
			}
			
			else if(obj[i].getIrisClass()==IrisClass[0]) {
				weightVersicolor+=obj[i].getWeight();
			}
		}
	//	System.out.println("weightSetosa : "+weightSetosa);
	//	System.out.println("weightVirginica : "+weightVirginica);
	//	System.out.println("weightVersicolor : "+weightVersicolor);
		if(weightSetosa<weightVirginica && weightVirginica>weightVersicolor ) return "Iris-virginica";
		else if(weightVirginica<weightVersicolor && weightSetosa<weightVersicolor) return "Iris-versicolor";
		else return "Iris-setosa";
		
	}
	
	/*public void knn_calculation(IrisSample query) {
		
		List <IrisSample> sampleDistance ;
		
		for(IrisSample sample : sampleList) {
			
			double dis=0.0;
			
			for(int i=0 ; i<4 ; i++ ) {
				dis =Math.pow(sample.getPetal_length()-query.getPetal_length(), 2)+
						Math.pow(sample.getPetal_width()-query.getPetal_width(), 2)+
						Math.pow(sample.getSepal_length()-query.getSepal_length(), 2)+
						Math.pow(sample.getSepal_width()-query.getSepal_width(), 2);
			}
			
			double distance=Math.sqrt(dis);
			sampleDistance.add(new IrisSample(distance,sample.getIrisClass()));
			
		}
		
		//IrisSample.sampleSort( sampleDistance);
		
		//Collections.sort(sampleDistance, new IrisSample());
		
		Collections.sort((List<T>) sampleDistance);
		
	}*/

}

package knnImplementation;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner input=new Scanner(System.in);
		System.out.print("ENter sepal_length : ");
		double sepal_length=input.nextDouble();
		
		System.out.print("ENter sepal_width : ");
		double sepal_width=input.nextDouble();
		
		
		System.out.print("ENter petal_length : ");
		double petal_length=input.nextDouble();
		
		System.out.print("ENter petal_width : ");
		double petal_width=input.nextDouble();
		
		System.out.print("ENter n : ");
		int n=input.nextInt();
		
		String path="C:\\Users\\Dell\\Downloads\\iris.data";
		
		Knn obj=new Knn();
		String [] str=obj.sample_creating(path, new IrisSample(sepal_length ,sepal_width,petal_length, petal_width), n);
		
		System.out.println("knn : "+str[0]);
		System.out.println("Dudani weighted Knn  : "+str[1]);
		
		System.out.println("/*******END*****/");
		
	}

}

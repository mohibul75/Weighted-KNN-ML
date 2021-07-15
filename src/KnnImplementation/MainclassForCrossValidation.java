package knnImplementation;

public class MainclassForCrossValidation {
	
	public static void main(String[]args) throws Exception {
		CrossValidation obj=new CrossValidation();
		obj.crossFoldValidation("C:\\Users\\Dell\\Downloads\\iris.data", 10);
		System.out.println("/*******END*****/");
	}

}

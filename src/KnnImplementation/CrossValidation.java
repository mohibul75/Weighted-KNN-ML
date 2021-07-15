package knnImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CrossValidation {
	
	private double total=0;
	
	public void crossFoldValidation(String datasetFile, int n) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(datasetFile));
		String line = "";

		int numOfSample = 0;
		List<String> lineArray = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			numOfSample++;
			lineArray.add(line);
		}

		Collections.shuffle(lineArray);
		String[] dataLine = lineArray.toArray(new String[lineArray.size()]);

		Random rand = new Random();

		int[] mark = new int[numOfSample];
		for (int j = 0; j < numOfSample ; j++) mark[j]=0;
		
		

		for (int i = 0; i < n; i++) {
			int tp = 0;
			int count = 0;
			List<Integer> li = new ArrayList<Integer>();
		//	int[] test = new int[]{0};

			//for (int j = 0; j < numOfSample / n; j++) {
				while (li.size() != 15) {
					int take = rand.nextInt(150);

					if (li.contains(take)) {
						continue;

					}
					else if(mark[take]==1){
						continue;
					}else {
						li.add(take);
						mark[take]=1;
					}
					
				}
			//}
				System.out.println(li);
				
				File fout = new File("out.txt");
				FileOutputStream fos = new FileOutputStream(fout);
			 
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			for (int j = 0; j < numOfSample; j++) {
				if (!li.contains(j)) {
					try {
						/*FileWriter fw = new FileWriter("myfile.txt", true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter out = new PrintWriter(bw) ;
							System.out.println(dataLine[j]);
						out.println(dataLine[j]);*/
					//	System.out.println(dataLine[j]);
						bw.write(dataLine[j]);
						
					//	if() {
							bw.newLine();
						//}
					} catch (IOException e) {
					}
				}
				
			}
			bw.close();

			for (int j = 0; j < li.size(); j++) {

				String[] str = dataLine[j].split(",");
				Knn obj1 = new Knn();
				String[] strArray = obj1.sample_creating("out.txt", new IrisSample(Double.parseDouble(str[0]),
						Double.parseDouble(str[1]), Double.parseDouble(str[2]), Double.parseDouble(str[3])),(numOfSample/n)*(n-1));
				
				System.out.println(str[4]+strArray[1]);

				if (str[4].equals(strArray[1])) {
					tp++;
				}

			}
			total+=(double) tp /(numOfSample/n) ;
			System.out.println("Round  :" + "    " + (i + 1) + "    " + ((double) tp /(numOfSample/n) ) * 100);
		}
		// AEON
	//	for (int j = 0; j < mark.length; j++) 	System.out.print(mark[j]);
		System.out.println("Avarage  :   "+(double) (total /n)  * 100);
	}
	
	
	public boolean takenOrNot(int[] arr , int x) {
		
		
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[x]!=0) return true;
		}
		
		return false;
	}

}/*package knnImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CrossValidation {
	
	public void crossFoldValidation(String datasetFile, int n) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(datasetFile));
		String line = "";

		int numOfSample = 0;
		List<String> lineArray = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			numOfSample++;
			lineArray.add(line);
		}

		Collections.shuffle(lineArray);
		String[] dataLine = lineArray.toArray(new String[lineArray.size()]);

		Random rand = new Random();

		int[] mark = new int[numOfSample];
		int count = 0;
		

		for (int i = 0; i < 10; i++) {
			int tp = 0;

			List<Integer> li = new ArrayList<Integer>();
			int[] test = new int[]{0};

			//for (int j = 0; j < numOfSample / n; j++) {
				while (li.size() != 15) {
					int take = rand.nextInt(150);

					if (takenOrNot(mark, take)) {
						continue;

					} else {
						mark[take] = 1;
						test[count++] = take;
						li.add(take);
					}

				}
			//}

			for (int j = 0; j < numOfSample; j++) {
				if (test[j]==0) {
					try (FileWriter fw = new FileWriter("myfile.txt", true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter out = new PrintWriter(bw)) {
						out.println(dataLine[j]);
					} catch (IOException e) {
					}
				}
			}

			for (int j = 0; j < test.length; j++) {

				String[] str = dataLine[j].split(",");
				Knn obj1 = new Knn();
				String[] strArray = obj1.sample_creating("myfile.txt", new IrisSample(Double.parseDouble(str[0]),
						Double.parseDouble(str[1]), Double.parseDouble(str[2]), Double.parseDouble(str[3])), n);

				if (str[4] == strArray[1]) {
					tp++;
				}

			}

			System.out.println("Round  :" + "    " + (i + 1) + "    " + ((double) tp / 15) * 100);
		}
		// AEON

	}
	
	
	public boolean takenOrNot(int[] arr , int x) {
		
		
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[x]!=0) return true;
		}
		
		return false;
	}

}
*/

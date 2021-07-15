package knnImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Helper {

	public static void main(String[] args) {
		
		boolean []mark=new boolean[15];
		int count=0;
		int []test=new int[15];
		Random rand=new Random();
		List<Integer> li=new ArrayList<Integer>();
		// TODO Auto-generated method stub

			
		while(li.size()!=15) {
			int take=rand.nextInt(15);
			
			if(takenOrNot(mark,take)) {
				continue;
				
			}
			else {
				mark[take]=true;
				test[count++]=take;
				//System.out.println(take);
				li.add(take);
			}
		}
			
			
		//}
		Collections.sort(li);
		System.out.println("size : "+li.size());
		System.out.println(li);
	}
	
	public static boolean takenOrNot(boolean[] arr , int x) {
		
		
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[x]==true) return true;
		}
		
		return false;
	}

}

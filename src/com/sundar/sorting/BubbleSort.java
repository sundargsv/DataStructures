package com.sundar.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int array[] = {2, 7, 4, 1, 5, 3};
		char array[] = {'Z', 'Y', 'X', 'W', 'V', 'U'};
		int n = array.length; char temp;
		boolean flag;
		/* run outer loop for */
		for(int i = 0; i < n - 1; i ++){
			flag = false;
			/*recordSize-i-1 this is because */
			for(int j = 0; j < n-1-i; j ++){
				if(array[j] > array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = true;
				}
			}
			System.out.println(+i+" times");// it should skip iteration for i = 5
			if(!flag)
				break;	
		}
		
		for(int k = 0; k < n; k ++)
			   System.out.println(array[k]);
	}







/*

for(int i = 1; i <= recordSize - 1; i ++){
	flag = false;
	recordSize-i-1 this is because 
	for(int j = 0; j <= recordSize-i-1; j ++){
		if(array[j] > array[j+1]){
			temp = array[j];/////
			array[j] = array[j+1];
			array[j+1] = temp;
			flag = true;
		}
	}
	System.out.println(+i+" times");// it should skip iteration for i = 5
	if(!flag)
		break;	
}*/
}

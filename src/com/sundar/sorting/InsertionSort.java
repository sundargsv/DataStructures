package com.sundar.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {2, 7, 4, 1, 5, 3};
		int recordSize = array.length, temp, curVal, holeIndex;
		boolean flag;
		for(int i = 1; i <= recordSize - 1; i ++){
			System.out.println("-----------------------------------");
			System.out.println("inside 1st loop i " +i);
			curVal = array[i];
			holeIndex = i;
			for(int j = i-1; j >= 0 ; j--){
				System.out.println("inside 2nd loop j " +j);
				if(curVal < array[j]){
					temp = array[j];
					array[j] = curVal;
					array[holeIndex] = temp;
					holeIndex = j; // update the index of curValue after the swapping
				}
				else{
					break;
				}
				for(int k = 0; k < recordSize; k ++)
					   System.out.print(array[k]+",");
				System.out.println("\n");
			}
		}
		/*for(int k = 0; k < recordSize; k ++)
			   System.out.println(array[k]);*/
	}

}

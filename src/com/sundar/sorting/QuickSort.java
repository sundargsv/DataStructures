package com.sundar.sorting;

import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int array[] = {2, 7, 1, 6, 8, 5, 3, 4};
		int start = 0, end = array.length - 1;
		QuickSort obj = new QuickSort();
		
		/* array - refers to the pointer/ reference variable/ address of the array[0] */
		obj.quickSort(array, start, end);
		
		for(int k = 0; k < array.length; k ++)
			   System.out.print(array[k]+",");
	}
	
	public void quickSort(int array[], int start, int end){
		if(start < end){
			int pIndex = randomizedPartition(array, start, end);
			quickSort(array, start, pIndex - 1);
			quickSort(array,  pIndex + 1, end);
		}
		
	}
	
	/*To make O(n log n) for avg case time complexity*/
	public int randomizedPartition(int array[], int start, int end){
		 Random rand = new Random();
		int pivotIndex = rand.nextInt(end - start + 1) + start, temp;
		temp = array[pivotIndex];
		array[pivotIndex] = array[end];
		array[end] = temp;
		int pIndex = partition(array, start, end);
		return pIndex;
	}

	public int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int pIndex = start;
		int temp;
		/*the elements less than pivot will have an last index of pIndex - 1 */
		for(int i = start; i <= end - 1; i ++){
			if(array[i] <= pivot){
				temp = array[i];
				array[i] = array[pIndex];
				array[pIndex] = temp;
				pIndex ++;
			}
		}
		
		temp = array[pIndex];
		array[pIndex] = array[end];
		array[end] = temp;
		return pIndex;
		
	}
	

}

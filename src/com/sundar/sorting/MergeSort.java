package com.sundar.sorting;

public class MergeSort {
	/*private static int count;*/
	public static void main(String[] args) {
		int array[] = {2, 4, 1, 6, 8, 5, 3, 7};
		MergeSort obj = new MergeSort();
		int sortedArray[] = obj.mergeSort(array);
		
		for(int k = 0; k < sortedArray.length; k ++)
			   System.out.print(sortedArray[k]+",");

	}

	public int[] mergeSort(int[] array){
		
		/*System.out.println(" ---- mergeSort called ----- " +(++count));
		for(int k = 0; k < array.length; k ++)
			   System.out.print(array[k]+",");
		System.out.println("-----------------------------------------");*/
		int recordSize = array.length, mid;
		mid = recordSize/ 2;
		if(recordSize < 2){
			/*If you return null, then right[] will be equals to null & so merge(left, null, array) - (you'll get nullPointer exception)*/
			return array;
		}
		/* create Auxiliary arrays */
		int leftArray[] = new int[mid];
		int rightArray[] = new int[recordSize - mid];
		
		for(int i = 0; i <= mid - 1; i ++)
			leftArray[i] = array[i];
		for(int j = mid; j <= recordSize - 1; j ++)
			rightArray[j-mid] = array[j];
		
		/* Partitioning in recursion manner */
		int left[] = mergeSort(leftArray);
		int right[] = mergeSort(rightArray);
		int sortedArray[] = merge(left, right, array);
		
		return sortedArray;
		
	}
	
	public int[] merge(int left[], int right[], int array[]){
		/*System.out.println(" Merging starts here ");*/
		int leftSize = left.length, rightSize = right.length;
		int i = 0,j = 0,k = 0;
		
		while(i < leftSize && j < rightSize){
			if(left[i] <= right[j]){
				/* we are overwriting the content array[index] */
				array[k] = left[i];
				i ++;
			}else{
				array[k] = right[j];
				j ++;
			}
			k ++;
		}
		
		/* If any one of the array - either left or right array is scanned completed, then complete the other (just append) */
		while(i < leftSize){
			array[k] = left[i];
			i ++; k ++;
		}
		while(j < rightSize){
			array[k] = right[j];
			j ++; k ++;
		}
		
		return array;
	}
}

package com.sundar.problemSolving;

public class ReverseArray {
	/* Function to reverse arr[] from start to end*/
    static void rvereseArray(int arr[], int start, int end)
    {
       /* 
        * O(n)
        * int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rvereseArray(arr, start+1, end-1);*/
    	int tmp;
    	while(start < end){
    		tmp = arr[start];
    		arr[start] = arr[end];
    		arr[end] = tmp;
    		start++;
    		end--;
    	}
    }
 
    /* Utility that prints out an array on a line */
    static void printArray(int arr[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
 
    /*Driver function to check for above functions*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, 6);
        rvereseArray(arr, 0, 5);
        System.out.println("Reversed array is ");
        printArray(arr, 6);
    }
}

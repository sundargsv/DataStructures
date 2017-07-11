package com.sundar.problemSolving;

public class MergeArrays {
	
	
	    /* Function to move m elements at the end of array mPlusN[] */
	    void moveToEnd(int mPlusN[], int size) 
	    {
	    	int tmp;
	        int i, j = size - 1;
	        for (i = size - 1; i >= 0; i--) 
	        {
	            if (mPlusN[i] != -1) 
	            {
	            	tmp = mPlusN[j];
	                mPlusN[j] = mPlusN[i];
	                mPlusN[i] = tmp;
	                j--;
	            }
	        }
	    }
	 
	    /* Merges array N[] of size n into array mPlusN[]
	       of size m+n*/
	    void merge(int mPlusN[], int N[], int m, int n) 
	    {
	        int i = n;
	         
	        /* Current index of i/p part of mPlusN[]*/
	        int j = 0;
	         
	        /* Current index of N[]*/
	        int k = 0;
	         
	        int mn_length = mPlusN.length;
	        int n_length = N.length;
	        //while(i<mn_length &&j<n_length){="" if(mn[i]="">n[j])
	        /* Current index of of output mPlusN[]*/
	        while (k < (m + n)) 
	        {
	            /* Take an element from mPlusN[] if
	            a) value of the picked element is smaller and we have
	                not reached end of it
	            b) We have reached end of N[] */
	            if ((j == n) || (i < (m + n) && mPlusN[i] <= N[j]) )
	            {
	                mPlusN[k] = mPlusN[i];
	                k++;
	                i++;
	            } 
	            else // Otherwise take element from N[]
	            {
	                mPlusN[k] = N[j];
	                k++;
	                j++;
	            }
	        }
	    }
	 
	    /* Utility that prints out an array on a line */
	    void printArray(int arr[], int size) 
	    {
	        int i;
	        for (i = 0; i < size; i++) 
	            System.out.print(arr[i] + " ");
	 
	        System.out.println("");
	    }
	 
	    public static void main(String[] args) 
	    {
	        MergeArrays mergearray = new MergeArrays();
	         
	        /* Initialize arrays */
	        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
	        int N[] = {5, 7, 9, 25};
	        int n = N.length;
	        int m = mPlusN.length - n;
	        System.out.println("N : " +n);
	        System.out.println("M : " +m);
	        
	        /*Move the m elements at the end of mPlusN*/
	        mergearray.moveToEnd(mPlusN, m + n);
	 
	        /*Merge N[] into mPlusN[] */
	        mergearray.merge(mPlusN, N, m, n);
	 
	        /* Print the resultant mPlusN */
	        mergearray.printArray(mPlusN, m + n);
	    }
}
	 

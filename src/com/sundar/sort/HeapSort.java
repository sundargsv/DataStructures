package com.sundar.sort;

import java.util.Scanner;

public class HeapSort {
	
	private static int N;
	
	public static void sort(int arr[])
    {       
        heapify(arr);        
        for (int i = N; i > 1; i--)
        {
            swap(arr,1, i);
            N = N-1;
            maxheap(arr, 1);
        }
    }  
	
	/* Function to build a Max heap */   
    public static void heapify(int arr[])
    {
        N = arr.length-1;//6
        for (int i = N/2; i >= 1; i--)
            maxheap(arr, i);        
    }
    
    /* Function to swap largest element in heap */        
    public static void maxheap(int arr[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }    
    /* Function to swap two numbers in an array */
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }    

	
	public static void main(String[] args) 
    {
        Scanner scan = new Scanner( System.in );        
        System.out.println("Heap Sort Test\n");
        int n, i;    
        
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();  //6  
        n ++; // Heap array starts from 1 - 7
        int arr[] = new int[ n ];
      
        System.out.println("\nEnter "+ (n-1) +" integer elements");
        for (i = 1; i < n; i++)// 1 to 6
            arr[i] = scan.nextInt();
       
        sort(arr);
        
        
        System.out.println("\nElements after sorting ");        
        for (i = 1; i < n; i++)
            System.out.print(arr[i]+" ");            
        System.out.println();            
    }    
}

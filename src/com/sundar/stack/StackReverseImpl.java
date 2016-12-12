package com.sundar.stack;

import java.util.*;

public class StackReverseImpl{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Stack Reverse test\n");
        System.out.println("Enter the string");
        StringBuilder name  = new StringBuilder(scan.nextLine());      
        System.out.println("Your name is : " +name);
       
        int size = name.length(), i = 0;
        ArrayStackModel stack = new ArrayStackModel(size);
        System.out.println("Size :" +size);
        System.out.println("Inserting each characters into Stack");
        while(i < size){
        	//System.out.println(name.charAt(i));
        	stack.push(name.charAt(i));
        	i++;
        }
        System.out.println("Successfully pushed into stack");
        stack.display();
        System.out.println("Check top of the stack:"+stack.peek());
        System.out.println("\n");
        System.out.println("Updating string name in reverse order with the help of stack");
        int j = 0;
        while(j < size){
        	
        	name.setCharAt(j, stack.pop());
        	j++;
        }
        System.out.println("Reversed string is : "+name);
       
        
       
     
        
	}

}

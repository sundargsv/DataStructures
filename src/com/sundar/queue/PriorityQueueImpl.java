package com.sundar.queue;

import java.util.Scanner;

public class PriorityQueueImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        System.out.println("Priority Queue Implementation\n");   
 
        System.out.println("Enter size of priority queue ");
        PriorityQueue pq = new PriorityQueue(scan.nextInt() );
 
        char ch;
        /*  Perform Priority Queue operations */
        do    
        {
            System.out.println("\nPriority Queue Operations\n");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. check empty");
            System.out.println("4. check full");
            System.out.println("5. size");
 
            int choice = scan.nextInt();
            switch (choice) {
            case 1 : 
                System.out.println("Enter job name and priority");
                try{
                	pq.insert(scan.next(), scan.nextInt() );   
                }catch (Exception e) {
					System.err.println(e);
				}
                                  
                break;                          
            case 2 : 
            	try{
            		pq.remove(); 
                }catch (Exception e) {
					System.err.println(e);
				}
                //
                break;        
            case 3 : 
                System.out.println("\nEmpty Status : "+ pq.isEmpty() );
                break; 
            case 4 : 
                System.out.println("\nFull Status : "+ pq.isFull() );
                break; 
               
            case 5 : 
                System.out.println("\nSize = "+ pq.getSize() );
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }    
			
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');            
   }

}

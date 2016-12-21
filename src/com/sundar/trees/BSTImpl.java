package com.sundar.trees;

import java.util.Scanner;

public class BSTImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        /* Creating object of BST */
		BinarySearchTree bst = new BinarySearchTree();
		 System.out.println("Singly Linked List Test\n");          
	     char ch;
	     /*  Perform BST operations  */
		do{
			 System.out.println("\nSingly Linked List Operations\n");
	            System.out.println("1. Insert");
	            System.out.println("2. Check isEmpty");
	            System.out.println("3. Count of nodes");
	            System.out.println("4. Delete");
	            System.out.println("5. Traverse in level order");
	            System.out.println("6. Find an element");
	            System.out.println("7. Pre order traversal");
	            System.out.println("8. In order traversal");
	            System.out.println("9. Post order traversal");
         
	            int choice = scan.nextInt();            
	            switch (choice){
		            case 1 : 
		                System.out.println("Enter data to insert");
		                bst.insert( scan.nextInt() );                     
		                break;
		            case 2 : 
		                System.out.println("Tree Empty ? : "+bst.isEmpty());             
		                break;
		            case 3 : 
		                System.out.println("No of Nodes in tree : "+bst.getCount());             
		                break;
		            case 4 : 
		                System.out.println("Enter data to delete");
		                bst.delete(scan.nextInt());
		                break;
		            case 5 :
		            	bst.levelOrderDisplay();
		            	break;
		            case 6 :
		            	System.out.println("Enter data to search");
		            	
		            		boolean result = bst.search(scan.nextInt());
		            		if(result)
		            			System.out.println("True");
		            		else
		            			System.out.println("False");
		            		break;
		            case 7 :
		            	bst.preOrderTraversal();
		            	break;
		            case 8 :
		            	bst.inOrderTraversal();
		            	break;
		            case 9 :
		            	bst.postOrderTraversal();
		            	break;
		           default :
		        	   System.out.println("Select the correct option");
		        	   break;
		        	 
	            }System.out.println("\nDo you want to continue (Type y or n) \n");
	            ch = scan.next().charAt(0);                        
	        } while (ch == 'Y'|| ch == 'y');
	}

}

package com.sundar.graph;

import java.util.List;
import java.util.Scanner;

public class GraphImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int source, destination;
        int number_of_edges,number_of_vertices;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices in graph");
        number_of_vertices = scan.nextInt();
        //number_of_edges = scan.nextInt();
        GraphAdjacencyList adjacencyList = new GraphAdjacencyList(number_of_vertices);
        List<Integer> edgeList;
        int choice;
        char choose;
        
        do{
        	
        	 System.out.println("\nChoose any one operation from the number list\n");
             System.out.println("1.Set edge");
             System.out.println("2.Get edge");
             System.out.println("3.Display all edge connection");
             System.out.println("4.Get Connection count/ edge count");
             System.out.println("5.Remove edge/ connection");
             choice = scan.nextInt();
             switch (choice) {
     		case 1:
     			System.out.println("Enter the source & destination to create new connection");
     			adjacencyList.setEdge(scan.nextInt(), scan.nextInt());
     			break;
     		case 2:
     			System.out.println("Enter the source to get all the routes");
     			edgeList = adjacencyList.getEdge(scan.nextInt());
     			for (Integer integer : edgeList) {
    				System.out.println(integer.intValue()+"->");
    			}
     			break;
     		case 3:
     			adjacencyList.DisplayAllEdges();
     			break;
     		case 4:
     			System.out.println(adjacencyList.getConnectionSize());
     			break;
     		case 5:
     			System.out.println("Enter the source & destination to remove the connection");
     			adjacencyList.removeEdge(scan.nextInt(), scan.nextInt());
     			break;
     		default:
     			System.out.println("Sorry your input wasn't recognized ");
     			break;
     		}
        	System.out.println("\nDo you want to continue (Type y or n) \n");
        	choose = scan.next().charAt(0); 
        }while(choose == 'Y' || choose == 'y');
      
        
        
        
	}

}

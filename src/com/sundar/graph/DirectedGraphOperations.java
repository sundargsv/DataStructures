package com.sundar.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

public class DirectedGraphOperations {
	private ArrayList<Integer> vertices = new ArrayList<Integer>();
	private Map<Integer, List<Integer>> adjacencyList;
	static int connectionCount;
	private static int vertexCount;
	public DirectedGraphOperations(ArrayList<Integer> vertexList) {
		super();
		adjacencyList = new HashMap<Integer, List<Integer>>();
				
				connectionCount = 0;
				vertexCount = vertexList.size();
				for (Integer integer : vertexList) {
					vertices.add(integer);
					 //new List<Integer>() List type cannot be instantiated 
						adjacencyList.put(integer, new LinkedList<Integer>());
				}
	}
	
	public int getConnectionSize() {
		return DirectedGraphOperations.connectionCount;
	}
	
	public void setEdge(int source, int destination){
		if(source > adjacencyList.size() || destination > adjacencyList.size())
			throw new NoSuchFieldError("No such Vertex/ source/ destination exists !!!");
		List<Integer> sourceList = adjacencyList.get(source);
		sourceList.add(destination);
				
		connectionCount ++;
		
	}
	
	public List<Integer> getEdge(int source){
		if(source > adjacencyList.size())
			throw new NoSuchFieldError("No such Vertex/ source exists !!!");
		return adjacencyList.get(source);
		
	}
	
	
	public void removeEdge(int vertex1, int vertex2){
			
			if(vertex1 > adjacencyList.size() || vertex2 > adjacencyList.size())
				throw new NoSuchFieldError("No such Vertex/ source/ destination exists !!!");
			boolean removedFlag1, removedFlag2;
			removedFlag1 = removeConnection(vertex1, vertex2);
			if(removedFlag1){
				
				
					System.out.println("Connection removed in 1-way");
					connectionCount --;
				
			}else{
				System.out.println("There is no such connection");
			}
				
		}
	
	public boolean removeConnection(Integer source, Integer destination){
		List<Integer> edgeList = adjacencyList.get(source);
		boolean removedFlag = false;
		if(edgeList.contains(destination)){
			edgeList.remove(destination);
			removedFlag = true;
		}
		return removedFlag;
	}
	
	public void DisplayAllEdges(){
		for(int i = 1; i <= adjacencyList.size(); i ++){
			/* Collecting all edgeList for the (i) vertex */
			List<Integer> edgeList = adjacencyList.get(i);
			System.out.println("Edge List for vertex : "+i);
			for (Integer integer : edgeList) {
				System.out.println("->"+integer.intValue());
			}
		}
	}
	
	public void topologicalSort(int startVertex, boolean []visited, Stack<Integer> stack){
		visited[startVertex] = true;
		/* collect all the Adj nodes/ child of all the startVertex */
		 ListIterator<Integer> adjVertexList = adjacencyList.get(startVertex).listIterator();
		while(adjVertexList.hasNext()){
			/* because it starts from -1 */
			int n = adjVertexList.next();
			if(!visited[n]){
				visited[n] = true;
				topologicalSort(n, visited, stack);
			}
		}
		
		/* Add the vertex into the stack only when all its child has been explored */
		stack.push(new Integer(startVertex));
	}
	
	void topologicalSort()
    {
		/* Add the vertex into the stack only when all its child has been explored */
        Stack<Integer> stack = new Stack<Integer>();
 
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++)
            visited[i] = false;
 
        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < vertexCount; i++)
            if (visited[i] == false)
                topologicalSort(i, visited, stack);
 
        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }
}

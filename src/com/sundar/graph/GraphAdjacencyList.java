package com.sundar.graph;

import java.util.*;

public class GraphAdjacencyList {

	private ArrayList<Integer> vertices = new ArrayList<Integer>();
	private Map<Integer, List<Integer>> adjacencyList;
	private static int connectionCount;
	private static int vertexCount;
	public GraphAdjacencyList(ArrayList<Integer> vertexList) {
		super();
		adjacencyList = new HashMap<Integer, List<Integer>>();
		
		connectionCount = 0;
		vertexCount = vertexList.size();
		for (Integer integer : vertexList) {
			vertices.add(integer);
			 //new List<Integer>() List type cannot be instantiated 
				adjacencyList.put(integer, new LinkedList<Integer>());
		}
		/*for(int i = 0; i <= vertexCount - 1; i ++){
			
			 new List<Integer>() List type cannot be instantiated 
			adjacencyList.put(i, new LinkedList<Integer>());
			
		}*/
	}
	
	public int getConnectionSize() {
		return GraphAdjacencyList.connectionCount;
	}
	
	/* If graph is an un-directed graph, then the edge  should be both side connected */
	public void setEdge(int source, int destination){
		if(source > adjacencyList.size() || destination > adjacencyList.size())
			throw new NoSuchFieldError("No such Vertex/ source/ destination exists !!!");
		List<Integer> sourceList = adjacencyList.get(source);
		sourceList.add(destination);
		List<Integer> destinationList = adjacencyList.get(destination);
		destinationList.add(source);
		
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
			removedFlag2 = removeConnection(vertex2, vertex1);
			if(removedFlag2){
				System.out.println("Connection removed in 2-way");
				connectionCount --;
			}
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
	
	public void BFS_LevelOrderTraversal(int startVertex, boolean []visited){
		int currVertex;
		// Mark all the vertices as not visited(By default set as false)
  		//visited[] = new boolean[vertexCount];
  		
  		 // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
     // Mark the current node as visited and enqueue it
        visited[startVertex]=true;
        queue.add(startVertex);
        
        while(queue.size() != 0){
        	//Retrieve & dequeue the head by poll
        	currVertex = queue.poll();
        	System.out.print(currVertex+" ");
        	
        	// Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
           // Iterator<Integer> i = (Iterator<Integer>) adjacencyList.get(currVertex);
            ListIterator<Integer> i = adjacencyList.get(currVertex).listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
  		
		
	}
	
	/*
	 * Note that the above code traverses only the vertices reachable from a given source vertex. 
	 * All the vertices may not be reachable from a given vertex (example Disconnected graph). 
	 * To print all the vertices, 
	 * we can modify the BFS function to do traversal starting from all nodes one by one*/
	public void BFS(){
		boolean visited[] = new boolean[vertexCount];
		for (Integer integer : vertices) {
			 if (visited[integer] == false)
	                BFS_LevelOrderTraversal(integer, visited);
		}
	}
	
	void DFS_withStartVertex(int startVertex,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[startVertex] = true;
        System.out.print(startVertex+" ");
 
        // Recur for all the vertices adjacent to this vertex
        ListIterator<Integer> i = adjacencyList.get(startVertex).listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
            	DFS_withStartVertex(n,visited);
        }
    }
	
	public void DFS(){
		// Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[vertexCount];
 
        // Call the recursive helper function to print DFS traversal
        // starting from all vertices one by one
        // visited is the reference to track all visited nodes
        for (int i=0; i<vertexCount; ++i)
            if (visited[i] == false)
                DFS_withStartVertex(i, visited);
	}
}

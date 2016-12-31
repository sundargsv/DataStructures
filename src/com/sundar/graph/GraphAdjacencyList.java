package com.sundar.graph;

import java.util.*;

public class GraphAdjacencyList {

	private Map<Integer, List<Integer>> adjacencyList;
	private static int connectionCount;
	public GraphAdjacencyList(int numberOfVertices) {
		super();
		adjacencyList = new HashMap<Integer, List<Integer>>();
		connectionCount = 0;
		for(int i = 1; i <= numberOfVertices; i ++){
			/* new List<Integer>() List type cannot be instantiated */
			adjacencyList.put(i, new LinkedList<Integer>());
			
		}
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
}

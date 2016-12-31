package com.sundar.graph;

import java.util.*;

import com.sundar.graphs.models.GraphWeightedUndirected;

public class GraphAdjListWithObj {

	
	private ArrayList<String> cities = new ArrayList<String>();
	private Map<String, List<GraphWeightedUndirected>> adjacencyList;
	private static int connectionCount;
	
	public GraphAdjListWithObj(ArrayList<String> cityList) {
		super();
		adjacencyList = new HashMap<String, List<GraphWeightedUndirected>>();
		connectionCount = 0;
		
		for (String string : cityList) {
			cities.add(string);
			adjacencyList.put(string, new LinkedList<GraphWeightedUndirected>());
		}			
		
	}
	
	public int getConnectionSize() {
		return GraphAdjListWithObj.connectionCount;
	}
	
	public void setEdge(String source, String destination, int weight){
		if(! cities.contains(source) || ! cities.contains(destination))
			throw new NoSuchFieldError("No such Vertex/ source/ destination exists !!!");
		GraphWeightedUndirected edgeConnection = new GraphWeightedUndirected();
		
		edgeConnection.setSource(source);
		edgeConnection.setDestination(destination);
		edgeConnection.setWeighted(weight);
		List<GraphWeightedUndirected> sourceList = adjacencyList.get(source);
		
		if(sourceList.add(edgeConnection)){
			edgeConnection = new GraphWeightedUndirected();
			edgeConnection.setSource(destination);
			edgeConnection.setDestination(source);
			edgeConnection.setWeighted(weight);
			List<GraphWeightedUndirected> destinationList = adjacencyList.get(destination);
			destinationList.add(edgeConnection);
			connectionCount ++;
		}
	}
	
	public List<String> getEdge(String source){
		if(! cities.contains(source))
			throw new NoSuchFieldError("No such Vertex/ source exists !!!");
		List<String> destinationList = new ArrayList<>();
		List<GraphWeightedUndirected> gr = adjacencyList.get(source);
		for (GraphWeightedUndirected graphWeightedUndirected : gr) {
			destinationList.add(graphWeightedUndirected.getDestination());
		}
		return destinationList;
		
	}
	
	
	
}

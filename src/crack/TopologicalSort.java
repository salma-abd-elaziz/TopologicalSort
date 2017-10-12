package crack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
	
	 public int[] topoSort(ArrayList<Integer> graph[],int N)
     {
		// Queue that holds the nodes to process.
        Queue<Integer> processNext = new LinkedList<Integer>();
        // The result array and it Index;
        int[] result = new int [N];
        int index = 0;
        // To count the number of in bound edges for each node;.
        int[] inBound = new int [N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < graph[i].size(); j++){
            	int n = graph[i].get(j);
                inBound[n]++; 
            } 
        }
        for (int i = 0; i < N; i++){
        	if (inBound[i] == 0) processNext.add(i);
        }
        
        while (!processNext.isEmpty()) {
        	int n = processNext.poll();
        	ArrayList<Integer> nodes =  graph[n];
        	// For every edge (n, x).
        	for (int i = 0; i < nodes.size(); i++) {
        		int x = nodes.get(i);
        		// Remove in bound edge. 
        		inBound[x]--;
        		// Check if the node i has no in bound edges any more.
        		if (inBound[x] == 0) processNext.add(x); 
        	}
        	result[index] = n;
        	index++;
        }
        // If result dosn't contain all the nodes then there is a 
        // cycle in this case return null.
        if (result.length == N) return result;
        else return null;
        
    }
}
package crack;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int N = 6;
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] graph = new ArrayList [N];
		TopologicalSort o = new TopologicalSort();
		for (int i = 0; i < N; i++){
			graph[i] = new ArrayList<Integer>();
		}
		
		// constructing the graph. 
		// Without a cycle 
		/*graph[2].add(3);
		graph[3].add(1);
		graph[4].add(0);
		graph[4].add(1);
		graph[5].add(0);
		graph[5].add(2);*/
		///
		
		// With cycle.
		graph[0].add(5);
		graph[2].add(3);
		graph[3].add(1);
		graph[4].add(0);
		graph[4].add(1);
		graph[5].add(0);
		graph[5].add(2);
		///
		
		int[] r = o.topoSort(graph, N);
		if (r == null) System.out.println(" There is a Cycle in the graph");
        for (int i = 0; r != null && i < r.length; i++){
        	System.out.println( i +" -> "+ r[i]);
        }
	}

}

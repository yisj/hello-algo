

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int solution(int n, int[][] edge) {
		
		HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i=1; i<=n; i++) {
			adj.put(i, new ArrayList<>());
		}
				
		for(int[] e : edge) {
			int from = e[0];
			int to = e[1];
			adj.get(from).add(to);
			adj.get(to).add(from);
		}
		
		boolean[] visited = new boolean[n+1];
		Queue<int[]> q = new LinkedList<int[]>();
		visited[1] = true;
		q.offer(new int[] { 1, 0});
		int maxDepth = 0;
		int maxCnt= 1;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[1] > maxDepth) {
				maxDepth = curr[1];
				maxCnt=1;
			} else if(curr[1] == maxDepth) {
				maxCnt++;
			}
			
			for(int adjNode : adj.get(curr[0])) {
				if (!visited[adjNode]) {
					visited[adjNode] = true;
					q.add(new int[] {adjNode, curr[1]+1});
				}
			}
		}
		
        return maxCnt;
    }
	

}

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[][] adj;

    public int solution(int n, int[][] wires) {
        adj = new int[n+1][n+1];
        for(int i=0; i<wires.length; i++){
            adj[wires[i][0]][wires[i][1]] = adj[wires[i][1]][wires[i][0]] = 1;
        }

        int min = n;

        for(int[] wire: wires){
            adj[wire[0]][wire[1]] = adj[wire[1]][wire[0]] = 0;
            boolean[] visited = new boolean[n+1];
            visited[1] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            int cnt =1;
            while(!q.isEmpty()){
                int curr = q.poll();

                for(int i=1; i<=n ;i++){
                    if(adj[curr][i] == 1 && !visited[i]){
                        visited[i] = true;
                        q.add(i);
                        cnt++;
                    }
                }
            }
            int diff = Math.abs(n-cnt - cnt);
            if(diff < min) min = diff;
            adj[wire[0]][wire[1]] = adj[wire[1]][wire[0]] = 1;

        }


        return min;
    }

}

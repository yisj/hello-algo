import java.util.Arrays;

public class Solution {
    
    int[] arr;
    boolean[] visited;
    int max;
    int[][] dungeons;
    int k;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        arr = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        max = 0;
        this.k = k;
        perm(0);

        return max;
    }

    private void perm(int idx) {
        if(idx == dungeons.length){
            // System.out.println(Arrays.toString(arr));
            int currK = k;
            int cnt = 0;
            for(int i=0; i<arr.length; i++){
                int[] curr = dungeons[arr[i]];
                if(currK < curr[0]) return;
                currK -= curr[1];
                cnt++;
                if(cnt > max) max=cnt;
            }          
            return;
        }

        for(int i=0; i<dungeons.length; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[idx] = i;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }

}

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 가로: m, 세로: n
        int[][] dp = new int[n+1][m+1];
        boolean[][] puddle = new boolean[n+1][m+1];

        for(int[] p : puddles){
            puddle[p[1]][p[0]] = true;
        }

        dp[1][1] = 1;
        for(int c=2; c<=m; c++){
            if(!puddle[1][c])
                dp[1][c] = 1;
            else break;
        }
        for(int r=2; r<=n; r++)
            if(!puddle[r][1])
                dp[r][1] = 1;
            else break;

        for(int r=2; r<=n; r++){
            for(int c=2; c<=m; c++){
                if(puddle[r][c]) continue;
                else
                    dp[r][c] = (dp[r-1][c] + dp[r][c-1])%1000000007;
            }
        }

        int answer = dp[n][m];
        return answer;
    }
}

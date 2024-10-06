import java.util.*;

public class Solution {
    public int solution(int[][] triangle) {
        
        int[][] dp = new int[triangle.length][];
        for(int i=0; i<triangle.length; i++){
            dp[i] = new int[i+1];
        }

        dp[0][0] = triangle[0][0];
        for(int i=1; i<triangle.length; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for(int j=1; j<i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1]+triangle[i][j],dp[i-1][j]+triangle[i][j]);
            }
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }

        // for(int i=0; i<triangle.length; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        

        int answer = 0;
        for(int j=0; j<triangle.length; j++){
            if(dp[triangle.length-1][j] > answer)
                answer = dp[triangle.length-1][j];
        }
        return answer;
    }

}

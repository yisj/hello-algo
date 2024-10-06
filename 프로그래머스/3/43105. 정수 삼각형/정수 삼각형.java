import java.util.*;

public class Solution {
    public int solution(int[][] triangle) {
        
        int[][] dp = new int[triangle.length][];
        for(int i=0; i<triangle.length; i++){
            dp[i] = new int[i+1];
        }

        for(int j=0; j<triangle.length; j++)
            dp[triangle.length-1][j] = triangle[triangle.length-1][j];


        for(int i=triangle.length-2; i>=0; i--){
            for(int j=0; j<=i;j++){
                dp[i][j] = triangle[i][j]+Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        
        return dp[0][0];
    }
}

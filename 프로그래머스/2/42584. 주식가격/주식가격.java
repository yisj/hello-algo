import java.util.Arrays;

public class Solution {
    
    public int[] solution(int[] prices) {
        
        int[] end = new int[prices.length];
        int i=0;
        int j=0;
        
        while(i<prices.length){
            while(j < prices.length-1 && prices[i] <= prices[j]) j++;
            end[i] = j;
            j=++i;
        }


        int[] answer = new int[prices.length];
        for(i=0; i<answer.length; i++)
            answer[i] = end[i] - i;


        return answer;
    }

}

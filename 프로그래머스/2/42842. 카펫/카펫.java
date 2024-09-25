import java.util.Arrays;

public class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i=1; i<=yellow; i++){
            if(yellow % i == 0){
                int h = i;
                int w = yellow / h;
                if(w >= h){
                    if(2*w+2*h+4 == brown){
                        return new int[]{w+2, h+2};
                    }
                }
            }
        }

        int[] answer = {};
        return answer;
    }

}
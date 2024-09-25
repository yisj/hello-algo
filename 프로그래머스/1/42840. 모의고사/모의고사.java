import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        int[] cnt = new int[4];
        for(int i=0; i<answers.length; i++){
            if(answers[i] == a[i%a.length]) cnt[1]++;
            if(answers[i] == b[i%b.length]) cnt[2]++;
            if(answers[i] == c[i%c.length]) cnt[3]++;
        };
        int max = 0;
        for(int i=1; i<=3; i++){
            if(cnt[i] > max) max = cnt[i];
        }

        ArrayList<Integer> num = new ArrayList<>();
        for(int i=1; i<=3; i++){
            if (cnt[i] == max) num.add(i);
        }
        

        int[] answer = new int[num.size()];
        for(int i=0; i<num.size(); i++)
            answer[i] = num.get(i);
        return answer;
    }
    
}

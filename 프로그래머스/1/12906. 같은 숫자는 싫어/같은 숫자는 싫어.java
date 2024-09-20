import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        ArrayList<Integer> list = new ArrayList<>();        
        list.add(arr[0]);
        int curr = arr[0];
        for(int i=1; i<arr.length;i++){
            if(arr[i] != curr){
                list.add(arr[i]);
                curr = arr[i];
            }
        }
        int[] answer= new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}
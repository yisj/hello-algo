import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) == null) {
                map.put(nums[i], 0);
            }
        }
        
        int answer = Math.min(nums.length/2, map.keySet().size());
        return answer;
    }
}
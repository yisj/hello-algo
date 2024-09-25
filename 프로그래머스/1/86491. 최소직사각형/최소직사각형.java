public class Solution {
    public int solution(int[][] sizes) {
        int h = 0;
        int w = 0;
        for(int[] size : sizes){
            int a = size[0];
            int b = size[1];
            if(a > b){
                if(a> w) w = a;
                if(b >h) h = b;
            } else {
                if(b>w) w = b;
                if(a>h) h = a;
            }
        }
        int answer = w*h;
        return answer;
    }

}

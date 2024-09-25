import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        int size= 10000;

        Arrays.sort(citations);
        int[] cnt = new int[size+1];
        for(int i=0; i<citations.length; i++){
            cnt[citations[i]]++;
        }
        int[] prefix = new int[size+1];
        prefix[0] = cnt[0];
        for(int i=1; i<=size; i++){
            prefix[i] = prefix[i-1]+cnt[i];
        }

        int[] suffix = new int[size+1];
        suffix[size] = cnt[size];
        for(int i=size-1; i>=0; i--){
            suffix[i] = suffix[i+1]+cnt[i];
        }
        int h = 0;
        for(int i=0; i<=size; i++){
            int up = suffix[i];
            int down = prefix[i];
            if(up >= i && down <= i && i > h) h = i;
        }
        return h;
    }
}

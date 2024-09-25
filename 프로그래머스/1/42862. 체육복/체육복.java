public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int[] cnt = new int[n+1];
        for(int l : lost)
            cnt[l] = -1;
        for(int r : reserve)
            cnt[r] += 1;

        for(int i=1; i<=n ;i++){
            if(cnt[i] == -1){
                if( i>1 && cnt[i-1]==1){
                    cnt[i-1] = 0;
                    cnt[i] = 0;
                } else if(i<n && cnt[i+1]==1){
                    cnt[i] = 0;
                    cnt[i+1] =0;
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=n; i++)
            if(cnt[i] >= 0) ans++;
        
        return ans;
    }
}

import java.util.HashSet;

public class Solution {
    boolean[] visited;

    String numbers;
    int cnt;
    HashSet<Integer> set;

    public int solution(String numbers) {
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        cnt = 0;
        set = new HashSet<>();
        perm(0, "");

        int answer=cnt;

        return answer;
    }

    private void perm(int idx, String num) {
        if(num.length() > 0){
            int n = Integer.parseInt(num);
            // System.out.println(num);
            if(!set.contains(n)){
                set.add(n);
                // System.out.println(n);
            
                if(prime(n)) cnt++;
            }
        }

        if(idx == numbers.length()){
            return;
        }

        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                perm(idx+1, num+numbers.charAt(i));
                visited[i] =false;
            }
        }

    }

    private boolean prime(int n) {
        if(n == 1 || n==0) return false;
        for(int i=2; i<= n/2; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}

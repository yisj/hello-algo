import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Num implements Comparable<Num> {
    int num;
    int cnt;

    Num(int num){
        this.num = num;
        this.cnt = 1;
    }

    @Override
    public int compareTo(Num o) {
        return Integer.compare(this.num, o.num);
    }
}

class Solution {
    public int[] solution(String[] operations) {
        HashSet<Num> set = new HashSet<>();
        HashMap<Integer, Num> map = new HashMap<>();

        for(String o : operations) {
            StringTokenizer st = new StringTokenizer(o);
            char c = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if(c == 'I') {
                if(!map.containsKey(num)){
                    Num n = new Num(num);
                    map.put(num, n);
                    set.add(n);
                } else {
                    map.get(num).cnt++;
                }
            } else if(num == -1) {
                if(set.size() == 0) continue;
                int min_num = Collections.min(set).num;
                if(map.containsKey(min_num)){
                    map.get(min_num).cnt--;
                    if(map.get(min_num).cnt == 0){
                        set.remove(Collections.min(set));
                        map.remove(min_num);
                    }
                }
            } else {
                if(set.size() == 0) continue;
                int max_num = Collections.max(set).num;
                if(map.containsKey(max_num)){
                    map.get(max_num).cnt--;
                    if(map.get(max_num).cnt == 0){
                        set.remove(Collections.max(set));
                        map.remove(max_num);
                    }
                }
            }
        }

        if (set.size() == 0) {
            return new int[] {0, 0};
        } else {
            return new int[] {Collections.max(set).num, Collections.min(set).num };
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        int num;

 
        public Meeting(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end){
                return this.start - o.start;
            }
            return this.end - o.end;          
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> pq = new PriorityQueue<>();


        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            int num = Integer.valueOf(st.nextToken());

            pq.add(new Meeting(start, end, num));
        }

        // dp tables
        int[] nums = new int[N+1];
        int[] ends = new int[N+1];

        int idx=0;
        while(!pq.isEmpty()){
            Meeting m = pq.poll();
            idx++;

            
            int maxNum = 0;
            int maxEnd = 0;
            for(int i=0; i < idx; i++){
                if(ends[i] <= m.start){
                    int num = nums[i] + m.num;
                    if(num > maxNum) {
                        maxNum = num;
                        maxEnd = m.end;
                    }
                }
            }
            
            if (maxNum < nums[idx-1]){
                maxNum = nums[idx-1];
                maxEnd = ends[idx-1];
            } else if(maxNum == nums[idx-1]){
                maxEnd = Math.min(maxEnd, ends[idx-1]);
            }

            nums[idx] = maxNum;
            ends[idx] = maxEnd;
        }

        System.out.println(nums[N]);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {
    
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end){
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Meeting(start, end));
        }
        
        int curr = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            Meeting m = pq.poll();
            if(m.start >= curr){
                cnt++;
                curr = m.end;
            }
        }

        System.out.println(cnt);

    }
}
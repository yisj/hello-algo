import java.util.PriorityQueue;

class Food implements Comparable<Food> {
    int scoville;

    Food(int scoville){
        this.scoville = scoville;
    }

    @Override
    public int compareTo(Food o) {
        return this.scoville - o.scoville; // 오름차순
    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(new Food(scoville[i]));
        }
        
        int answer = 0;
        while(!pq.isEmpty()){
            if(pq.peek().scoville >=K) break;
            Food min = pq.poll();
            Food second = null;
            if(!pq.isEmpty())
                second = pq.poll();
            else{
                if (min.scoville < K) return -1;
                else break;
            }
                
            answer++;
            int s = min.scoville + second.scoville*2;
            pq.add(new Food(s));
        }

        return answer;
    }
    
}

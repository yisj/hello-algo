import java.util.LinkedList;
import java.util.Queue;

class Truck {
    int weight;
    int length;

    Truck(int weight, int length){
        this.weight = weight;
        this.length = length;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> q = new LinkedList<>();

        int time = 0;
        int idx = 0;
        int currentWeight = 0;

        while(true){
            time++;
            if(idx < truck_weights.length && currentWeight + truck_weights[idx] <= weight){
                q.add(new Truck(truck_weights[idx], bridge_length));
                currentWeight += truck_weights[idx++];
            }
            
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                Truck t = q.poll();
                t.length--;
                if(t.length > 0)
                    q.add(t);
                if(t.length == 0)
                    currentWeight -= t.weight;
            }

            if(idx == truck_weights.length && q.isEmpty())
                break;

        }
        return ++time;
    }

}

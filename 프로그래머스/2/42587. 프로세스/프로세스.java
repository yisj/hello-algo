import java.util.LinkedList;
import java.util.Queue;

class Process {
    int location;
    int priority;

    Process(int location, int priority){
        this.location = location;
        this.priority = priority;
    }
}

class Solution {

    public int solution(int[] priorities, int location) {

        Queue<Process> q = new LinkedList<>();

        int[] cnt = new int[10];
        int maxPriority = 0;
        for(int i=0; i<priorities.length; i++){
            cnt[priorities[i]]++;
            if(priorities[i] > maxPriority) maxPriority = priorities[i];
            q.add(new Process(i, priorities[i]));
        }

        int order = 0;
        while(!q.isEmpty()){
            Process p = q.poll();
            

            if(p.priority < maxPriority){
                q.add(p);
            } else {
                order++;
                if (p.location == location){
                    return order;
                }
                cnt[maxPriority]--;
                while(cnt[maxPriority] == 0){
                    maxPriority--;
                }
            }
        }

        int answer = 0;
        return answer;
    }
}
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int index = 0;
        Queue<Integer> timeque = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        while(index < truck_weights.length){
            answer++;
            if(!timeque.isEmpty() && answer - timeque.peek() == bridge_length){
                timeque.poll();
                sum -= queue.poll();
            }
            
            if(sum + truck_weights[index] <= weight){
                sum += truck_weights[index];
                queue.add(truck_weights[index]);
                timeque.add(answer);
                index++;
            }
        }
        
        while(!timeque.isEmpty()){
            answer++;
            if(answer - timeque.peek() == bridge_length) timeque.poll();
        }
        
        return answer;
    }
}
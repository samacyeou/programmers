import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int number = 0;
        int fir = 0;
        int sec = 0;
        boolean[] visited = new boolean[cards.length + 1];
        List<Integer> group = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i++) {
            if(visited[i + 1]) continue;
            
            number = i + 1;
            while(!visited[number]) {
                visited[number] = true;
                group.add(number);
                number = cards[number - 1];
            }
            
            if(group.size() > fir) {
                sec = fir;
                fir = group.size();
            } else if(group.size() > sec) sec = group.size();
            
            group.clear();
        }

        answer = fir * sec;
        
        return answer;
    }
}
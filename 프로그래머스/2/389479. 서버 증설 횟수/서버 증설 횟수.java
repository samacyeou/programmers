import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        HashMap<Integer, Integer> time = new HashMap<>();
        List<Integer> timer = new ArrayList<>();

        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < timer.size(); j++) {
                timer.set(j, timer.get(j) - 1);
            }

            for (int j = timer.size() - 1; j >= 0; j--) {
                if (timer.get(j) == 0) {
                    timer.remove(j);
                    server--;
                }
            }
            
            // if(time.containsKey(i)) server -= time.get(i);
            
            if (players[i] >= (timer.size() + 1) * m) {
                int n = players[i] / m;
                int add = n - timer.size();
                answer += add;
                time.put(i + k, add);
                // server += add;

                for (int j = 0; j < add; j++) {
                    timer.add(k);
                    server++;
                }
            }
        }

        return answer;
    }
}
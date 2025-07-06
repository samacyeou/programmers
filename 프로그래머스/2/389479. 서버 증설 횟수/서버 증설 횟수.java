import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        HashMap<Integer, Integer> time = new HashMap<>();
        List<Integer> timer = new ArrayList<>();

        for (int i = 0; i < players.length; i++) {
//             for (int j = 0; j < timer.size(); j++) {
//                 timer.set(j, timer.get(j) - 1);
//             }

//             for (int j = timer.size() - 1; j >= 0; j--) {
//                 if (timer.get(j) == 0) {
//                     timer.remove(j);
//                 }
//             }
            
            if(time.containsKey(i)) server -= time.get(i);
            
            if (players[i] >= (server + 1) * m) {
                int n = players[i] / m;
                answer += n - server;
                time.put(i + k, n - server);
                server += n - server;

                // for (int j = 0; j < n - server; j++) {
                //     timer.add(k);
                // }
            }
        }

        return answer;
    }
}
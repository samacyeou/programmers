import java.io.*;
import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        // 최대 담을수 있는 정수 cap, 집개수, 배달 배열 , 수거 배열
        long answer = 0;
        int idx1 = -1;

        for (int i = 0; i < n; i++) {
            if (deliveries[i] > 0 || pickups[i] > 0) idx1 = i;
        }

        while(true) { 
            if (idx1 == -1) break; // 종료조건

            int d = cap, p = cap;
            answer += 2 * (idx1 + 1);

            int idx2 = -1;
            for (int i = idx1; i >= 0; i--) {
                if (d >= deliveries[i]) {
                    d -= deliveries[i];
                    deliveries[i] = 0;
                } else {
                    deliveries[i] -= d;
                    d = 0;
                    if(idx2 == -1) {idx2 = i; break;}
                }
            }

            int idx3 = -1;
            for (int i = idx1; i >= 0; i--) {
                if (p >= pickups[i]) {
                    p -= pickups[i];
                    pickups[i] = 0;
                } else {
                    pickups[i] -= p;
                    p = 0;
                    if(idx3 == -1) {idx3 = i; break;}
                }
            }

            idx1 = Math.max(idx2, idx3);
        }

        return answer;
    }
}
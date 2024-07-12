import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
    int min = 0;    // 최소 공배수
    int max = 0;    // 최대 공약수
    if (n == m) {
        max = n;
        min = n;
    } else if (n > m) {
        if (m == 1) {
            min = n;
            max = m;
        } else if (n % m == 0) {
            max = m;
            min = n;
        } else {
            min = m * n;
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= (m / 2); i++) {
                if (m % i == 0) {
                    list.add(i);
                }
            }

            for (int i = list.size() - 1; i >= 0; i--) {
                if (n % list.get(i) == 0) {
                    max = list.get(i);
                    break;
                }
            }
        }
    } else {
        if (n == 1) {
            min = m;
            max = n;
        } else if (m % n == 0) {
            max = n;
            min = m;
        } else {
            min = m * n;
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= (n / 2); i++) {
                if (n % i == 0) {
                    list.add(i);
                }
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (m % list.get(i) == 0) {
                    max = list.get(i);
                    break;
                }
            }
        }
    }

    int[] answer = new int[2];
    answer[0] = max;
        if(max!=Math.min(n,m)) answer[1]=min/max;
    else answer[1] = min;
    return answer;
}
}
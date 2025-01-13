import java.util.*;
class Solution {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = generateQueue(queue1);
        Queue<Integer> q2 = generateQueue(queue2);

        long q1Sum = Arrays.stream(queue1).sum();
        long q2Sum = Arrays.stream(queue2).sum();
        long totalSum = q1Sum+q2Sum;
        if (totalSum % 2 == 1) return -1;
        // for (int q : queue1) {
        //     if(q > (totalSum/2l)) return -1;
        // }
        // for (int q : queue2) {
        //     if(q > (totalSum/2)) return -1;
        // }

        while(answer <= 600000) {
            if (q1Sum > q2Sum) {
                int q1Val = q1.poll();
                q2.add(q1Val);
                q1Sum -= q1Val;
                q2Sum += q1Val;
                answer++;
            }
            else if (q1Sum < q2Sum) {
                int q2Val = q2.poll();
                q1Sum += q2Val;
                q2Sum -= q2Val;
                q1.add(q2Val);
                answer++;
            } else {
                return answer;
            }

        }

        return -1;
    }

    private Queue<Integer> generateQueue(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        for (int i : arr) {
            q.add(i);
        }
        return q;
    }
}
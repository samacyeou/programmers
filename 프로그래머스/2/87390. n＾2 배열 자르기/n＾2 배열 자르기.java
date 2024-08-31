import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {

        int length = (int) (right - left) + 1;

    int answer[] = new int[length];
    int answerIdx = 0;
    for(long i = left+1; i <= right+1; i++){   
        long t1 = i % n;
        if(t1 == 0){
            answer[answerIdx] = n;
        }else{
            long t2 = i / n;
            if(t2 >= t1){
                answer[answerIdx] = (int)t2+1;
            }else{
                answer[answerIdx] = (int)t1;
            }
        }
        answerIdx++;
    }

    return answer;
    }
}
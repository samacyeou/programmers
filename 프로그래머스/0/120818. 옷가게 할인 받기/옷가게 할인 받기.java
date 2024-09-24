import java.util.*;

class Solution {
    public int solution(int price) {
        int answer = 0;
        if(price >= 500000) {
            answer = (int) (price * 80 / 100);
        }
        else if (price >= 300000) {
            answer = (int) (price * 90 / 100);
        }
        else if (price >= 100000) {
            answer = (int) (price * 95 / 100);   
        }
        else {
            answer = price;

        }
        return answer;
    }
}
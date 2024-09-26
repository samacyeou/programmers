class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin + 1)];
        int index = answer.length - 1;
        
        for(int i = (int)end; i >= begin; i--) {
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    answer[index] = j;
                    if(i / j <= 10000000) {
                        answer[index] = i / j;
                        break;
                    }
                }
            }
            
            if(answer[index] == 0 && i != 1) answer[index] = 1;
            index--;
        }
        
        return answer;
    }
}
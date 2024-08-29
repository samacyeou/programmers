import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int count = 0;
        for (int[] query : queries) {
            List<Integer> minList = new ArrayList<>();
            for (int i = query[0]; i < query[1] + 1; i++) {
                if (arr[i] > query[2]) {
                    minList.add(arr[i]);
                }
            }
            if(minList.isEmpty()){
                answer[count] = -1;
            } else {
                answer[count] = Collections.min(minList);
            }
            count++;
        }
        return answer;
    }
}
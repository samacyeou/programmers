import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {

        int len = numbers.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }

        int[] result = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(result);
        return result;
    }
}
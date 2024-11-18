import java.util.*;

class Solution {
    public static Set<Integer> hashSet = new HashSet<>();
    public static boolean[] visited;
    public int solution(String numbers) {
        // 자료구조 선언
        StringBuilder sb = new StringBuilder();
        // 자료구조 채우기
        visited = new boolean[numbers.length()];
        // 자료구조 초기화

        // 알고리즘
        dfs(sb, 0, numbers);
        return hashSet.size();
    }

    public static void dfs(StringBuilder sb, int k, String numbers){
        // 소수판별
        addPrime(sb);

        // 탈출
        if(k == numbers.length()) {
            return;
        }

        // 유배
        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i]) {
                continue;
            }
            // 만약 sb가 비어있는데 charat이 0이면 넘어가자 => 이부분을 추가하면 왜 안되는거지?
            if(sb.length() == 0 && numbers.charAt(i) == '0') {
                continue;
            }

            visited[i] = true;
            dfs(sb.append(numbers.charAt(i)), k + 1, numbers);
            sb.deleteCharAt(k);
            visited[i] = false;
        }
    }

    public static void addPrime(StringBuilder sb) {
        if(sb.length() == 0) {
            return;
        }

        // sb를 정수로 전환
        int num = Integer.parseInt(sb.toString());

        if(num <= 1) {
            return;
        }

        int max_value = (int) Math.sqrt(num);

        for(int i = 2; i <= max_value; i++) {
            if(num % i == 0) {
                return;
            }    
        }
        hashSet.add(num);
    }
}
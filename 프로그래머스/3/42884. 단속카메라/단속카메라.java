import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int temp = 0;
        
        for(int i = 0; i < routes.length; i++) {
            if(routes[i][0] > routes[i][1]) {
                temp = routes[i][0];
                routes[i][0] = routes[i][1];
                routes[i][1] = temp;
            }
        }
        
        Arrays.sort(routes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return -Integer.compare(a[1], b[1]);
            }
        });
        
        int end = routes[0][1];
        
        for(int i = 1; i < routes.length; i++) {
            if(routes[i][1] < end) end = routes[i][1];
            else if(routes[i][0] > end) {
                answer++;
                end = routes[i][1];
            }
        }
        
        
        return answer;
    }
}
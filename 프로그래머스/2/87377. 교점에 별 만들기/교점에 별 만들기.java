import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        long[] result = new long[3];
        long x, y, top, right, bottom, left;
        top = right = Long.MIN_VALUE;
        bottom = left = Long.MAX_VALUE;
        
        List<long[]> points = new ArrayList<>();
        
        for(int i = 0; i < line.length; i++) {
            long A, B, C;
            A = line[i][0];
            B = line[i][1];
            C = line[i][2];
            
            for(int j = i+1; j < line.length;j++) {
                long D, E, F;
                D = line[j][0];
                E = line[j][1];
                F = line[j][2];
                
                result[2] = A * E - B * D;
                if(result[2] == 0) continue;
                
                result[0] = B * F - C * E;
                result[1] = C * D - A * F;
                
                x = result[0] / result[2];
                y = result[1] / result[2];
                
                if(A * x + B * y + C == 0 && D * x + E * y + F == 0) {
                    if(top < y) top = y;
                    if(right < x) right = x;
                    if(bottom > y) bottom = y;
                    if(left > x) left = x;
                    
                    points.add(new long[]{x, y});
                }
            }
        }
        
        Collections.sort(points, new Comparator<long[]>() {
            public int compare(long[] a, long[] b) {
                if(a[1] != b[1]) return Long.compare(b[1], a[1]);
                return Long.compare(a[0], b[0]);
            }
        });
        
        answer = new String[(int)(top-bottom+1)];
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        long[] point = points.get(idx++);
        
        for(long l = top; l >= bottom; l--) {
            for(long k = left; k <= right; k++) {
                if(point[0] == k && point[1] == l) {
                    sb.append("*");
                    while(idx < points.size()) {
                        long[] temp = points.get(idx++);
                        if(temp[0] == point[0] && temp[1] == point[1]) continue;
                        point = temp;
                        break;
                    }
                } else sb.append(".");
            }
            
            answer[(int)(top-l)] = sb.toString();
            sb.setLength(0);
        }
        
        return answer;
    }
}
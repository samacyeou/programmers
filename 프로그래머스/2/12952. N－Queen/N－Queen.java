import java.util.List;
import java.util.ArrayList;

class Solution {
    int answer = 0;
    public void recursive(int n, int index, List<int[]> dots, List<Integer> cols) {
        if(index == n) {
            answer++;
            // for(int[] dot : dots) {
            //     for(int i : dot) System.out.print(i + " ");
            //     System.out.print("   ");
            // }
            // System.out.println();
            return;
        }
        
        int row = 0;
        int col = 0;
        boolean impossible = false;
        for(int i = 0; i < n; i++) {
            if(dots.size() != 0) {
                if(cols.contains(i)) continue;
                for(int[] dot : dots) {
                    row = Math.abs(index - dot[0]);
                    col = Math.abs(i - dot[1]);
                    if(row == col || (int)Math.sqrt(row * row + col * col) <= 1) {
                        impossible = true;
                        break;
                    }
                }
                if(impossible) {
                    impossible = false;
                    continue;
                }
            }

            dots.add(new int[]{index, i});
            cols.add(i);
            recursive(n, index + 1, dots, cols);
            dots.remove(dots.size() - 1);
            cols.remove(cols.size() - 1);
        }
        
        return;
    }
    
    public int solution(int n) {
        List<int[]> dots = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        recursive(n, 0, dots, cols);
        
        return answer;
    }
}
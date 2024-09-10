import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int bfs(String[] board, int row, int col) {
        int lenR = board.length;
        int lenC = board[0].length();
        boolean[][] visited = new boolean[lenR][lenC];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col, 0});
        visited[row][col] = true;
        
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if(board[cur[0]].charAt(cur[1]) == 'G') return cur[2];
            
            for(int[] dir : dirs) {
                int nR = cur[0];
                int nC = cur[1];
                
                while(true) {
                    if(nR < 0 || nR >= lenR || nC < 0 || nC >= lenC || board[nR].charAt(nC) == 'D') {
                        nR -= dir[0];
                        nC -= dir[1];
                        break;
                    }
                    
                    nR += dir[0];
                    nC += dir[1];
                }
                
                if((nR != cur[0] || nC != cur[1]) && !visited[nR][nC]) {
                    visited[nR][nC] = true;
                    queue.add(new int[]{nR, nC, cur[2] + 1});
                }
            }
        }
        
        return -1;
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        loop1:
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == 'R') {
                    answer = bfs(board, i, j);
                    break loop1;
                }
            }
        }
        
        return answer;
    }
}
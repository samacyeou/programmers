import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    static class Point {
        int row, col, time;
        
        Point(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    
    public int bfs(char[][] maps, int row, int col, char target) {
        int mRow = maps.length;
        int mCol = maps[0].length;
        boolean[][] visited = new boolean[mRow][mCol];
        Queue<Point> queue = new LinkedList<>();
        
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        queue.add(new Point(row, col, 0));
        visited[row][col] = true;
        
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            
            if(maps[cur.row][cur.col] == target) {
                return cur.time;
            }
            
            for(int[] dir : dirs) {
                int nRow = cur.row + dir[0];
                int nCol = cur.col + dir[1];
                
                if(nRow >= 0 && nRow < mRow && nCol >= 0 && nCol < mCol && maps[nRow][nCol] != 'X' && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    queue.add(new Point(nRow, nCol, cur.time + 1));
                }
            }
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        int sRow = 0;
        int sCol = 0;
        int lRow = 0;
        int lCol = 0;
        char[][] charMaps = new char[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++) {
            charMaps[i] = maps[i].toCharArray();
            for(int j = 0; j < maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    sRow = i;
                    sCol = j;
                } else if(maps[i].charAt(j) == 'L') {
                    lRow = i;
                    lCol = j;
                }
            }
        }
        
        int time = 0;
        time = bfs(charMaps, sRow, sCol, 'L');
        answer = bfs(charMaps, lRow, lCol, 'E');
        
        if(time == -1 || answer == -1) answer = -1;
        else answer += time;
        
        return answer;
    }
}
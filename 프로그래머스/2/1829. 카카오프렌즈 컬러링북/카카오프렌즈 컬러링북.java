import java.util.HashMap;

class Solution {
    public void dfs(int[][] picture, boolean[][] visited, HashMap<Integer, Integer> area, int cur, int row, int col, int lenR, int lenC) {
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        for(int[] dir : dirs) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            
            if(nRow >= 0 && nRow < lenR && nCol >= 0 && nCol < lenC && !visited[nRow][nCol] && picture[nRow][nCol] == cur) {
                visited[nRow][nCol] = true;
                area.put(cur, area.get(cur)+1);
                dfs(picture, visited, area, cur, nRow, nCol, lenR, lenC);
            }
        }
                
        return;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int lenR = picture.length;
        int lenC = picture[0].length;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        HashMap<Integer, Integer> area = new HashMap<>();
        boolean[][] visited = new boolean[lenR][lenC];
        
        for(int i = 0; i < lenR; i++) {
            for(int j = 0; j < lenC; j++) {
                if(visited[i][j] || picture[i][j] == 0) continue;
                int cur = picture[i][j];
                area.put(cur, 0);
                dfs(picture, visited, area, cur, i, j, lenR, lenC);

                answer[0]++;
                answer[1] = Math.max(answer[1], area.get(cur));

                area.put(cur, 0);
            }
        }
        
        return answer;
    }
}
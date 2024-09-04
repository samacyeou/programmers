import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public void dfs(char[][] cells, int[] food, int row, int col) {
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        for(int[] dir : dirs) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            if(nrow >= 0 && nrow < cells.length && ncol >= 0 && ncol < cells[nrow].length && cells[nrow][ncol] != 'X') {
                food[0] += cells[nrow][ncol] - '0';
                cells[nrow][ncol] = 'X';
                dfs(cells, food, nrow, ncol);
            }
        }
    }
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        int[] food = new int[]{0};
        char[][] cells = new char[maps.length][maps[0].length()];
        List<Integer> foods = new ArrayList<>();
        
        for(int i = 0; i < maps.length; i++) {
            cells[i] = maps[i].toCharArray();
        }
        
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                if(cells[i][j] != 'X') {
                    food[0] += cells[i][j] - '0';
                    cells[i][j] = 'X';
                    dfs(cells, food, i, j);
                    foods.add(food[0]);
                    food[0] = 0;
                }
            }
        }
        
        if(foods.size() == 0) answer = new int[]{-1};
        else {
            Collections.sort(foods);
            answer = foods.stream().mapToInt(i -> i).toArray();
        }
        
        return answer;
    }
}
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int lenX = maps[0].length;
        int lenY = maps.length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        maps[0][0] = -1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int x = cur[1];
                int y = cur[0];

                if(x == lenX - 1 && y == lenY - 1) return answer + 1;

                for(int[] dir : direction){
                    int newx = x + dir[1];
                    int newy = y + dir[0];

                    if(newx >= 0 && newy >= 0 && newx < lenX && newy < lenY && maps[newy][newx] == 1){
                        q.add(new int[]{newy,newx});
                        maps[newy][newx] = -1;
                    }
                }
            }
            answer++;
        }

        answer = -1;

        return answer;
    }
}
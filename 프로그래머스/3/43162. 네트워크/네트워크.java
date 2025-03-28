class Solution {
    void dfs(int[][] computers, boolean[] visited, int num) {
        for(int i = 0; i < computers.length; i++) {
            if(computers[num][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(computers, visited, i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(computers, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
}
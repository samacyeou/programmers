class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] squre = new int[rows][columns];
        int temp = 1;
        int s = 0;
        int a = 0;
        int min = rows*columns;
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<columns;j++){
                squre[i][j]=temp++;
            }
        }
        
        if(queries.length==1){
            answer[0]=squre[queries[0][0]-1][queries[0][1]-1];
            return answer;
        }
        
        for(int i = 0;i<queries.length;i++){
            s=queries[i][0]-1;
            temp=squre[s+1][queries[i][1]-1];
            for(int j = queries[i][1]-1;j<queries[i][3]-1;j++){
                if(squre[s][j]<min) min=squre[s][j];
                a=squre[s][j];
                squre[s][j]=temp;
                temp=a;
            }
            
            s=queries[i][3]-1;
            for(int j = queries[i][0]-1;j<queries[i][2]-1;j++){
                if(squre[j][s]<min) min=squre[j][s];
                a=squre[j][s];
                squre[j][s]=temp;
                temp=a;
            }
            
            s=queries[i][2]-1;
            for(int j = queries[i][3]-1;j>=queries[i][1];j--){
                if(squre[s][j]<min) min=squre[s][j];
                a=squre[s][j];
                squre[s][j]=temp;
                temp=a;
            }
            
            s=queries[i][1]-1;
            for(int j = queries[i][2]-1;j>=queries[i][0];j--){
                if(squre[j][s]<min) min=squre[j][s];
                a=squre[j][s];
                squre[j][s]=temp;
                temp=a;
            }
            
            answer[i]=min;
            min=rows*columns;
        }
        
        return answer;
    }
}
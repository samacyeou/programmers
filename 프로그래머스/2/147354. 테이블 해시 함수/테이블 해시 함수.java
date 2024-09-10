class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int[] temp = new int[data[0].length];
        
        for(int i = 0; i < data.length; i++) {
            for(int j = i + 1; j < data.length; j++) {
                if(data[i][col - 1] > data[j][col - 1]) {
                    temp = data[j];
                    data[j] = data[i];
                    data[i] = temp;
                } else if(data[i][col - 1] == data[j][col - 1]) {
                    if(data[i][0] < data[j][0]) {
                        temp = data[j];
                        data[j] = data[i];
                        data[i] = temp;
                    }
                }
            }
        }
        
        int sumOfMod = 0;
        for(int i = row_begin - 1; i < row_end; i++) {
            for(int j = 0; j < data[i].length; j++) {
                sumOfMod += data[i][j] % (i + 1);
            }
            
            answer ^= sumOfMod;
            sumOfMod = 0;
        }
        
        return answer;
    }
}
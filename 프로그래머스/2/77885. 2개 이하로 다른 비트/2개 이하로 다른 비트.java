class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        String temp = "";
        
        for(int i = 0; i < len; i++){
            temp = Long.toBinaryString(numbers[i]);
            for(int j = temp.length()-1; j >= 0; j--){
                if(temp.charAt(j) == '0'){
                    if(j == temp.length()-1) temp = temp.substring(0, j) + "1";
                    else if(j == temp.length()-2) temp = temp.substring(0, j) + "10";
                    else temp = temp.substring(0, j) + "10" + temp.substring(j+2);
                    answer[i] = Long.parseLong(temp, 2);
                    break;
                }
            }
            
            if(answer[i] == 0){
                temp = "10" + temp.substring(1);
                answer[i] = Long.parseLong(temp, 2);
            }
        }
        
        return answer;
    }
}
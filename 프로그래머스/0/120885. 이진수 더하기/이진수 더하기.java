class Solution {
    public String solution(String bin1, String bin2) {
        String answer = String.valueOf(Integer.toBinaryString((Integer.valueOf(bin1,2)+Integer.valueOf(bin2,2))));
        int sum = 8;
        sum /= 1+ 1;
        System.out.println(sum);
        
        return answer;
    }
}
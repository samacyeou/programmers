class Solution {
    public int solution(int n) {
        String temp = Integer.toBinaryString(n);
        boolean check = false;
        int answer = 0;
        int idx = 0;
        int end = temp.length();

        for(int i = temp.length() - 1; i >= 0; i--) {
            if(check && temp.charAt(i) == '0') {
                idx = i;
                break;
            } else if(!check && temp.charAt(i) == '1') {
                check = true;
                end = i;
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        
        result.append(temp.substring(0, idx)).append("10");
        
        for(int i = 0; i < temp.length() - end - 1; i++) result.append("0");

        
        if(idx == 0) result.append("1".repeat(end - idx));
        else result.append("1".repeat(end - idx - 1));
        
        answer = Integer.valueOf(result.toString(), 2);
        
        return answer;
    }
}
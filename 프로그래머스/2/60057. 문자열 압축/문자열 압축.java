class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        String regex = "";
        int len = s.length();
        int answer = len;
        int sIdx = 0;
        
        for(int i = 1; i <= len / 2; i++) {
            regex = "(?<=\\G.{" + i + "})";
            
            String[] temp = s.split(regex);
            String target = temp[0];
            int count = 1;
            for(int j = 1; j < temp.length; j++) {
                if(target.equals(temp[j])) count++;
                else {
                    if(count > 1) sb.append(count + target);
                    else sb.append(target);
                    count = 1;
                    target = temp[j];
                }
            }
            
            if(count > 1) sb.append(count + target);
            else sb.append(target);
            
            answer = Math.min(answer, sb.length());
            sb.setLength(0);
        }
        
        return answer;
    }
}
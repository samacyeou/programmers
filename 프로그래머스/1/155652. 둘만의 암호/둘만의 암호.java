class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] c = s.toCharArray();
        
        for(int i = 0;i<c.length;i++){
            for(int j = 0;j<index;j++){
                c[i]++;
                if(c[i]>'z') c[i] = 'a';
                if(skip.contains(Character.toString(c[i]))) j--;
            }
        }
        
        answer = new String(c);
        
        return answer;
    }
}
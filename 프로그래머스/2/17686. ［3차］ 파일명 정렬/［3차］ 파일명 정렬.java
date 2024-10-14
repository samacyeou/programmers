import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        Arrays.sort(files, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String s1s = "";
                String s2s = "";
                String s1n = "";
                String s2n = "";
                boolean check = true;
                int count = 0;
                
                for(int i = 0; i < s1.length(); i++) {
                    if(s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
                        check = false;
                        s1n += s1.charAt(i);
                        count++;
                        if(count == 5) break;
                    } else {
                        if(check) s1s += Character.toLowerCase(s1.charAt(i));
                        else break;
                    }
                }
                
                check = true;
                count = 0;
                
                for(int i = 0; i < s2.length(); i++) {
                    if(s2.charAt(i) >= '0' && s2.charAt(i) <= '9') {
                        check = false;
                        s2n += s2.charAt(i);
                        count++;
                        if(count == 5) break;
                    } else {
                        if(check) s2s += Character.toLowerCase(s2.charAt(i));
                        else break;
                    }
                }
                
                if(s1s.equals(s2s)) return Integer.parseInt(s1n) - Integer.parseInt(s2n);
                else return s1s.compareTo(s2s);
            }
        });
        
        for(int i = 0; i < files.length; i++) answer[i] = files[i];
        
        return answer;
    }
}
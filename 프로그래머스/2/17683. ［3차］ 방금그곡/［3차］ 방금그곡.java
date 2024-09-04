import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String convertHash(String str) {
        char[] bcA = str.toCharArray();
        char[] acA = new char[bcA.length];
        
        for(int i = 0; i < bcA.length; i++) {
            if(bcA[i] == '#') {
                acA[i - 1] = (char)(acA[i - 1] + 32);
                acA[i] = ' ';
            } else acA[i] = bcA[i];
        }
        
        StringBuilder s = new StringBuilder();
        for(char c : acA) {
            if(c != ' ') s.append(c);
        }
        
        return s.toString();
    }
    
    public int getTimestamp(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        List<String> finds = new ArrayList<>();
        HashMap<String, Integer> time = new HashMap<>();
        HashMap<String, Integer> index = new HashMap<>();
        
        m = convertHash(m);
        
        for(int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            int startT = getTimestamp(info[0]);
            int endT = getTimestamp(info[1]);
            int duration = endT - startT;
            String sheet = convertHash(info[3]);
            
            time.put(info[2], time.getOrDefault(info[2], 0) + duration);
            index.putIfAbsent(info[2], i);
            
            StringBuilder play = new StringBuilder();
            for(int j = 0; j < duration; j++) play.append(sheet.charAt(j % sheet.length()));
            
            if(play.toString().contains(m)) {
                if(!finds.contains(info[2])) finds.add(info[2]);
            }
        }
        
        if(finds.size() == 1) answer = finds.get(0);
        else if(finds.size() >= 2) {
            String title = finds.get(0);
            int longT = time.get(title);
            answer = title;
            for(int i = 1; i < finds.size(); i++) {
                title = finds.get(i);
                if(time.get(title) > longT) {
                    answer = title;
                    longT = time.get(title);
                } else if(time.get(title) == longT) {
                    if(index.get(answer) > index.get(title)) {
                        answer = title;
                        longT = time.get(title);
                    }
                }
            }
        }
        
        return answer;
    }
}
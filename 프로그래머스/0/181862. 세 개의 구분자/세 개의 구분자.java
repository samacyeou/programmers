import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
        answer = myStr.split("[a-c]+");

        List<String> list = new ArrayList<>();
        for(int i = 0; i< answer.length; i++){
            if(!"".equals(answer[i])) list.add(answer[i]);
        }

        if(list.size() == 0) list.add("EMPTY");

        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);

        return answer;
    }
}
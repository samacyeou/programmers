import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        boolean check = false;
        ArrayList<String> ac = new ArrayList<String>();
        ArrayList<String> ap = new ArrayList<String>();

        for(int i = 0;i<participant.length;i++)
            ap.add(participant[i]);
        for(int i = 0;i<completion.length;i++)
            ac.add(completion[i]);

        Collections.sort(ap);
        Collections.sort(ac);

        for(int j = 0;j<ac.size();j++)
            if(!ac.get(j).equals(ap.get(j))){
                answer=ap.get(j);
                check = true;
                break;
            }
        if(check==false)
            answer=ap.get(ap.size()-1);


        return answer;
    }
}
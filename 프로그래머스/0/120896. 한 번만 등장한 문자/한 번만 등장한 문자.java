import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] letters = s.split("");
        Arrays.sort(letters);

        StringBuilder answer = new StringBuilder();
        if(s.length() == 1) return s;

        if(!letters[0].equals(letters[1])) {
            answer.append(letters[0]);
        }
        for(int i = 1; i < letters.length -1; i++) {
            if((!letters[i-1].equals(letters[i])) && (!letters[i].equals(letters[i+1]))) {
                answer.append(letters[i]);
            }
        }
        if(!letters[letters.length-2].equals(letters[letters.length-1])) {
            answer.append(letters[letters.length-1]);
        }

        return answer.toString();
    }
}
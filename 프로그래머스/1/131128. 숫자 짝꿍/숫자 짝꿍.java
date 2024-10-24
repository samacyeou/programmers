import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        String answer = "";

        for(int i = 0; i < X.length(); i++) {
            int c = X.charAt(i) - '0';
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);    
            }
        }

        for(int i = 0; i < Y.length(); i++) {
            int c = Y.charAt(i) - '0';
            if(map.containsKey(c)) {
                if(map.get(c) >= 1) {
                    map.put(c, map.get(c) - 1);
                    list.add(c);
                }
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        if(list.isEmpty()) {
            return "-1";
        }
        else if(list.get(0) == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + "");
        }



        return sb.toString();
    }
}
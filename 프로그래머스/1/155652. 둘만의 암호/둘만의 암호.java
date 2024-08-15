import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String blacklist="";
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> search = new HashMap<>();
        for(int i=0;i<skip.length();i++){
            blacklist+=((int)skip.charAt(i)+",");
        }

        int len = 26-skip.length();
        int idx=1;
        for(int i=97;i<=122;i++){
            if(!blacklist.contains(String.valueOf(i))){
                map.put(idx,i);
                search.put(i,idx);
                idx++;
            }
        }
        map.put(0, map.get(idx - 1));
        for(char ch:s.toCharArray()){
            int num = search.get((int)ch);
            num+=index;
            int result = map.get(num%len);
            answer+=(char)result;
        }


        return answer;
    }
}
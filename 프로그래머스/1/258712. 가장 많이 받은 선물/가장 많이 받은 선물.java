import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String,Integer> result = new HashMap<>();
        Map<String, ArrayList<Object>> map = new HashMap<String, ArrayList<Object>>();
        Map<String, Set<Object>> yn = new HashMap<String, Set<Object>>();
        Map<String,Integer> giftScore = new HashMap<>();
        for (String value : friends) {
            map.put(value, new ArrayList<>()); 
            yn.put(value, new HashSet<>()); 
            giftScore.put(value,0);
            result.put(value,0);
        }

        for(String value : gifts){
            String[] gift = value.split(" ");
            map.get(gift[0]).add(gift[1]);
            giftScore.put(gift[0], giftScore.get(gift[0])+1);
            giftScore.put(gift[1], giftScore.get(gift[1])-1);
            yn.get(gift[0]).add(gift[1]);
            yn.get(gift[1]).add(gift[0]);
        }

        for(String friend : friends){
            if(yn.get(friend).size() == friends.length-1){
                Set<Object> target = yn.get(friend);
                for(Object value : target){
                    int temp = 0; 
                    int temp2 = 0; 
                    for(int i=0; i<map.get(value).size(); i++){
                        if(map.get(value).get(i).equals(friend)) temp++;
                    } 
                    for(int i=0; i<map.get(friend).size(); i++){
                        if(map.get(friend).get(i).equals(value)) temp2++;
                    }
                    if(temp<temp2){
                        result.put(friend,result.get(friend)+1);
                    }
                    else if(temp == temp2 && (giftScore.get(value) < giftScore.get(friend))){
                        result.put(friend,result.get(friend)+1);
                    }
                }
            }
            else{ 
                Set<Object> target = yn.get(friend);
                for(String v : friends){
                    if( !target.contains(v) && !v.equals(friend)){
                        String noGift = v;
                        if(giftScore.get(friend) > giftScore.get(noGift)  ){
                            result.put(friend,result.get(friend)+1);
                        }
                    }
                }
                for(Object value : target){
                    int temp = 0; 
                    int temp2 = 0; 
                    for(int i=0; i<map.get(value).size(); i++){
                        if(map.get(value).get(i).equals(friend))
                            temp++;
                    } 
                    for(int i=0; i<map.get(friend).size(); i++){
                        if(map.get(friend).get(i).equals(value))
                            temp2++;
                    }
                    if(temp<temp2){ 
                        result.put(friend,result.get(friend)+1);
                    }
                    else if(temp == temp2 && (giftScore.get(value) != giftScore.get(friend))){
                        result.put(friend,result.get(friend)+1);
                    }
                }
            }
        }
        return getMaxValue(result);
    }

    public static int getMaxValue(Map<String, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (int value : map.values()) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
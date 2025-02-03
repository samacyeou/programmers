import java.util.*; 

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int prev;
        //<"이름", 해당 이름 가진 사람 수>
        Map<String, Integer> map = new HashMap<>();

        for(String name : participant){
            if(map.containsKey(name)) {//이미 있다면
                prev = map.get(name); //기존값에 
                map.put(name, prev+1); // +1
            }else{// 없다면 1로 저장
                map.put(name, 1); 
            }
        }

        //<"이름", 해당 이름 가진 사람 중 완주한 사람 수>
        // Map<String, Integer> map2 = new HashMap<>();

        for(String name : completion){
            //해당 키값을 가진 데이터가 있으면 그 값을 가져오고, 없으면 0을 가져옴
            prev = map.get(name);
            map.put(name, prev-1); // 가져온 값에 +1
        }

        for(String name: participant){ //참가자 이름 배열 돌면서
//             if(!map2.containsKey(name)){ //완주 이름 목록에 없다면
//                 answer = name; //완주하지 못한 선수!
//                 break;
//             }

//             //해당 이름을 가진 사람 수랑 해당 이름을 가지고 완주한 사람 수를 비교
//             if(map.get(name) != map2.get(name)){
//                 answer = name; // 다르면 완주하지 못한 선수!
//                 break;
//             }
            if(map.get(name) == 1) {
                answer = name;
                break;
            }
        }

        return answer;
    }
}
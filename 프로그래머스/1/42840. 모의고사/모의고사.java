import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        List<Integer> jjickList1 = List.of(1,2,3,4,5);
        List<Integer> jjickList2 = List.of(2,1,2,3,2,4,2,5);
        List<Integer> jjickList3 = List.of(3,3,1,1,2,2,4,4,5,5);

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,0);
        map.put(2,0);
        map.put(3,0);

        for(int i=0;i<answers.length;i++){
            if(jjickList1.get(i%5)==answers[i]){
                map.put(1,map.get(1)+1);
            }
            if(jjickList2.get(i%8)==answers[i]){
                map.put(2,map.get(2)+1);
            }
            if(jjickList3.get(i%10)==answers[i]){
                map.put(3,map.get(3)+1);
            }

        }
        
        int fir = 1;
        int sec = 0;
        int max = map.get(1);
        int count = 1;
        for(int i = 2; i < 4; i++) {
            if(map.get(i) > max) {
                max = map.get(i);
                fir = i;
                count = 1;
            } else if(map.get(i) == max) {
                count++;
                sec = i;
            }
        }
        
        int[] answer;
        if(count == 3) answer = new int[]{1,2,3};
        else if(count == 2) answer = new int[]{fir,sec};
        else answer = new int[]{fir};

        List<Integer> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
               return map.get(o2)-map.get(o1);   
            }
        });

        List<Integer> finalList = new ArrayList<>();

        if(map.get(keySet.get(0))==map.get(keySet.get(1))
           && map.get(keySet.get(1))==map.get(keySet.get(2))){
                 finalList.add(keySet.get(0));
                 finalList.add(keySet.get(1));
                 finalList.add(keySet.get(2));    


           }
           else if(map.get(keySet.get(0))==map.get(keySet.get(1))){
               finalList.add(keySet.get(0));
               finalList.add(keySet.get(1));
           }
           else{
               finalList.add(keySet.get(0));
           }


           Collections.sort(finalList);

           int arr[]=new int[finalList.size()];
           for(int i=0;i<finalList.size();i++){
               arr[i]=finalList.get(i);
           }

        // return arr;
           return answer;



    }
}
import java.util.*;

public class Solution {
public static int solution (String[] friends, String[] gifts) {
// send 리스트
List<String> sender = new ArrayList<>();
// recieve 리스트
List<String> reciever = new ArrayList<>();

    for (String s : gifts) {
        sender.add(s.split(" ")[0]);
        reciever.add(s.split(" ")[1]);
    }

    // 지수 계산
    Map<String, ArrayList<Integer>> diffMap = new HashMap<>();
    for (String friend : friends) {
        diffMap.put(friend, new ArrayList<>());
    }

    for (String friend : friends) {
        int send = Collections.frequency(sender, friend);
        int recieve = Collections.frequency(reciever, friend);
        int diff = send - recieve;

        diffMap.get(friend).add(send);
        diffMap.get(friend).add(recieve);
        diffMap.get(friend).add(diff);
    }

    // 세부 디테일
    Map<String, ArrayList<String>> gift = new HashMap<>();

    for (String friend : friends) {
        gift.put(friend, new ArrayList<>());
    }

    for (String s : gifts){
        gift.get(s.split(" ")[0]).add(s.split(" ")[1]);
    }

    Map<String, Map<String, Integer>> send_gift = new HashMap<>();

    for (String friend : friends) {
        send_gift.put(friend, new HashMap<>());

        for (String s : friends){
            int count=Collections.frequency(gift.get(friend), s);
            send_gift.get(friend).put(s, count);
        }
    }

    // 선물 수 구하기
    Map<String, Integer> recieve_gift = new HashMap<>();
    for (String friend : friends){
        int count = 0;

        for (String s : friends){
            int fTos = send_gift.get(friend).get(s);
            int sTof = send_gift.get(s).get(friend);

            if (fTos > sTof){
                count++;
            }
            else if (fTos == sTof){
                if (diffMap.get(friend).get(2) > diffMap.get(s).get(2)){
                    count++;
                }
            }
        }
        recieve_gift.put(friend, count);
    }

    // 가장 많이 선물 받는 개수 구하기
    int max_gift = Collections.max(recieve_gift.values());

    return max_gift;
}
}

import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> c1 = new ArrayDeque<>();
        ArrayDeque<String> c2 = new ArrayDeque<>();
        ArrayDeque<String> g = new ArrayDeque<>();

        for(int i=0; i<10; i++) {
            if(i<cards1.length) {
                c1.addLast(cards1[i]);
            }
            if(i<cards2.length) {
                c2.addLast(cards2[i]);
            }
        }
        
        for(int i = 0; i < goal.length; i++) {
            g.addLast(goal[i]);
        }

        // int max = -1;
        // max = Math.max(cards1.length, goal.length);
        // max = Math.max(max, cards2.length);
        // for(int i=0; i<max; i++) {
        //     if(i<cards1.length) {
        //         c1.addLast(cards1[i]);
        //     }
        //     if(i<cards2.length) {
        //         c2.addLast(cards2[i]);
        //     }
        //     if(i<goal.length) {
        //         g.addLast(goal[i]);
        //     }
        // }

        // for (String card : cards1) c1.addLast(card);
        // for (String card : cards2) c2.addLast(card);
        // for (String word : goal) g.addLast(word);

        while(true) {
            String data = g.pollFirst();
            if(!c1.isEmpty() && data.equals(c1.getFirst())) {
                c1.pollFirst();
            } else if(!c2.isEmpty() && data.equals(c2.getFirst())) {
                c2.pollFirst();
            } else {
                return "No";
            }
            if(g.isEmpty()) return "Yes";
        }
    }
}
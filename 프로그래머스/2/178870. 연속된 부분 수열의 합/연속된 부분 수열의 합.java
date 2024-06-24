import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] temp = {0, 0};
        int sum = 0;
        int index = 0;
        ArrayList<int[]> al = new ArrayList<>();
        
        for(int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            temp[1] = i;
            if(sum == k) al.add(new int[]{temp[0], temp[1]});
            else if(sum > k) {
                for(int j = index; j < i; j++){
                    sum -= sequence[j];
                    temp[0] = j + 1;
                    if(sum > k) continue;
                    else {
                        if(sum == k) al.add(new int[]{temp[0], temp[1]});
                        index = j + 1;
                        break;
                    }
                }
            }
        }
        
        Collections.sort(al, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                int a1l = a1[1] - a1[0];
                int a2l = a2[1] - a2[0];
                if(a1l == a2l) return a1[0] - a2[0];
                else return a1l - a2l;
            }
        });
        
        answer = al.get(0);
        
        return answer;
    }
}
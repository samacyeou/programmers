import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int t = 0;
        int c = 0;
        int l = elements.length;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 1;i<=l;i++){
            for(int j = 0;j<l;j++){
                for(int k=0;k<i;k++)
                    t+=elements[(j+k)%l];
                hs.add(t);
                t=0;
            }
        }
        
        answer=hs.size();
        
        return answer;
    }
}
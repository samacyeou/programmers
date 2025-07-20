import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int t = 0;
        int l = elements.length;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0;i<l;i++){
            for(int j = 0;j<l;j++){
                t+=elements[(i+j)%l];
                hs.add(t);
            }
            
            t=0;
        }
        
        answer=hs.size();
        
        return answer;
    }
}
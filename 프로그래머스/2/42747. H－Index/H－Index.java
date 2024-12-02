import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int e = 0;
        int t = 0;
        int s = 0;
        int[] c = new int[10001];
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i = 0;i<citations.length;i++){
            hs.add(citations[i]);
            c[citations[i]]++;
        }
        
        al=new ArrayList<>(hs);
        al.sort(Comparator.naturalOrder());
        System.out.println(al.get(al.size()-1));
        e=al.get(al.size()-1);
        
        for(int i = 0;i<=e;i++){
            t=i;
            for(int j = t;j<=e;j++)
                s+=c[j];
            if(s>=t) answer=answer<s?t:answer;
            if(i==e) break;
            s=0;
        }
        
        
        return answer;
    }
}
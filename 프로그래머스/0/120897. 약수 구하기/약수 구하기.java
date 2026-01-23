class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int[] temp = new int[(int)Math.sqrt(n)*2];
        int sidx = 0;
        int eidx = temp.length - 1;
        
        for(int i = 1; i*i <= n; i++) {
            if(n % i == 0) {
                temp[sidx++] = i;
                if(i * i != n) temp[eidx--] = n/i;
            }
        }
        
        answer = new int[sidx + temp.length - 1 - eidx];
        
        System.arraycopy(temp, 0, answer, 0, sidx);
        System.arraycopy(temp, eidx+1, answer, sidx, temp.length - 1 - eidx);
        
        return answer;
    }
}
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int width = Math.max(wallet[0], wallet[1]);
        int height = Math.min(wallet[0], wallet[1]);
        
        int big = Math.max(bill[0], bill[1]);
        int small = Math.min(bill[0], bill[1]);
        
        int temp = 0;
        
        while(true) {
            if(width >= big && height >= small) break;
            else {
                big /= 2;
                answer++;
                if(big < small) {
                    temp = small;
                    small = big;
                    big = temp;
                }
            }
        }
        
        return answer;
    }
}
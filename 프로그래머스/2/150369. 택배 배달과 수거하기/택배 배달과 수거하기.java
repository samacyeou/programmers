class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery = 0;
        int pickup = 0;
        int temp = 0;
        
        for(int i = n - 1; i >= 0; i--) {
            if(deliveries[i] != 0) {
                while(deliveries[i] > 0) {
                    if(delivery == 0) {
                        pickup += cap;
                        delivery = cap;
                        answer += (i+1) * 2;
                    }
                    
                    temp = Math.min(delivery, deliveries[i]);
                    deliveries[i] -= temp;
                    delivery -= temp;
                }
            }
            
            if(pickups[i] != 0) {
                while(pickups[i] > 0) {
                    if(pickup == 0) {
                        delivery += cap;
                        pickup = cap;
                        answer += (i+1) * 2;
                    }
                    
                    temp = Math.min(pickup, pickups[i]);
                    pickups[i] -= temp;
                    pickup -= temp;
                }
            }
        }
        
        return answer;
    }
}
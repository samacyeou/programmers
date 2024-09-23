import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    private void applyDiscount(int[] discounts, int minDiscount, int index, List<int[]> result) {
        if (index == discounts.length) {
            int[] curDiscounts = new int[discounts.length];
            for(int i = 0; i < discounts.length; i++) curDiscounts[i] = discounts[i];
            result.add(curDiscounts);
            return;
        }

        int temp = discounts[index];
        for(int i = minDiscount; i <= 40; i += 10) {
            discounts[index] = i;
            applyDiscount(discounts, minDiscount, index + 1, result);
            discounts[index] = temp;
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0, 0};
        int[] discounts = new int[emoticons.length];
        int minDiscount = 40;
        
        List<int[]> discountCombinations = new ArrayList<>();

        for(int i = 0; i < users.length; i++) {
            if(users[i][0] < minDiscount) minDiscount = users[i][0];
        }
        
        minDiscount = (int)Math.ceil(minDiscount / 10.0f) * 10;
        
        Arrays.fill(discounts, minDiscount);
        
        applyDiscount(discounts, minDiscount, 0, discountCombinations);
        
        HashMap<Integer, HashMap<Integer, Integer>> finalPrices = new HashMap<>();
        for(int i = 0; i < emoticons.length; i++) {
            finalPrices.put(i, new HashMap<Integer, Integer>());
            for(int j = 10; j <= 40; j += 10) {
                finalPrices.get(i).put(j, emoticons[i] * (100 - j) / 100);
            }
        }
        
        int usage = 0;
        for(int[] temp : discountCombinations) {
            int[] result = {0, 0};
            for(int i = 0; i < users.length; i++) {
                for(int j = 0; j < temp.length; j++) {
                    if(users[i][0] <= temp[j]) {
                        usage += finalPrices.get(j).get(temp[j]);
                    }
                }
                
                if(usage >= users[i][1]) result[0]++;
                else result[1] += usage;
                usage = 0;
            }
            
            if(result[0] > answer[0] ||
               (result[0] == answer[0] && result[1] > answer[1])
              ) answer = result;
        }
        
        return answer;
    }
}
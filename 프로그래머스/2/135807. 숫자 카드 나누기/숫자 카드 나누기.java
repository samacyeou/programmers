import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] getDivisor(int num) {
        List<Integer> divisor = new ArrayList<>();
        
        for(int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                divisor.add(i);
                divisor.add(num / i);
            }
        }
        
        Collections.sort(divisor);
        
        return divisor.stream().mapToInt(i -> i).toArray();
    }
    
    public int[] getArrayDivisor(int[] array) {
        List<Integer> arrayDivisor = new ArrayList<>();
        boolean check = true;
        int[] divisor = getDivisor(Arrays.stream(array).min().getAsInt());
        
        arrayDivisor.add(1);
        for(int i = 1; i < divisor.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if(array[j] % divisor[i] != 0) {
                    check = false;
                    break;
                }
            }
            
            if(check) {
                arrayDivisor.add(divisor[i]);
            }
            
            check = true;
        }
        
        return arrayDivisor.stream().mapToInt(i -> i).toArray();
    }
    
    public int getAnswerNumber(int[] divisor, int[] array) {
        boolean check = true;
        int num = 0;
        
        for(int i = divisor.length - 1; i > 0; i--) {
            for(int j = 0; j < array.length; j++) {
                if(array[j] % divisor[i] == 0) {
                    check = false;
                    break;
                }
            }
            
            if(check) {
                num = divisor[i];
                break;
            }
            
            check = false;
        }
        
        return num;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a = 0;
        int b = 0;
        int[] arrDivA = getArrayDivisor(arrayA);
        int[] arrDivB = getArrayDivisor(arrayB);
        boolean check = true;
        
        a = getAnswerNumber(arrDivA, arrayB);
        b = getAnswerNumber(arrDivB, arrayA);
        
        answer = Math.max(a, b);
        
        return answer;
    }
}
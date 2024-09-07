import java.util.List;
import java.util.ArrayList;

class Solution {
    // Priority Custom Calculation
    public String PCC(String str, char operator) {
        if(str.matches("-?\\d+")) return str;
        StringBuilder result = new StringBuilder();
        int sIdx = 0;
        int eIdx = 0;
        long fOrand = 0;
        long sOrand = 0;
        boolean check = false;
        
        for(int i = 1; i < str.length(); i++) {
            if(!('0' <= str.charAt(i) && str.charAt(i) <= '9')) {
                if(str.charAt(i) == operator) {
                    for(int j = i + 2; j < str.length(); j++) {
                        if(!('0' <= str.charAt(j) && str.charAt(j) <= '9')) {
                            eIdx = j;
                            break;
                        }
                    }
                    
                    if(eIdx == 0) eIdx = str.length();
                    
                    if(!check) {
                        fOrand = Long.parseLong(str.substring(sIdx, i));
                        check = true;
                    }
                    sIdx = eIdx + 1;
                    
                    sOrand = Long.parseLong(str.substring(i + 1, eIdx));
                    eIdx = 0;
                    
                    switch(operator) {
                        case '+': fOrand += sOrand; break;
                        case '-': fOrand -= sOrand; break;
                        case '*': fOrand *= sOrand; break;
                    }
                } else if(i != 0 &&
                          ('0' <= str.charAt(i - 1) && str.charAt(i - 1) <= '9')) {
                    if(check) {
                        result.append(fOrand + "" + str.charAt(sIdx - 1));
                        check = false;
                    }
                    result.append(str.substring(sIdx, i + 1));
                    sIdx = i + 1;
                }
            }
        }
        
        if(check) result.append(fOrand);
        else result.append(str.substring(sIdx));
        
        return result.toString();
    }
    
    // operator order
    public void allOrder(char[] opers, int index, List<String> oOrder) {
        if(index == opers.length - 1) {
            oOrder.add(new String(opers));
            return;
        }
        
        char idxCh = opers[index];
        char temp = ' ';
        
        for(int i = index; i < opers.length; i++) {
            temp = opers[i];
            
            opers[index] = temp;
            opers[i] = idxCh;
            
            allOrder(opers, index + 1, oOrder);
            
            opers[index] = idxCh;
            opers[i] = temp;
        }
        
        return;
    }
    
    public long solution(String expression) {
        long answer = 0;
        char[] operators = {'+', '-', '*'};
        List<String> operOrder = new ArrayList<>();
        String temp = "";
        
        allOrder(operators, 0, operOrder);
        
        for(String s : operOrder) {
            temp = expression;
            for(int i = 0; i < s.length(); i++) {
                temp = PCC(temp, s.charAt(i));
            }
            
            answer = Math.max(answer, Math.abs(Long.parseLong(temp)));
        }
        
        return answer;
    }
}
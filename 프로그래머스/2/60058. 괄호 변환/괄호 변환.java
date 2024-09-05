import java.util.Stack;

class Solution {
    public String convertCollectly(String str) {
        StringBuilder complete = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int index = 0;
        boolean collect = true;
        
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                count++;
                stack.add(str.charAt(i));
            } else if(str.charAt(i) == ')') {
                count--;
                if(stack.empty() || stack.peek() == ')') {
                    stack.add(str.charAt(i));
                } else stack.pop();
            }
            
            if(count == 0) {
                index = i;
                collect = stack.empty();
                break;
            }
        }
        
        if(collect) {
            complete.append(str.substring(0, index + 1));
            if(index + 1 != str.length())
                complete.append(convertCollectly(str.substring(index + 1)));
        } else {
            complete.append('(');
            if(index + 1 != str.length())
                complete.append(convertCollectly(str.substring(index + 1)));
            complete.append(')');
            
            for(int i = 1; i < index ; i++) {
                if(str.charAt(i) == '(') complete.append(')');
                else if(str.charAt(i) == ')') complete.append('(');
            }
        }
        
        return complete.toString();
    }
    
    public String solution(String p) {
        String answer = convertCollectly(p);
        return answer;
    }
}
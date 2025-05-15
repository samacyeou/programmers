import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        //모든재료를 stack에 담을거야
        int current;
        boolean flag=false;
        for(int cnt=0;cnt<ingredient.length;cnt++) {
            current=ingredient[cnt];
            if(current==1){
                if(!st.isEmpty()){
                    flag = ingredient[st.peek()]==3;
                }
                st.push(cnt);
                while(flag){
                    st.pop();
                    st.pop();
                    st.pop();
                    st.pop();
                    answer++;
                    if(!st.isEmpty()&&ingredient[st.peek()]==3&&st.size()>=4){
                        flag=true;
                    }
                    else{
                        flag=false;
                    }
                }
            }
            else{
                //비지않은거
                if(!st.isEmpty()){
                    //야채넣을시 앞이 야채 고기면 초기화 고기면 앞이 고기일 경우 초기화
                    //앞을 봤을때 앞이 자기보다 크거나 같으면 초기화
                    if(ingredient[st.peek()]>=current){
                        st.clear();
                    }else{
                        //고기인데 앞이 빵이면 초기화
                        if(ingredient[st.peek()]==1&&current==3){
                            st.clear();
                        }
                        //아니면 넣어
                        else {
                            st.push(cnt);
                        }

                    }
                }
            }
        }
        return answer;
    }
}
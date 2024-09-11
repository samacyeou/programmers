import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int[] index = new int[phone_book.length];
        // 같은 길이의 전화 번호를 건너뛰기 위한 배열.
        // 해당 인덱스에서 더 긴 길이를 가진 전화번호의 인덱스가 무엇인지 저장한다.
        int temp = 0;

        Arrays.sort(phone_book);
        // 사전 순으로 정렬하면서 첫번째 문자가 같은 것끼리 모이게 된다.
        // 그로 인해 해당 인덱스의 전화번호가 접두어가 아닌지를 쉽게 판단할 수 있다.

        for(int i = 0; i < phone_book.length-1; i++){
            if(phone_book[i].length() != phone_book[i+1].length()){
                for(int j = temp; j <= i; j++){
                    index[j] = i+1;
                    // 서로 다른 길이의 전화번호가 나오면
                    // 그 전화번호부터 확인해야 하기 때문에
                    // 같은 길이의 전화번호는 같은 인덱스부터
                    // 접두어 여부를 판단하게 된다.
                }
                temp = i+1;
            }
        }

        for(int i = temp; i < phone_book.length; i++){
            index[i] = phone_book.length-1;
            // 어느 인덱스부터 같은 길이의 전화번호가 끝까지 이어질 경우
            // 해당 인덱스들의 접두어 판단을 시작하는 인덱스가 지정되지 않기 때문에
            // 해당 인덱스들은 접두어 판단을 하지 않고 넘어가게 만들기 위한 인덱스를 저장한다.
        }

        for(int i = 0; i < phone_book.length-1; i++){
            temp = index[i];    // 접두어 판단을 시작하는 인덱스
            if(phone_book[temp].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }

        return answer;
    }
}
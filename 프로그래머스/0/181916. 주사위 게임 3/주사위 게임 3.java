import java.util.Arrays;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = {a,b,c,d};
        int answer = Arrays.stream(arr).min().getAsInt();
        int p = 0;
        int q = 0;
        int r = 0;
        for(int i = 0; i < arr.length; i++){
            int count = 0;
            q = 0;
            for(int j = 0; j < arr.length; j++){
                if(i==j){continue;}
                if(arr[i] == arr[j]){
                    p = arr[j];
                    count++;
                }
                if(q == 0 && arr[i] != arr[j]){
                    q = arr[j];
                }
                if(arr[i] != arr[j] && q != arr[j]){
                    r = arr[j];
                }
            }
            switch (count) { 

            case 3: answer = p * 1111;
                    break;
            case 2: answer = (10 * p + q)*(10 * p + q);
                    break;
            case 1: answer = (p + q) * Math.abs(p - q);
                    if(r!=0){
                        answer = q * r;
                    }
                    break;
            }
        }
        return answer;
    }
}
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] ob = new String[n];
        int od = 0;
        
        for(int i = 0;i<n;i++){
            ob[i]="";
            answer[i]="";
        }
        
        for(int i = 0;i<n;i++){
            od=arr1[i]|arr2[i];
            while(true){
                ob[i]+=Integer.toString(od%2);
                if((od/=2)==0)
                    break;
            }
            while(ob[i].length()!=n)
                ob[i]+="0";
        }
        
        for(int i = 0;i<ob.length;i++){
            for(int j = n-1;j>=0;j--){
                if(ob[i].charAt(j)=='1')
                    answer[i]+="#";
                if(ob[i].charAt(j)=='0')
                    answer[i]+=" ";
            }
        }
        
        return answer;
    }
}
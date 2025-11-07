class Solution
{
    public int solution(String s)
    {
        char[] str = new char[s.length()+1];
        int k = 1;
        int answer = -1;
        
        for(int i = 0;i<s.length();i++){
            str[k]=s.charAt(i);
            if(str[k]==str[k-1]) k-=2;
            k++;
        }

        if(k==1) answer=1;
        else answer=0;

        return answer;
    }
}
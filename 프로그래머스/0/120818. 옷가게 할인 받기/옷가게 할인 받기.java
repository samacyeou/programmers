class Solution {
    public int solution(int price) {
        int answer = price;

        if(price>=500000) answer=(int)(price-((float)price/100*20));
        else if(price>=300000) answer=(int)(price-((float)price/100*10));
        else if(price>=100000) answer=(int)(price-((float)price/100*5));

        return answer;
    }
}
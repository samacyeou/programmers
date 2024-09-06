class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int temp = 0;
        switch(a){
            case 1:temp = b%7; break;
            case 2:temp = (b+31)%7; break;
            case 3:temp = (b+60)%7; break;
            case 4:temp = (b+91)%7; break;
            case 5:temp = (b+121)%7; break;
            case 6:temp = (b+152)%7; break;
            case 7:temp = (b+182)%7; break;
            case 8:temp = (b+213)%7; break;
            case 9:temp = (b+244)%7; break;
            case 10:temp = (b+274)%7; break;
            case 11:temp = (b+305)%7; break;
            case 12:temp = (b+335)%7; break;
        }

        switch(temp){
            case 0:answer = "THU"; break;
            case 1:answer = "FRI"; break;
            case 2:answer = "SAT"; break;
            case 3:answer = "SUN"; break;
            case 4:answer = "MON"; break;
            case 5:answer = "TUE"; break;
            case 6:answer = "WED"; break;
        }

        return answer;
    }
}
import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int [] len = new int[2];
        int [] arr = new int[2];
        pos = open(pos,op_start,op_end);
        int[] end = {0,0};
        String[] st = video_len.split(":");
        String[] st1 = pos.split(":");
        //시간과 분을 나눠서 저장
        len[0] = Integer.parseInt(st[0]);
        len[1] = Integer.parseInt(st[1]);
        arr[0] = Integer.parseInt(st1[0]);
        arr[1] = Integer.parseInt(st1[1]);
        //커멘트 별 반복문 시작
        for(int i = 0 ; i < commands.length ; i++){
            String command = commands[i];
            if(command.equals("next")){
                arr[1] += 10;
                if(arr[1]>59){
                    arr[1] -=60;
                    arr[0] +=1;
                }
                if(arr[0]>len[0] || arr[0]>=len[0] && arr[1]>len[1]){
                    arr[0] = len[0];
                    arr[1] = len[1];
                }
            }else if(command.equals("prev")){
               arr[1] -= 10;
                if(arr[1]<0){
                    arr[1] += 60;
                    arr[0] -=1;
                }
                if(arr[0]<0){
                    arr[0] = 0;
                    arr[1] = 0;
                } 
            }
            String sa = open(arr[0]+":"+arr[1],op_start,op_end);
            String[] st12 = sa.split(":");
            arr[0] = Integer.parseInt(st12[0]);
            arr[1] = Integer.parseInt(st12[1]);
            
        }
        String ss = arr[0]<10 ? "0"+arr[0] : ""+arr[0];
        String mm = arr[1]<10 ? "0"+arr[1] : ""+arr[1];

        answer = ss + ":" + mm;
        answer = open(answer,op_start,op_end);
        return answer;
    }
    private String open(String pos, String op_start, String op_end){
        String[] poSpilt = pos.split(":");
        String[] opSpilt = op_start.split(":");
        String[] enSpilt = op_end.split(":");

        int poSize = (Integer.parseInt(poSpilt[0])*60) + Integer.parseInt(poSpilt[1]);
        int opSize = (Integer.parseInt(opSpilt[0])*60) + Integer.parseInt(opSpilt[1]);
        int enSize = (Integer.parseInt(enSpilt[0])*60) + Integer.parseInt(enSpilt[1]);

        if(poSize<=enSize && poSize>=opSize) pos = op_end;

        return pos;
    }
}
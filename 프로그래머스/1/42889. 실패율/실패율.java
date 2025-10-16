import java.util.*;
class Solution {
    public Integer[] solution(int N, int[] stages) {
        // 클리어한 스테이지별 사람수
        int[] stageClear = new int[N];
        //도달한 스테이지별 사람수
        int[] onStage = new int[N];
        for(int stage:stages){
            for(int i=1; i<stage; i++){
                stageClear[i-1]++;
                onStage[i-1]++;
            }
            if(stage<N+1){
                onStage[stage-1]++;
            }
        }
        // System.out.println(Arrays.toString(stageClear));
        // System.out.println(Arrays.toString(onStage));
        Integer[] tempanswer = new Integer[N];
        for(int i = 0; i<N; i++){
            tempanswer[i] = i+1;
        }
        // i 스테이지 성공한 사람/ i스테이지 도달한사람 - i+1 스테이지 성공한 사람/ i+1 스테이지 도달한사람
        Arrays.sort(tempanswer,(a,b)->{
            return (int)((double)onStage[b-1]*stageClear[a-1]-(double)onStage[a-1]*stageClear[b-1]);
        });
        return tempanswer;
    }
}
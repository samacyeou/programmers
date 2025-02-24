class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[] givePresent, receivePresent, presentRate, willReceive;
        int[][] presentRelate = new int[friends.length][friends.length];   // 선물 준 사람과 선물 받은 사람의 관계도
        givePresent = new int[friends.length];
        receivePresent = new int[friends.length];
            presentRate = new int[friends.length];
        willReceive = new int[friends.length];
        int answer = 0;

        for(int i = 0; i < gifts.length; i++){
            String[] tmp = gifts[i].split(" ");   // 매개변수로 준 gifts 배열을 공백을 기준으로 준 사람, 받은 사람으로 나눔.

            for(int j = 0; j < friends.length; j++){   // for문을 돌려서 매개변수로 준 friends 배열을 기준으로 하여 통계를 채널링함.
                if(friends[j].equals(tmp[0])){
                    givePresent[j]++;

                    for(int k = 0; k < friends.length; k++){
                        if(tmp[1].equals(friends[k])){
                            presentRelate[j][k]++;
                            receivePresent[k]++;
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < friends.length; i++) System.out.println(givePresent[i]+" "+receivePresent[i]+" "+presentRate[i]);

        for(int i2 = 0; i2 < friends.length; i2++) presentRate[i2] = givePresent[i2] - receivePresent[i2];   // 선물지수

        
        for(int index = 0; index < friends.length; index++){   // 서로 주고받은 선물 개수 비교
            for(int r = 0; r < friends.length; r++){
                if(index == r) continue;
                if(presentRelate[index][r] > presentRelate[r][index]){
                    willReceive[index]++;
                }
                else if(presentRelate[index][r] == presentRelate[r][index]){
                    if(presentRate[index] > presentRate[r]) willReceive[index]++;
                    else if(presentRate[index] == presentRate[r]) continue;
                }
            }
        }

        for(int l = 0; l < friends.length; l++){
            if(willReceive[l] > answer){
                answer = willReceive[l];
            }
        }

        return answer;
    }
}
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curHealth = health;

        for (int i = 0; i < attacks.length; i++) {

            if (i > 0) {
                //bandage 시간을 재서 체력 회복
                int bandageTime = attacks[i][0] - attacks[i - 1][0] - 1;
                curHealth += bandageTime * bandage[1];

                //추가 체력 회복 시간을 재서 추가 회복
                if (bandageTime >= bandage[0]) {
                    curHealth += (bandageTime / bandage[0]) * bandage[2];
                }

                //체력이 시작 체력보다 많으면 변경
                if (curHealth > health)
                    curHealth = health;
            }

            //공격 받음
            curHealth -= attacks[i][1];
            if (curHealth <= 0) 
                return -1;
        }
        return curHealth;
    }
}
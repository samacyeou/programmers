#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int answer = health;
    int t = 0;
    int bandagecnt = 0;

    for(int time = 1; time<= attacks[attacks.size()-1][0]; time++){
        if(time == attacks[t][0]){
            answer = answer - attacks[t][1];
            t++;
            bandagecnt = 0;

            if(answer<=0) return -1;
        }
        else {
            bandagecnt++;
            answer += bandage[1];

            if(bandagecnt == bandage[0]){
                bandagecnt = 0;
                answer += bandage[2];

            }
            if(answer>health){
                answer = health;
            }
        }
    }

    return answer;
}
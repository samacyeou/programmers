#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;

    int restProgressCount = progresses.size();
    while(restProgressCount) {
        //하루 진행률 합산
        for(int i = 0; i < progresses.size(); i++) {
            progresses[i] += speeds[i];
        }


        int returnCount = 0;
        for(int i = 0; i < progresses.size(); i++) {
            if(progresses[0] < 100) { break; }

            progresses.erase(progresses.begin() + 0);
            speeds.erase(speeds.begin() + 0);
            returnCount++;
            restProgressCount--;
            i--;
        }

        if(returnCount > 0) {
            answer.push_back(returnCount);
        }
    }

    return answer;
}
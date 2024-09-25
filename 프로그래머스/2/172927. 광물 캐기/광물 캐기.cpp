#include <string>
#include <vector>

using namespace std;

int toInt(string ingredient)
{
    if (ingredient == "diamond")
        return 0;

    if (ingredient == "iron")
        return 1;

    if (ingredient == "stone")
        return 2;
}



int dfs(vector<int> picks, vector<vector<int>> fatigueList, int index, int fatigue) 
{
    // 곡괭이를 모두 썼거나, 이미 광물을 모두 캔 경우
    if (picks[0] + picks[1] + picks[2] == 0 || index >= fatigueList.size())
        return fatigue;

    int minFatigue = 749;

    for (int k = 0; k < 3; k++)
    {
        // k번째 곡괭이를 사용하여 광물을 캐는 경우
        if (picks[k] > 0)
        {
            picks[k]--;

            int tmp = dfs(picks, fatigueList, index + 1, fatigue + fatigueList[index][k]);

            if (minFatigue > tmp)
                minFatigue = tmp;

            picks[k]++;
        }
    }

    return minFatigue;

}


int solution(vector<int> picks, vector<string> minerals) {
    vector<int> intMinerals;

    for (auto mineral : minerals)
        intMinerals.push_back(toInt(mineral));

    vector<vector<int>> fatigueBoard = { {1,1,1}, {5,1,1}, {25,5,1} };

    vector<vector<int>> fatigueList;

    for (int i = 0; i < intMinerals.size(); i += 5)
    {
        vector<int> tmp(3, 0);

        int j = 0;
        while (j < 5 && i + j < intMinerals.size())
        {
            for(int k = 0; k < 3; k++)
                tmp[k] += fatigueBoard[k][intMinerals[i+j]];
            j++;
        }

        fatigueList.push_back(tmp);
    }

    return dfs(picks, fatigueList, 0, 0);
}
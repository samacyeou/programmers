#include <vector>
#include <unordered_map>
#include <sstream>
#include <algorithm>

using namespace std;

/*
  1. 친구들, 선물 정보 입력
  2. 친구들에게 입력 순서대로 고유 번호 지정
  3. 선물 정보에 대해
     1) 개개인의 선물 지수
     2) 고유번호를 바탕으로 준사람 - 받은 사람 정리

*/

int solution(vector<string> friends, vector<string> gifts)
{
    unordered_map<string, int> personalNum; // 고유번호 순
    unordered_map<int, int> giftRate; // 고유번호를 바탕으로 한 선물지수

    int friendNum = friends.size();

    for (int i = 0; i < friendNum; ++i)
    {
        personalNum[friends[i]] = i;
        giftRate[i] = 0;
    }

    vector<vector<int>> giftNum(friendNum, vector<int>(friendNum, 0)); // 행 = 준 ㅅ, 열 = 받은 ㅅ

    for (const string& s : gifts)
    {
        int senderNum, receiverNum;
        string sender, receiver;
        stringstream sst(s);

        sst >> sender >> receiver;

        senderNum = personalNum[sender];
        receiverNum = personalNum[receiver];

        giftRate[senderNum]++;
        giftRate[receiverNum]--;

        giftNum[senderNum][receiverNum]++;
    }

    vector<int> total(friendNum);

    for (int i = 0; i < friendNum; ++i)
    {
        for (int j = i + 1; j < friendNum; ++j)
        {
            if (giftNum[i][j] == giftNum[j][i])
            {
                if(giftRate[i] == giftRate[j])
                    continue;

                giftRate[i] < giftRate[j] ? total[j]++ : total[i]++;
            }
            else
            {
                giftNum[i][j] < giftNum[j][i] ? total[j]++ : total[i]++;
            }
        }
    }

    sort(total.rbegin(), total.rend());

    return total[0];
}
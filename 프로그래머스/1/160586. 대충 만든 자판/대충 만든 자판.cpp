#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    vector<char> str;

    for(int i=0; i<targets.size(); i++)
        answer.push_back(0);

    for(int i=0; i<keymap.size(); i++)
    {
        for(int j=0; j<keymap[i].size(); j++)
        {
            auto it = find(str.begin(), str.end(), keymap[i][j]);
            if(it != str.end())
            {   // 원소가 이미 존재할 경우
                if((j + 1) < str[it - str.begin() + 1])
                    str[it - str.begin() + 1] = (j + 1);
                continue;
            }
            str.push_back(keymap[i][j]);
            str.push_back((j + 1));
        }
    }

    for(int i=0; i<targets.size(); i++)
    {
        for(int j=0; j<targets[i].size(); j++)
        {
            auto it = find(str.begin(), str.end(), targets[i][j]);
            if(it != str.end())
            {
                answer[i] += str[it - str.begin() + 1];
            }
            else {
                answer[i] = -1;
                break;
            }
        }
    }

    return answer;
}
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer(targets.size(), 0);
    int maxSize = 0;


    for(string str : keymap)
    {
        maxSize = str.size() > maxSize ? str.size() : maxSize;
    }

    for(int index = 0; index < targets.size(); index++)
    {
        for(int k = 0; k < targets[index].size(); k++)
        {
            bool find = false;

            for(int i = 0; i < maxSize; i++)
            {
                if(find)
                    break;
                for(int j = 0; j < keymap.size(); j++)
                {
                    if(find)
                        break;
                    if(keymap[j].size() <= i) continue;
                    if(keymap[j][i] == targets[index][k])
                    {
                        if(answer[index] == -1)
                            break;
                        answer[index] += i + 1;
                        find = true;
                    }

                }
                if(i == maxSize - 1 && find == false)
                    answer[index] = -1;
            }
        }

    }


    return answer;
}
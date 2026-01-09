#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool compareStages(const pair<float, int>& a, const pair<float, int>& b);

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<float, int>> _vec_StageLosePercents;
    std::sort(stages.begin(), stages.end());

    int _iStageLevel = 1, _iStageFailCount = 0, _iStageIndex = 0;

    // 스테이지 레벨을 순회
    while (_iStageLevel <= N)
    {
        for (int i = 0; i < stages.size(); ++i)
        {
            if (stages[i] <= _iStageLevel)
                ++_iStageFailCount;
            else
                break;
        }

        float fStageLosePercent = (_iStageFailCount == 0 && stages.size() == 0) ? 0.0f : (float)_iStageFailCount / (float)stages.size();
        _vec_StageLosePercents.push_back(make_pair(fStageLosePercent, _iStageLevel));

        // if (_iStageFailCount == 0)
        // {
        //     if(!stages.empty())
        //         stages.erase(stages.begin());
        // }
        // else
        // {
            for (int i = 0; i < _iStageFailCount; ++i)
            {
                if (!stages.empty())
                    stages.erase(stages.begin());
            }
        // }

        _iStageFailCount = 0;
        ++_iStageLevel;
    }

    std::sort(_vec_StageLosePercents.begin(), _vec_StageLosePercents.end(), compareStages);

    for (auto i = 0; i < _vec_StageLosePercents.size(); ++i)
        answer.push_back(_vec_StageLosePercents[i].second);

    return answer;
}

bool compareStages(const pair<float, int>& a, const pair<float, int>& b) 
{
    if (a.first != b.first) {
        return a.first > b.first;
    }

    return a.second <= b.second;
}
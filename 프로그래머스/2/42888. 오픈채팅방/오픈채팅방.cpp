#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<pair<bool, string>> order;
    map<string, string> names;

    for (unsigned int i = 0; i < record.size(); i++) {
        int idIdx = record[i].find(" ", 0) + 1;
        while(record[i][idIdx] == ' ') idIdx++;
        int blankIdx = record[i].find(" ", idIdx);

        if (blankIdx == -1)
            blankIdx = record[i].size();

        string id = record[i].substr(idIdx, blankIdx - idIdx);
        if (record[i][0] == 'L') {
            order.push_back(make_pair(false, id));
        } else {
            names[id] = record[i].substr(blankIdx + 1);
            if (record[i][0] == 'E') {
                order.push_back(make_pair(true, id));
            }
        }
    }

    vector<string> answer;
    for (unsigned int i = 0; i < order.size(); i++) {
        string newStr = names[order[i].second] + "님이 ";
        newStr += order[i].first == true ? "들어왔습니다." : "나갔습니다.";
        answer.push_back(newStr);
    }

    return answer;
}
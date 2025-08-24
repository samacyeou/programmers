#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    string first = "RCJA";
    string second = "TFMN";

    map<char, vector<int>> m = {
        {'R', {0, 0}}, {'T', {0, 1}},
        {'C', {1, 0}}, {'F', {1, 1}},
        {'J', {2, 0}}, {'M', {2, 1}},
        {'A', {3, 0}}, {'N', {3, 1}}
    };
    vector<vector<int>> score(4, vector<int>(2, 0));

    for(int i = 0; i < survey.size(); i++) {
        char keyA = survey[i][0];
        char keyB = survey[i][1];
        
        if(choices[i] == 4) continue;
        else if(choices[i] < 4) score[m[keyA][0]][m[keyA][1]] += 4 - choices[i];
        else score[m[keyB][0]][m[keyB][1]] += choices[i] - 4; 
    }

    for(int i = 0; i < 4; i++) {
        if(score[i][0] >= score[i][1]) answer += first[i];
        else answer += second[i];
    }

    return answer;
}
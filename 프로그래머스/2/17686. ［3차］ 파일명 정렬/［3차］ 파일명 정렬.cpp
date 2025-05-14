#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<string> slice(string n){

    string head;
    string number;
    string tail;

    for(char i : n){
        if(i>=48 && i<=57 && number.size()<5){
            number.push_back(i);
        }else if(number==""){
            head.push_back(i);
        }else{
            break;
        }
    }

    return {head, number, n};

}

vector<string> solution(vector<string> files) {
    vector<string> answer;
    vector<vector<string>> v;

    int index = 0;

    for(string i : files){
        vector<string> temp = slice(i);
        string l = temp[0];

        for (int j = 0; j < l.length(); j++)
            l[j] = toupper(l[j]);

        temp.push_back(to_string(index));
        temp[0] = l;
        v.push_back(temp);
        index++;
    }

    sort(v.begin(), v.end(), [](const vector<string>& a, const vector<string>& b){

        if(a[0]!=b[0])
            return a[0] < b[0];
        else if(stoi(a[1])!=stoi(b[1]))
            return stoi(a[1]) < stoi(b[1]);
        else
            return stoi(a[3]) < stoi(b[3]);
    });

    for(auto i : v){
        answer.push_back(i[2]);
    }

    return answer;
}
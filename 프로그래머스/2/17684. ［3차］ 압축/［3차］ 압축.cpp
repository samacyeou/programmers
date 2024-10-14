#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
map<string,int> MP;

string extract (string msg, int st, int en){
    string result;
    for(int i=st;i<=en;i++) result += msg[i];
    return result;
}

vector<int> solution(string msg) {
    vector<int> answer;
    for(int i=1;i<=26;i++){
        char idxCh = 'A' + i - 1;
        string mpIdx {idxCh};
        MP[mpIdx] = i;
    };
    int mpIdx = 27;
    int st = 0;
    int en = 0;
    while(en < msg.size()){
        auto curW = extract(msg,st,en);
        auto WC = extract(msg,st,en+1);
        if(MP.find(WC) != MP.end()) en++;
        else {
            MP[WC] = mpIdx++;
            answer.push_back(MP[curW]);
            en = en + 1;
            st = en;
        }
    }
    // cout << "st : " << st << " en : " << en << "\n";
    if(st != en) {
        string left = extract(msg,st,en-1);
    }

    // for(auto cur : answer) cout << cur << " \n";


    return answer;
}
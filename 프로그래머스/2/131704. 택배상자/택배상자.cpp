#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    stack<int> s;
    int cur = 0;
    for(int i=1;i<=order.size();i++) {
        if(i != order[cur]) {
            if(!s.empty() && s.top() == order[cur]){
                s.pop();
                answer++;
                cur++;
                i--;
            }
            else{
                s.push(i);    
            }
        }
        else {
            answer++;
            cur++;
        }
    }

    while(!s.empty()){
        int temp = s.top();
        if(order[cur] == temp){
            answer++;
            cur++;
            s.pop();
        }
        else{
            break;
        }
    }

    return answer;
}
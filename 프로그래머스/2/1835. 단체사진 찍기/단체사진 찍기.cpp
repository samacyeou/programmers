#include <string>
#include <cmath>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
int N=0;

bool check(string s, vector<char>* condition, int n){
    for(int i=0;i<n;i++){
        int first_idx = s.find(condition[i][0]); //N
        int second_idx = s.find(condition[i][1]); //F
        char cond = condition[i][2]; //=
        int num = condition[i][3]-'0'; // 2
        int dist = abs(first_idx - second_idx);
        if(cond == '>'){
            if(!(dist-1>num)) return false;
        }else if(cond == '<'){
            if(!(dist-1<num)) return false;
        }else{
            if(dist-1 != num) return false;
        }
    }
    return true;
}

int solve(vector<char>* condition, int n){
    string s = "ACFJMNRT";
    int count = 0;
    do{
        if(check(s, condition, n)) count++;
    }while(next_permutation(s.begin(),s.end()));
    
    return count;
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, vector<string> d) {
    int answer = 0;
    vector<char> condition[n];
    
    for(int i=0;i<n;i++){
        condition[i].push_back(d[i][0]);
        condition[i].push_back(d[i][2]);
        condition[i].push_back(d[i][3]);
        condition[i].push_back(d[i][4]);
    }
    
    N=n;
    answer = solve(condition, n);

    return answer;
}
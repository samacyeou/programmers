#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    vector<long long> temp;

    while(n != 0){
    temp.push_back(n%10);
    n /= 10;
    }

    sort(temp.begin(), temp.end());

    for(int i = temp.size()-1; i>= 0; i--){
        answer = answer*10 + temp[i];
    }
    return answer;
}
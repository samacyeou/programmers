#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

int solution(vector<int> array) {
    int answer = 0, a = 0, b=0,max=0;
    map<int, int> m;
    
    for (int i = 0; i < array.size(); ++i) {
        a = count(array.begin(), array.end(), array[i]);
        m.insert({ array[i],a });
    }
    
    for (auto iter = m.begin(); iter != m.end(); iter++){
        if (max < iter->second) {
            max = iter->second;
            answer = iter->first;
            b = 0;
        } else if (max == iter->second) {
            answer = iter->first;
            b++;
        }
    }
    
    if (b > 0) { return -1; }
    return answer;
}
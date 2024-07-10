#include <iostream>

#include <string>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;


vector<int> solution(string s) {
    vector<int> answer;

    int convert_zero = 0;
    int count = 0;
    int sum = 0;

    vector<int> vec;

    for(auto it : s)
    {
        vec.push_back(atoll(&it));
    }
    while(vec.size() != 1)
    {
        // sort(vec.begin(), vec.end(), greater<>());
        count++;

        for(int i = 0; i < vec.size(); i++)
        {
            if(vec[i] == 0)
            {
                convert_zero++;
            }
        }

        for(auto it : vec)
            sum += it;

        vec.clear();

        while(sum != 0)
        {
            if(sum % 2 == 1)
                vec.push_back(1);
            else
                vec.push_back(0);

            sum /= 2;
        }
    }

    answer.push_back(count);
    answer.push_back(convert_zero);

    return answer;
}
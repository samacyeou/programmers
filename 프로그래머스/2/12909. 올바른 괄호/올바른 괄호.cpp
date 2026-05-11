#include <bits/stdc++.h>
using namespace std;


bool solution(string s)
{
    bool answer = true;
    
    int count = 0;
    for (auto& item : s)
    {
        if (item == '(')
        {
            count++;
        }
        else if (item == ')')
        {
            count--;
        }
        
        if (count < 0)
        {
            answer = false;
            break;
        }
    }
    
    if (count != 0) answer = false;

    return answer;
}
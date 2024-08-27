#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = true;

    int count1{}, count2{};
    for (const char& ch : s)
    {
        if (ch == 'p' || ch == 'P')
        {
            ++count1;
        }
        if (ch == 'y' || ch == 'Y')
        {
            ++count2;
        }
    }

    if (count1 != count2)
    {
        answer = false;
    }
    return answer;
}
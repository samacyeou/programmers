#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool solution(bool x1, bool x2, bool x3, bool x4) {
    bool answer = true;

    if(x1 || x2 == true)
    {
        if(x3 || x4 == true)
        {
            answer = true;
        }
        else if(x3 || x4 == false)
        {
            answer = false;
        }
    }
    else if(x1 || x2 == false)
    {
        if(x3 || x4 == true)
        {
            answer = false;
        }
        else if(x3 || x4 == false)
        {
            answer = false;
        }
    }

    return answer;
}
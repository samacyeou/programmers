#include <bits/stdc++.h>
using namespace std;

int solution(string str)
{
    size_t str_len = str.length();
    if(str_len & 1) return false; // (==s_len % 2 == s_len is odd)
    auto *st = &str[0];
    auto *ed = &str[0] + str_len;

    size_t top = 0;

    for(auto p = st; p<ed; p++){
        if(top && *p == str[top-1]) --top;
        else str[top++] = *p;
    }

    return !top;
}
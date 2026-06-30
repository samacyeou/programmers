#include <stack>
#include<string>
using namespace std;

int solution(string s)
{
    int answer = -1;
    stack<char> st;
    st.push(s[0]);
    for(int i = 1; i < s.size(); i++) {
        // if(st.top() == s[i]) {
        if(!st.empty() && st.top() == s[i]){
            st.pop();
        }
        else st.push(s[i]);
    }
    return st.empty() ? 1 : 0;
}
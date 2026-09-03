#include <string>
#include <vector>
#include <set>
#include <iostream>
#include <cmath>
#include <stdexcept>
#include <cmath>

using namespace std;

int solution(int a, int b, int c, int d) {
    int answer = 0;
    set<int>::iterator iter;
    set<int> s={a,b,c,d};
    if (s.size()==1) {answer=1111*(*s.begin());}
    else if (s.size()==4) {answer=*s.begin();}
    else if (s.size()==3) {
        int temp=1;
        for(iter=s.begin();iter!=s.end();iter++) temp=temp*(*iter);
        answer=temp/(a*b*c*d/temp);
    }
    else if(s.size()==2) {
        int temp=1;
        for(iter=s.begin();iter!=s.end();iter++) temp=temp*(*iter);
        // if(a==b&&b!=c&&c==d || a!=b&&a==c&&b==d || a!=b&&a==d&&b==c) {
        if(a*b*c*d/pow(temp,2)==1) {
            // answer=(*s.begin()+(*s.rbegin()))*(*s.begin()-(*s.rbegin()));
            if(a!=b) answer = (a+b) * abs(a-b);
            else answer = (a+c) * abs(a-c);
        }
        else answer=pow((10*sqrt(a*b*c*d/temp)+temp/sqrt(a*b*c*d/temp)),2);
    }
    return answer;
}
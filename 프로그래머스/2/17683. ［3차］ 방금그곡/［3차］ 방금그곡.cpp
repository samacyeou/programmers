#include <bits/stdc++.h>

using namespace std;

struct music{
    int odr;
    int st;
    int et;
    string name;
    string rhyme;
};

string solution(string m, vector<string> musicinfos) {
    string answer = "";
    string temp="";
    string time="";
    istringstream ms;
    istringstream ts;
    int rnd=0;
    int idx=0;
    int seq=1;
    int cnt=0;
    int h=0;
    int minute=0;
    int len=0;
    int sharf=0;
    bool in=0;
    vector<music> store;
    music compare;

    for(string song:musicinfos) {
        idx=0;
        compare.odr=rnd;
        ms.str(song);
        while(getline(ms,temp,',')) {
            if(idx==0) {
                seq=0;
                ts.str(temp);
                while(getline(ts,time,':')) {
                    if(seq==0) {
                        h=stoi(time);
                    }
                    else {
                        minute=stoi(time);
                    }
                    ++seq;
                }
                compare.st=h*60+minute;
                ts.clear();
            }
            else if(idx==1) {
                seq=0;
                ts.str(temp);
                while(getline(ts,time,':')) {
                    if(seq==0) {
                        h=stoi(time);
                    }
                    else {
                        minute=stoi(time);
                    }
                    ++seq;
                }
                compare.et=h*60+minute;
                ts.clear();
            }
            else if(idx==2) {
                compare.name=temp;
            }
            else {
                compare.rhyme=temp;
            }
            ++idx;
        }

        len=compare.rhyme.size();
        cnt=0;
        seq=0;
        idx=0;
        in=0;
        while(seq<=compare.et-compare.st&&cnt<m.size()) {
            
           // cout<<compare.rhyme<<", cnt:"<<cnt<<", in:"<<in<<", seq:"<<seq<<", idx:"<<idx<<", compare:"<<compare.rhyme[idx%len]<<", m:"<<m[cnt]<<endl;
            if(!in) {
                if(compare.rhyme[idx%len]==m[cnt]) {
                    in=1;
                    ++sharf;
                    ++cnt;
                }
            }
            else {
                if(compare.rhyme[idx%len]!=m[cnt]) {
                    in=0;
                    idx-=cnt;
                    seq-=(cnt-sharf+1);
                    cnt=0;
                    sharf=0;
                }
                else {
                    if(compare.rhyme[idx%len]=='#') {
                        ++sharf;
                    }
                    ++cnt;
                }
            }

            if(cnt>=m.size()&&compare.rhyme[(idx+1)%len]=='#') {
                in=0;
                idx-=(cnt-1);
                seq-=((cnt-1)-sharf+1);
                cnt=0;
                sharf=0;
            }

            ++idx;
            if(compare.rhyme[idx%len]!='#') {
                ++seq;
            }
        }
        
        if(in&&cnt>=m.size()&&compare.rhyme[idx%len]!='#') {
            store.push_back(compare);
        }

        ++rnd;
        ms.clear();
    }

    if(store.size()==0) {
        return "(None)";
    }

    sort(store.begin(),store.end(),[](music a, music b) {
        if(a.et-a.st==b.et-b.st) {
            return a.odr<b.odr;
        }
        return a.et-a.st>b.et-b.st;
    });
    
    answer=store[0].name;

    return answer;
}
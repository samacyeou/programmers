#include <bits/stdc++.h>
#include <iostream>

using namespace std;

string convHash(string music) {
    music += '0';
    string s;
    for(int i = 0; i < music.length() - 1; i++) {
        if(music[i+1] == '#') {
            s += (char)(music[i] + 8);
            i++;
        } else s += music[i];
    }
    
    return s;
}

string solution(string s, vector<string> musicinfos) {
    string answer = "(None)";
    int ansTime = 0;
    string m = convHash(s);

    for (int i = 0; i < musicinfos.size(); i++) {
        string t1;
        string t2;
        string name;
        string mus;
        string info = musicinfos[i];

//         replace(info.begin(),info.end(), ',', ' ');

//         stringstream ss(info);
//         ss >> t1 >> t2 >> name >> mus;
        
        t1 = info.substr(0, 5);
        t2 = info.substr(6, 5);
        int idx = info.find(',', 12);
        name = info.substr(12, idx-12);
        mus = info.substr(idx+1);

        int start = stoi(t1.substr(0, 2)) * 60 + stoi(t1.substr(3));
        int end = stoi(t2.substr(0, 2)) * 60 + stoi(t2.substr(3));
        int sub = end - start; 

        string music = convHash(mus);
        string played = "";
        int len = music.length();

        for (int j = 0; j < sub; j++) played += music[j % len];

        int t = played.find(m);
        if(t != string::npos) {
            if (ansTime < sub) {
                ansTime = sub;
                answer = name;
            }
        }

    }

    return answer;
}
#include <bits/stdc++.h>
#include <iostream>
#include <string>

using namespace std;

void convHash(string &music) {
    map<char, char> m = {{'C', 'Q'}, {'D', 'R'}, {'F', 'S'},
                         {'G', 'T'}, {'A', 'U'}};

    for(int i = 0; i < music.length(); i++) {
        if (music[i] == '#') { 
            music[i - 1] = m[music[i - 1]];
            music.erase(music.begin() + i);
            i--;
        }
    }
}

string solution(string m, vector<string> musicinfos) {
    string answer = "(None)";
    int ansTime = 0;
    convHash(m);

    for (int i = 0; i < musicinfos.size(); i++) {
        string t1;
        string t2;
        string name;
        string music;
        string info = musicinfos[i];

        // replace(info.begin(),info.end(), ',', ' ');
        
        // string temp = " ";
        // while(info.find(',') != string::npos) {
        //     info.replace(info.find(','), 1, temp);
        // }

        // stringstream ss(info);
        // ss >> t1 >> t2 >> name >> mus;
        
        t1 = info.substr(0, 5);
        t2 = info.substr(6, 5);
        int idx = info.find(',', 12);
        name = info.substr(12, idx-12);
        music = info.substr(idx+1);

        int start = stoi(t1.substr(0, 2)) * 60 + stoi(t1.substr(3));
        int end = stoi(t2.substr(0, 2)) * 60 + stoi(t2.substr(3));
        int sub = end - start; 

        convHash(music);
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
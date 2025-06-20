#include <string>
#include <vector>
#include <iostream>

using namespace std;

int con_ti(string time) {
    int m = (time[0] - '0') * 10 + (time[1] - '0');
    int s = (time[3] - '0') * 10 + (time[4] - '0');
    return m * 60 + s;
}

string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    string answer = "";
    int pos_m = (pos[0] - '0') * 10 + (pos[1] - '0');
    int pos_s = (pos[3] - '0') * 10 + (pos[4] - '0');
    int pt = con_ti(pos);

    int op_start_m = (op_start[0] - '0') * 10 + (op_start[1] - '0');
    int op_start_s = (op_start[3] - '0') * 10 + (op_start[4] - '0');
    int ost = con_ti(op_start);

    int op_end_m = (op_end[0] - '0') * 10 + (op_end[1] - '0');
    int op_end_s = (op_end[3] - '0') * 10 + (op_end[4] - '0');
    int oet = con_ti(op_end);

    int video_len_m = (video_len[0] - '0') * 10 + (video_len[1] - '0');
    int video_len_s = (video_len[3] - '0') * 10 + (video_len[4] - '0');
    int vt = con_ti(video_len);
    
    for(int i=0; i<commands.size(); i++) {
        // if(pos_m >= op_start_m && pos_m <= op_end_m) {
        //     if(op_start_m == op_end_m) {
        //         if(pos_s <= op_end_s && pos_s >= op_start_s) {
        //             pos_m = op_end_m;
        //             pos_s = op_end_s;
        //         }   
        //     } else {
        //         if(pos_s >= op_start_s && pos_m < op_end_m) {
        //             pos_m = op_end_m;
        //             pos_s = op_end_s;
        //         } 
        //         if(pos_m == op_end_m && pos_s <= op_end_s){
        //             pos_m = op_end_m;
        //             pos_s = op_end_s;
        //         }
        //     }
        // }
        if(pt >= ost && pt <= oet) pt = oet;
        
        if(commands[i] == "next") {
            pos_s += 10;
            if(pos_s >= 60) {
                pos_s -= 60;
                pos_m += 1;
            }
            pt += 10;
        }
        if(commands[i] == "prev") {
            pos_s -= 10;
            if(pos_s < 0) {
                pos_s += 60;
                pos_m -= 1;
            }
            pt -= 10;
        }

        if(pos_m < 0) {
            pos_m = 0;
            pos_s = 0;
        }
        if(pt < 0) pt = 0;

        if(pos_m > video_len_m || (pos_m == video_len_m) && (pos_s > video_len_s)) {
            pos_m = video_len_m;
            pos_s = video_len_s;
        }
        if(pt > vt) pt = vt;
    }
    
    // if(pos_m >= op_start_m && pos_m <= op_end_m) {
    //     if(op_start_m == op_end_m) {
    //         if(pos_s <= op_end_s && pos_s >= op_start_s) {
    //             pos_m = op_end_m;
    //             pos_s = op_end_s;
    //         }   
    //     } else {
    //         if(pos_s >= op_start_s && pos_m < op_end_m) {
    //             pos_m = op_end_m;
    //             pos_s = op_end_s;
    //         } 
    //         if(pos_m == op_end_m && pos_s <= op_end_s){
    //             pos_m = op_end_m;
    //             pos_s = op_end_s;
    //         }
    //     }
    // }
    if(pt >= ost && pt <= oet) pt = oet;
    
    int mm = pt / 60;
    int ss = pt % 60;
    
    string result = "";
    if(pos_m < 10) {
        answer += "0";
    }
    if(mm < 10) {
        result += "0";
    }
    
    answer += to_string(pos_m);
    result += to_string(mm);
    answer += ":";
    result += ":";
    if(pos_s < 10) {
        answer += "0";
    }
    if(ss < 10) {
        result += "0";
    }
    
    answer += to_string(pos_s);
    result += to_string(ss);
    return result;
}
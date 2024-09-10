#include <string>
#include <vector>

using namespace std;

string solution(string code) {
    string answer = "";
    string ret = "";

    bool mode = false;
    int size = code.size();

    for (int i=0;i<size;i++){

        if(code[i]=='1'){
            mode = !mode;
            continue;
        }
        if(mode==false&&i%2==0){
            ret += code[i];
        }
        else if(mode==true&&i%2==1){
            ret += code[i];
            }
        }
    answer = ret;

    if (answer.size()==0) answer = "EMPTY";

    return answer;
}
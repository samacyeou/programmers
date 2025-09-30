#include <string>
#include <vector>

using namespace std;

string solution(string code) {
    string answer = "";
    bool mode = false;
    for(int i = 0 ; i < code.size() ; i++ ){
        if(code[i]=='1')
            mode = !mode;
        else {
            if(i%2==0 && mode == false)
                answer.push_back(code[i]);
            if(i%2==1 && mode == true)
                answer.push_back(code[i]);
        }

    }
    
    if(answer == "") return "EMPTY";
    return answer;
}
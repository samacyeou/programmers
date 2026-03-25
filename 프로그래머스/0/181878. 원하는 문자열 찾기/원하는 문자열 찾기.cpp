#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    int size1 = myString.length();
    int size2 = pat.length();



    if(size1 < size2) answer = 0;
    else{
        //myString, pat의 문자열을 모두 소문자로 변환
        for(int i = 0; i < size1; i++){
            if(myString[i] >= 'A' && myString[i] <= 'Z') myString[i] += 32;
        }
        for(int i = 0; i < size2; i++){
            if(pat[i] >= 'A' && pat[i] <= 'Z') pat[i] += 32;
        }

        //두 문자열을 비교
        int sucess = 0;
        for(int i = 0; i < size1; i++){
            if(myString[i] == pat[0]){
                for(int j = 0; j < size2; j++){
                    if(myString[i+j] == pat[j]) sucess++;
                    else { sucess = 0; break; }
                }
                if(sucess == size2) {
                    answer = 1;
                    break;
                }
            }
        }
    }


    return answer;
}
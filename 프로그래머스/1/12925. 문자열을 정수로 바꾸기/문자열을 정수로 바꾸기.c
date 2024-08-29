#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define MINUS    1
#define PLUS    0

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* s) {
    int answer = 0; int len = 0; int flag = 0;
    int deci = 1; int num  = 0; int start = 0;
    len = 0;
     if(s[0] == '-'){
            start = MINUS;
            flag = MINUS;
             while(s[len+1] != '\0'){
                len++;
             }
     } else if(s[0] == '+') {
         start = MINUS;
         flag = PLUS;
         while(s[len+1] != '\0') {
             len++;
         }
     }else{
            start = PLUS;
            flag = PLUS;

             while(s[len] != '\0'){
                len++;
             }
     }
    int temp = len;

    while(s[start] != '\0'){
        if(flag){ //minus
            for(int i=temp-1;i>0;i--){
                deci *= 10;
            }
            num -= deci * ((int)(s[start] -48));
        }else{ //plus
            for(int i=(temp-1);i>0;i--){
                deci *= 10;
            }
            num += deci * ((int)(s[start] -48));
        }
        deci = 1;
        temp--;
        start++;
    }
    printf("%d\n", num);
    answer = num;
    return answer;
}
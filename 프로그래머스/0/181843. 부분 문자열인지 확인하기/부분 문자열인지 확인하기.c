#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* str, const char* tgt) {
    int ans = 0;
    int i, j;
    int tlen = 0, slen = 0;

    for(i=0; *(str+i)!='\0'; i++)
        slen++;

    for(i=0; *(tgt+i)!='\0'; i++)
        tlen++;

    for(i=0; i<slen; i++){
        if(*(str+i)==*tgt && slen>=tlen){
            if(tlen==1) {
                ans=1;
                break;
            } else if(tlen>1){
                for(j=1; j<tlen; j++){
                    if(*(str+i+j)==*(tgt+j))
                        ans=1;
                    else {
                        ans=0;
                        break;
                    }
                }
            }
            }
            if(ans==1)
                break;
        }


    return ans;
}
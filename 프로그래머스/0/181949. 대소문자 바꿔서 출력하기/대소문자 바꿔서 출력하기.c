#include <stdio.h>
#include<ctype.h>
#define LEN_INPUT 20

int main(void) {
    char s1[LEN_INPUT];
    scanf("%s", s1);

    for(int i=0; i<LEN_INPUT; i++){
        if(isupper(s1[i])){ 
            s1[i] = tolower(s1[i]); //소문자 -> 대문자
        } 
        else
        { 
            s1[i] = toupper(s1[i]); //대문자 -> 소문자
        } 
    }
    printf("%s",s1);

    return 0;
}
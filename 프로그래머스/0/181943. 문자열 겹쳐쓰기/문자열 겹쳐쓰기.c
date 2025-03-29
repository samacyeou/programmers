#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string, const char* overwrite_string, int s) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int my_len = strlen(my_string);
    int overwrite_len = strlen(overwrite_string);

    char* answer = (char*)malloc(sizeof(char)*my_len+1);

    strcpy(answer, my_string);
    // printf("%d %d", my_len, overwrite_len);
    int j = 0;
    for(int i=s; i< overwrite_len + s; i++){
        // if(i>=s){
            // if(overwrite_string[j] == '\0')
            // {
            //     break;
            // }
            answer[i] = overwrite_string[j];
                j++;
        // } 
        // else {
        //     answer[i] = my_string[i];
        // }
    }

    return answer;
}
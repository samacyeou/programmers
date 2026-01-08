#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* n_str)
{
    if (n_str == NULL || n_str[0] == '\0') 
    {
    return NULL;
    }

    size_t n_str_len = strlen(n_str);
    /*if(n_str_len < 2 || n_str_len > 10)
    {
        return NULL;
    }*/

    size_t count = 0;
    while(count < n_str_len && n_str[count] == '0')
    {
        count++;
    }

    size_t result_len = n_str_len - count +1;

    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(result_len * sizeof(char));
    if(answer == NULL)
    {
        printf("메모리 할당 실패");
        return NULL;

    }

    if(count < n_str_len)
    {
        strcpy(answer, n_str + count);
    }
    else
    {
        answer[0] = '\0';
    }



    return answer;
}
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

long long solution(const char* numbers) {
    const char* numbers_list[] = {"zero", "one", "two", "three", "four", 
                                  "five", "six", "seven", "eight", "nine"};
    long long answer = 0;
    long long digit = 1;
    int num_len = strlen(numbers);

    char* cTemp = (char*)malloc(sizeof(char) * (5 + 1)); // 각 숫자 영어는 최대 길이 5
    int ctmpIdx = 0;

    long long* iTemp = (long long*)malloc(sizeof(long long) * (50));
    long long itmpIdx = 0;

    for(int i = 0; i < num_len; i++){
        cTemp[ctmpIdx++] = numbers[i];
        cTemp[ctmpIdx] = '\0';
        for(int j = 0; j < 10; j++){
            if(strcmp(cTemp, numbers_list[j]) == 0){
                iTemp[itmpIdx++] = j;
                ctmpIdx = 0;
            }
        }
    }

    free(cTemp);

    for(int i = itmpIdx - 1; i >= 0; i--){
        answer += iTemp[i] * digit;
        digit *= 10;
    }

    free(iTemp);
    return answer;
}
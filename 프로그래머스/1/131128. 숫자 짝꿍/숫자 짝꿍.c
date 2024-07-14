#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
char* solution(const char* X, const char* Y) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc((strlen(X) + strlen(Y) + 1));
    int arrayX[10] = { 0 }, arrayY[10] = { 0 };
    int k = 0;
    for (int i = 0; i < strlen(X); i++) { // x 문자열 검사
        arrayX[X[i] - 48]++;
    }
    for (int i = 0; i < strlen(Y); i++) { // y 문자열 검사
        arrayY[Y[i] - 48]++;
    }
    for (int i = 9; i >= 0; i--) { 
        if (arrayX[i] > 0 && arrayY[i] > 0) { // 두 문자열에서 공통으로 존재하는 문자만 실행
            if (arrayX[i] <= arrayY[i]) { // x배열이 빈도가 적을 경우
                for (int j = 0; j < arrayX[i]; j++) {
                    answer[k] = i + 48;
                    k++;
                }
            }
            else if (arrayY[i] < arrayX[i]) { // y배열이 빈도가 적을 경우
                for (int j = 0; j < arrayY[i]; j++) {
                    answer[k] = i + 48;
                    k++;
                }
            }
        }
    }
    
    // for (int i = 0; i < k - 1; i++) { // 내림차순 정렬
    //     for (int j = i+1; j < k; j++) {
    //         if (answer[i] < answer[j]) {
    //             char temp = answer[i];
    //             answer[i] = answer[j];
    //             answer[j] = temp;
    //         }
    //     }
    // }
    if (k == 0) { // 공통된 문자가 없는 경우 예외처리
        strcpy(answer, "-1");
    }
    else if (answer[0] == '0') { // 내림차순 정렬 후 첫 원소가 0일 경우 예외처리
        answer[1] = '\0';
    }
    else answer[k] = '\0'; // 마지막 원소에 NULL 
    return answer;
}
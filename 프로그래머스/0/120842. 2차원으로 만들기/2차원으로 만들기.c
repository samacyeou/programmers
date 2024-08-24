#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// num_list_len은 배열 num_list의 길이입니다.
int** solution(int num_list[], size_t num_list_len, int n) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int row = num_list_len / n;
    int** answer = (int**)malloc(row * sizeof(int*));
    for (int i = 0; i < row; i++) {
        answer[i] = (int*)malloc(sizeof(int) * n);
    }
    // int count = 0;
    // while (count < num_list_len) {
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < n; j++) {
    //             answer[i][j] = num_list[count++];
    //         }
    //     }
    // }
    int x = 0, y = 0;
    for (int i = 0; i < num_list_len; i++) {
        answer[x][y++] = num_list[i];
        if (y == n) {
            y = 0;
            x++;
        }
    }
    return answer;
}
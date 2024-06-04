#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {

    int answer = 0;

    for(int i = 1; i <= n; i++) {
        float temp = n / (float)i;
        if(temp == (int)(temp / 1)) answer++;
        // for(int j = 1; j <= n; j++) {
        //     if(i * j == n) {
        //         answer++;
        //         break;
        //     }
        // }
    }
    
    return answer;
}
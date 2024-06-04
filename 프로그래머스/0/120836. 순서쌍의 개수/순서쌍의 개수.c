#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {

    int answer = 0;

    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            if(i * j == n) {
                answer++;
                break;
            } else if(i * j > n) break;
        }
    }
    
    return answer;
}
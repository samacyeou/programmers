#include <stdio.h>

int main(void) {
    int a;

    scanf("%d", &a);

    if ((a + 1) % 2 == 0)
    {
        printf("%d is odd",a); //홀수 출력
    }
    else
    {
        printf("%d is even",a); //짝수출력
    }
    return 0;
}
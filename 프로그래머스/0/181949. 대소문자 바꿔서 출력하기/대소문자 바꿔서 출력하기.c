#include <stdio.h>
#define LEN_INPUT 10

int main(void)
{
    char s1[LEN_INPUT];
    scanf("%s", s1);

size_t len1 = strlen(s1);

//배열을 입력받음
//입력받은 배열이 소문자이면 + 32
//입력받은 배열이 대문자이면 -32

char s2[len1];

for (int i =0; i<len1; i++)
{
    if(s1[i] >='A' && s1[i] <= 'Z')
    {
    s2[i] = s1[i]+32;

    }
    else if( s1[i] >= 'a' && s1[i] <= 'z')
    {
    s2[i] = s1[i]-32;  
    }
    else
    {
    s2[i] = s1[i];
    }
}
    s2[len1] = '\0';  
    printf("%s\n", s2);

    return 0;
}
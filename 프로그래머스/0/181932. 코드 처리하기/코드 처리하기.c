#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

char* solution(const char* code) {
    int i,cidx=0,mode=0,ridx=0;
    char ret[100000];
    while(code[cidx]!='\0')
    {
        if(mode==0)
        {
            if(code[cidx]=='1')
            {
                mode=1;
            }
            else if(code[cidx]!='1')
            {
                if(cidx%2==0)
                {
                    ret[ridx]=code[cidx];
                    //printf("%c %c %d %d %d",ret[ridx],code[cidx],ridx,cidx,mode);
                    ridx++;
                }
            }
        }
        else if(mode==1)
        {
            if(code[cidx]!='1')
            {
                if(cidx%2==1)
                {
                    ret[ridx]=code[cidx];
                    ridx++;

                }
            }
            else if(code[cidx]=='1')
            {
                mode=0;
            }

        }

        cidx++;



    }

    //printf("%s %s",code,ret);
    //printf("%c %c %d %d %d",ret[ridx],code[cidx],ridx,cidx,mode);

    char* empty = (char*)malloc(6); // "EMPTY" + '\0'
    strcpy(empty, "EMPTY");
    if(ridx==0)
    {
        return empty;
    }

    ret[ridx]='\0';
    char* answer = (char*)malloc(ridx+1);    
    strcpy(answer,ret);
    return answer;
}
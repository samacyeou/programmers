#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// void sortingScore_Quick( int arr[], int start, int end )
// {
//     int key = start;
//     int i = start +1; // --->
//     int j = end;  //  <---

//     while( i <=j )
//     {
//         while( i <= end && arr[i] >= arr[key])  i++;
//         while( j > start && arr[j] <= arr[key]) j--;

//         if( i > j ) swap(&arr[key], &arr[j]);
//         else        swap(&arr[i], &arr[j]);
//     }
// }

int compare(const void* a, const void* b) {
    return *(int*)b - *(int*)a;
    }

// score_len은 배열 score의 길이입니다.
int solution(int k, int m, int score[], size_t score_len) {
    int answer = 0;
    int temp = 0;

    if( score_len < m) return 0;

    // sortingScore_Quick(score, 0, score_len-1); // Timeout 79.2
    
    // for(int i = 0; i < score_len; i++) {
    //     for(int j = i+1; j < score_len; j++) {
    //         if(score[i] < score[j]) {
    //             temp = score[j];
    //             score[j] = score[i];
    //             score[i] = temp;
    //         }
    //     }
    // }
    
    qsort(score, score_len, sizeof(int), compare);

    int profitSum = 0;
    int profit = 0;

    for(int i = 0; (i+m) <= (score_len); i += m)
    {

        int lowScore = (score[i+m-1]);
        profit = m * lowScore; 
        profitSum += profit;
    }

    answer = profitSum;

    return answer;
}
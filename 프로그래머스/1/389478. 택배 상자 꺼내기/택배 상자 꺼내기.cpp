#include <iostream>
using namespace std;

// num = 상자번호, w = 한 층 최대 상자 수, n = 전체 상자 수
int solution(int n, int w, int num) {
    int answer = 0;

    int floor = (num + w - 1) / w;       // 현재 층 (1부터)
    int locate = (num - 1) % w;          // 해당 층 내 위치
    // 홀수층 짝수층 번호 맞추기
    int col = (floor % 2 == 1) ? locate : (w - 1 - locate);

    int maxfloor = (n + w - 1) / w;      // 총 층 수

    for (int i = floor; i <= maxfloor; ++i) {
        int BoxfloorCount; // 마지막 층 상자 개수
        if (i == maxfloor) {
            BoxfloorCount = n - (i - 1) * w;
        } else {
            BoxfloorCount = w;
        }

        if (i % 2 == 1) {
            if (col <= BoxfloorCount) answer++;
        } else {
            if (col >= w - BoxfloorCount) answer++;
        }
    }
    return answer;
}
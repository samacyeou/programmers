#include <string>
#include <vector>
#include <queue>

using namespace std;

/* 배포 가능한 기능 개수 구하기

1. progresses의 size만큼 반복
1-1. progresses[i]가 100이 될때 까지 카운트 후 queue<int> work_days에 카운트값 입력
2. work_days가 빌때 까지 반복
2-1. work_days 첫번째 값이 그 다음값보다 작을 때까지 카운트 후, 카운트 리턴
*/


//진도 100%시 서비스 반영가능
//progresses: 작업진도 vector
//speeds: 개발속도/day
//answer: 배포마다 몇 개의 기능이 배포되는지
vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> days;

    // 각 작업이 완료되기까지의 남은 일수를 계산하여 큐에 저장
    for (int i = 0; i < progresses.size(); i++) {
        int remaining_work = 100 - progresses[i];
        int days_needed = (remaining_work + speeds[i] - 1) / speeds[i];  // 올림 계산
        days.push(days_needed);
    }

    // 배포 작업
    while (!days.empty()) {
        int current_day = days.front();
        days.pop();
        int count = 1;

        while (!days.empty() && days.front() <= current_day) {
            count++;
            days.pop();
        }

        answer.push_back(count);
    }

    return answer;
}
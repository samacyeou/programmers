#include <string>
#include <vector>
#include <numeric>
#include <queue>
#include <iostream>

using namespace std;
//한 번의 pop과 한 번의 insert를 합쳐서 작업을 1회
//어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1을 return
//queue1의 길이 = queue2의 길이

int solution(vector<int> queue1, vector<int> queue2) {
    int answer = 0;
    long sum1 = accumulate(queue1.begin(), queue1.end(), 0);
    long sum2 = accumulate(queue2.begin(), queue2.end(), 0);
    long goal = (sum1 + sum2) / 2;
    queue<int> q1;
    queue<int> q2;
    for(int i = 0; i < queue1.size(); ++i)
    {
        q1.push(queue1[i]);
        q2.push(queue2[i]);
        if((sum1+sum2) % 2 == 1) return -1;
        // if(queue1[i] > goal || queue2[i] > goal) return -1;
    }


    while(true)
    {
        if(sum1 == goal) return answer;

        else if(sum1 > goal)
        {
            int temp = q1.front();
            q1.pop();
            q2.push(temp);
            sum1 -= temp;
        }
        else if(sum1 < goal)
        {
            int temp = q2.front();
            q2.pop();
            q1.push(temp);
            sum1 += temp;
        }
        answer++;

        if(answer > queue1.size() * 3) return -1;
    }
}
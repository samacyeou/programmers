#include <string>
#include <vector>

using namespace std;

int solution(int n, int w, int num) {
    int answer = 0; // 타겟박스값 0으로 값 초기화
int column = 0; // 높이값 0으로 값 초기화

int h = (n + w - 1) / w;  // * 높이설정 -> 인트값이라 정수부분만 표시됨* -> 왜 w-1을 우겨넣어 높이 식을 만든건지??

vector<vector<int>> v(h, vector<int>(w, -1)); // 2차원 벡터 설정 -> { {h, vector<int>(w, -1)} {h, vector<int>(w, -1)} } 이런 식으로

int boxNumber =1; // 갱신되는 박스값 초기화

for(int r = 0; r <h; r++){ // 
    if(r % 2 == 0){ // 지그재그로 쌓기 위해서
        for(int c = 0; c < w && boxNumber <= n; c++){
            if(boxNumber == num){
                column = c;
            }
            v[r][c] = boxNumber++;
        }
    }else{
        for(int c = w-1; c>=0 && boxNumber <= n; c--){
            if(boxNumber == num){
                column = c;
            }
            v[r][c] = boxNumber++;
        }
    }
}

for(int r = 0; r<h; r++){
    if(v[r][column] < num) continue;
    else answer++;
}

return answer;
}

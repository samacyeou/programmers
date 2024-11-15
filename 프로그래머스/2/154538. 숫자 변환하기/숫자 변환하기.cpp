#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <deque>
#include <map>
#include <queue>
#include <stack>
#include <cmath>
#include <string>

using namespace std;

int arr[3'000'005];

int solution(int x, int y, int n) {

    fill(arr, arr + 3000005, 99999999);

    arr[x] = 0;

    for (int i = x; i <= y; i++) {
        if(arr[i] != 999999999) {
            arr[i + n] = min(arr[i] + 1, arr[i + n]);
            arr[i * 2] = min(arr[i] + 1, arr[i * 2]);
            arr[i * 3] = min(arr[i] + 1, arr[i * 3]);
        }
    }

    if (arr[y] == 99999999)
        return -1;

    return arr[y];
}
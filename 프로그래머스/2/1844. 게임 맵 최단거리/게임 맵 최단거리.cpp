#include <vector>
#include <queue>
using namespace std;

struct Position {
    int x, y, steps;
};

struct compare {
    bool operator()(Position a, Position b) {
        return a.steps > b.steps;
    }
};

int solution(vector<vector<int>> maps) {
    int answer = -1;
    int steps, x, y;
    int row = maps.size(), col = maps[0].size();
    priority_queue<Position, vector<Position>, compare> pq;

    pq.push({0, 0, 1});
    while(!pq.empty()) {
        steps = pq.top().steps;
        x = pq.top().x;
        y = pq.top().y;

        pq.pop();
        maps[x][y] = 0;
        steps++;
        if(x - 1 >= 0 && maps[x - 1][y]) {
            pq.push({x-1, y, steps});
            maps[x-1][y] = 0;
        }
        if(x + 1 < row && maps[x + 1][y]) {
            if(x + 1 == row - 1 && y == col - 1)
                return steps;
            maps[x+1][y] = 0;
            pq.push({x+1, y, steps});
        }
        if(y - 1 >= 0 && maps[x][y - 1]) {
            maps[x][y-1] = 0;
            pq.push({x, y-1, steps});
        }
        if(y + 1 < col && maps[x][y + 1]) {
            if(x == row - 1 && y + 1 == col - 1)
                return steps;
            maps[x][y+1] = 0;
            pq.push({x, y+1, steps});
        }
    }

    return answer;
}
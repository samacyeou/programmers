#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int DoQuery(vector<vector<int>> &matrix, const vector<int> &query)
{
    queue<pair<int, int>> q;
    for(int i = query[1]; i <= query[3]; ++i)
    {
        q.push({query[0], i});
    }

    for(int i = query[0] + 1; i <= query[2]; ++i)
    {
        q.push({i, query[3]});
    }

    for(int i = query[3] - 1; i >= query[1]; --i)
    {
        q.push({query[2], i});
    }

    for(int i = query[2] - 1; i >= query[0]; --i)
    {
        q.push({i, query[1]});
    }

    pair<int, int> front = q.front();
    int memory = matrix[front.first][front.second];
    int min = memory;
    int num;
    while(!q.empty())
    {
        q.pop();
        if(q.empty()) break;
        front = q.front();
        num = matrix[front.first][front.second];
        if(num == 0) break;
        if(num < min) min = num;
        matrix[front.first][front.second] = memory;
        memory = num;
    }
    return min;
}

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    vector<vector<int>> matrix(rows + 1, vector<int>(columns + 1));
    for(int i = 1; i <= rows; ++i)
    {
        for(int j = 1; j <= columns; ++j)
            matrix[i][j] = ((i - 1) * columns + j);
    }
    for(const auto query : queries)
    {
        answer.emplace_back(DoQuery(matrix, query));
    }
    return answer;
}
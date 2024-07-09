#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    int x, y, num;
    x = -1; y = -1;
    for(int i = 0; i < park.size(); i++){
        for(int j = 0; j < park[i].size(); j++){
            if(park[i][j] == 'S'){
                x = i; y = j;
                break;
            }
        }
        if(x != -1) break;
    }
    
    int temp = 0;
    for(int i = 0; i < routes.size(); i++){
        temp = routes[i][2] - '0';
        if(routes[i][0] == 'E'){
            if(y + temp > park[0].size()-1) continue;
            else{
                num = y;
                for(int j = 0; j < temp; j++){
                    y++;
                    if(park[x][y] == 'X'){
                        y = num;
                        break;
                    }
                }
            }
        }
        else if(routes[i][0] == 'W'){
            if(y - temp < 0) continue;
            else{
                num = y;
                for(int j = 0; j < temp; j++){
                    y--;
                    if(park[x][y] == 'X'){
                        y = num;
                        break;
                    }
                }
            }
        }
        else if(routes[i][0] == 'S'){
            if(x + temp > park.size()-1) continue;
            else{
                num = x;
                for(int j = 0; j < temp; j++){
                    x++;
                    if(park[x][y] == 'X'){
                        x = num;
                        break;
                    }
                }
            }
        }
        else if(routes[i][0] == 'N'){
            if(x - temp < 0) continue;
            else{
                num = x;
                for(int j = 0; j < temp; j++){
                    x--;
                    if(park[x][y] == 'X'){
                        x = num;
                        break;
                    }
                }
            }
        }
    }
    answer.push_back(x);
    answer.push_back(y);
    return answer;
}
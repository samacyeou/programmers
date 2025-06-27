#include <string>
#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int s, int e) {
    string answer = "";
    char temp;
    int j = 0;
    for (int i = s; i < e - j; i++)
    {
        temp = my_string[i];
        my_string[i] = my_string[e - j];
        my_string[e - j] = temp;
        j++;}
    answer = my_string;
    
    return answer;
}
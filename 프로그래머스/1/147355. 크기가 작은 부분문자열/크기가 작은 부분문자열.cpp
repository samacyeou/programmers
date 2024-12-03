#include <string>
#include <vector>
 #include <cstring>
using namespace std;


int solution(string t, string p)
{

    int answer = 0;
     long long str_size = p.size();

    string str;

    for ( long long i = 0; i <= t.size() - str_size; i++)
    {
        for( long long j = 0; j < str_size; j++)
        {

            if (t[i + j] == NULL)
            {

            }
            else
            {
                str += t[i + j];
            }   
        }

        if (str.size() == str_size)
        {
            if ((str) <= (p))
            {
                answer++;
            }

            str = "";
        }
    }
    return answer;
}
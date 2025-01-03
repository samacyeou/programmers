#include <vector>
#include <iostream>

using namespace std;

vector<int> Solution(vector<int> arr)
{
    if (arr.empty()) return arr;

    vector<int> result;
    result.push_back(arr[0]);
    for (int i = 1; i < arr.size(); i++)
    {
        if (arr[i] == arr[i - 1])
            continue;

        result.push_back(arr[i]);
    }
    return result;
}
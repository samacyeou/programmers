using System;
using System.Collections.Generic;

public class Solution
{
int _H = 0;
int _W = 0;

public int[] solution(string[] park, string[] routes)
{
    int[] answer = new int[] { };

    int[] location = new int[2];                    //  현재 위치
    List<string[]> route = new List<string[]>();    // 이동할 경로

    _H = park.Length - 1;                           // 세로 길이
    _W = park[0].Length - 1;                        // 가로 길이

    // 이동할 칸 수 세팅
    for (int i = 0; i < routes.Length; i++)
    {
        route.Add(new string[] { routes[i].Split(' ')[0], routes[i].Split(' ')[1] });
    }

    // 시작 위치 찾기
    for(int i = 0; i < park.Length; i++)
    {
        if (park[i].IndexOf('S') >= 0)
        {
            location[0] = i;
            location[1] = park[i].IndexOf('S');
            break;
        }
    }

    //  이동
    for(int i = 0; i < route.Count; i++)
    {
        location = Walk(park, location, route[i][0], int.Parse(route[i][1]));
    }

    return location;
}

public int[] Walk(string[] _Park, int[] _Location, string op, int n)
    {
        if (op.ToUpper() == "W")
        {
            if (_Location[1] - n < 0)
            {
                return _Location;
            }

            for (int i = 1; i <= n; i++)
            {
                if (_Park[_Location[0]][_Location[1] - i] == 'X')
                {
                    return _Location;
                }
            }

            _Location[1] = _Location[1] - n;

        }

        else if (op.ToUpper() == "N")
        {
            if (_Location[0] - n < 0)
            {
                return _Location;
            }

            for (int i = 1; i <= n; i++)
            {
                if (_Park[_Location[0] - i][_Location[1]] == 'X')
                {
                    return _Location;
                }
            }

            _Location[0] = _Location[0] - n;

        }
        else if (op.ToUpper() == "E")
        {
            if (_Location[1] + n >  _W)
            {
                return _Location;
            }

            for (int i = 1; i <= n; i++)
            {
                if (_Park[_Location[0]][_Location[1] + i] == 'X')
                {
                    return _Location;
                }
            }
            _Location[1] = _Location[1] + n;

        }
        else if (op.ToUpper() == "S")
        {
            if (_Location[0] + n > _H)
            {
                return _Location;
            }

            for (int i = 1; i <= n; i++)
            {
                if (_Park[_Location[0] + i][_Location[1]] == 'X')
                {
                    return _Location;
                }
            }
            _Location[0] = _Location[0] + n;

        }

        return _Location;
    }
}
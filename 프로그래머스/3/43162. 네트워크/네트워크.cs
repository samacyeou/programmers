using System;
using System.Collections.Generic;
public class Solution {
    private Queue<int> _searchIndex;
    //10개의 비트를 나누어 계산
    //15번 노드에 대한 검색이 완료 되면 _searched[1] |= (1<<5)
    private bool[] _searched;
    int range;

    public int solution(int n, int[,] computers) {
        int answer = 0;
        range = n;
        _searchIndex = new Queue<int>();
        _searched = new bool[n];

        for(int i =0;i<n;i++)
        {
            if(!_searched[i]) answer++;
            Search(i,computers);
        }
        return answer;
    }

    private void Search(int index,int[,] computers)
    {
        //검색 기록을 남김
        _searched[index] = true;
        for(int i=0;i<range;i++)
        {
            if( computers[index,i] == 1)
            {
                //자기 자신은 스킵
                if(index == i) continue;
                //검색이 된 기록이 없는 것만 검색 목록에 추가
                if(!_searched[i]) 
                {
                    // Console.Write(i+" ");
                    _searchIndex.Enqueue(i);
                }

            }
        }
        // Console.WriteLine();
        //검색 항목이 남아 있으면 계속해서 검색 진행
        // foreach(int i in _searchIndex) {
        //     Console.Write(i+" ");
        // }
        // Console.WriteLine();
        if(_searchIndex.Count >0)
        {
            var temp = _searchIndex.Dequeue();
            Search(temp,computers);
        }

    }
}
using System;
using System.Collections.Generic;
public class Solution {
    private Queue<int> _searchIndex;
    //10개의 비트를 나누어 계산
    //15번 노드에 대한 검색이 완료 되면 _searched[1] |= (1<<5)
    private List<short> _searched;
    int range;
    bool[] check;

    public int solution(int n, int[,] computers) {
        int answer = 0;
        range = n;
        _searchIndex = new Queue<int>();
        _searched = new List<short>(new short[n/10 +1]);
        check = new bool[n/10+1];

        for(int i =0;i<n;i++)
        {
            if((_searched[i/10] & (1<<(i%10)))==0)
            {
                //첫 검색이 검색된 적 없는 인덱스면 ++
                answer++;

            }
            Search(i,computers);    
        }
        return answer;
    }

    private bool Search(int index,int[,] computers)
    {
        //혹시 이미 검색된 인덱스가 들어오면 바로 종료
        //검색 기록을 남김
        _searched[index/10] |= (short)(1<<(index%10));
        for(int i=1;i<range;i++)
        {
            if( computers[index,i] == 1)
            {
                //자기 자신은 스킵
                if(index == i) continue;
                //검색이 된 기록이 없는 것만 검색 목록에 추가
                if((_searched[i/10] & (1<<(i%10))) == 0) 
                {
                    _searchIndex.Enqueue(i);
                }

            }
        }
        //검색 항목이 남아 있으면 계속해서 검색 진행
        if(_searchIndex.Count >0)
        {
            var temp = _searchIndex.Dequeue();
            Search(temp,computers);
        }
        return true;

    }
}
#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<vector<int>> edges) { 

    // int max = max_element(edges.begin(), edges.end()) - edges.begin();
    // int temp = edges[max][0] > edges[max][1] ? 0 : 1;
    int max = 0;
    for(int i=0;i<edges.size();i++){
        if(edges[i][0] > max) max = edges[i][0];
        if(edges[i][1] > max) max = edges[i][1];
    }
    
    vector<int> count(max+1,0);
    vector<int> take(max+1,0);
    vector<int> out(max+1,0);

   for(int i=0;i<edges.size();i++){
        count[edges[i][1]]++;
        count[edges[i][0]]--;
       out[edges[i][0]]++;
        take[edges[i][1]]++;  
    }

    // int add = min_element(count.begin(), count.end()) - count.begin();
    int add = 0;
    for(int i = 1; i < count.size(); i++) {
        if(count[add] > count[i]) add = i;
    }

    int k=0;
    for(int i=0;i<edges.size();i++){
        if(edges[i][0]==add){
            k++;
        }
    }

    int stick=0; 
    int eight=0; 
    int donut=0; 

    //cout<<k;

    for(int i=1;i<count.size();i++){
        if(count[i] == 1 && take[i] == 1){
            stick++;
            // cout<<i<<'\n';
        }
    }
     /*for(int i=0;i<count.size();i++){
       cout<<count[i]<<'\t'<<take[i]<<'\n';
    }*/

    for(int i=0;i<count.size();i++){
        if(count[i]>0){
            count[i]--;
            take[i]--;
        }
    }

    for(int i=0;i<count.size();i++){
        if(count[i]==0&&take[i]==2){
            eight++;
        } 
        else if(count[i]==1&&take[i]==1){
            stick++;
        }
    }
    donut=k-eight-stick;

     /*for(int i=0;i<count.size();i++){
       cout<<count[i]<<'\t'<<take[i]<<'\n';
    }*/

    vector<int> answer;
    answer={add,donut,stick,eight};
    return answer;
}
import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int n=park.length,m=park[0].length,maxLen=0;
        int[][] dp=new int[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!park[i][j].equals("-1")) continue;
                
                dp[i][j]=1;
                if(i>0 && j>0) {
                    // 왼쪽 아래쪽 작은 정사각형
                    int side=Math.min(dp[i-1][j],dp[i][j-1]);
                    
                    if(park[i-side][j-side].equals("-1")) dp[i][j]=side+1;
                    else dp[i][j] = side;
                }
                maxLen=Math.max(maxLen,dp[i][j]);
            }
        }
        // find mats
        Arrays.sort(mats);
        for(int i=mats.length-1;i>=0;i--)
            if(maxLen>=mats[i]) return mats[i];
        return -1;
    }
}
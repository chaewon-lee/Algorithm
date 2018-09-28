/*
* 30min
* 100%
* is this real dynamic programming?
*/

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map= new int[n+1][m+1];
        map[1][1] = 1; //starting point
        map= puddle(map, puddles);
        return dp(map, m, n);
    }
    
    public int[][] puddle(int[][] map, int[][] puddles){
        for(int i=0; i<puddles.length;i++)
            map[puddles[i][1]][puddles[i][0]]= -1;
        return map;
    }
    
    public int dp(int[][] map, int m, int n){
        for (int j=1; j<=n; j++){
            for(int k=1; k<=m;k++){
                if (j == 1 && k == 1)       //(1,1)은 1로 만들어두고, 0이 되지 않도록
                    continue;
                if (map[j][k] == -1){ //웅덩이는 0으로 만들어 다음 덧셈 때 영향끼치지 않게
                     map[j][k] = 0;
                    continue;
                }         
            map[j][k] = (map[j][k-1] + map[j-1][k]) %1000000007;
                //[a,b] = [a-1,b] + [a,b-1] 공식
            }
        }
        return map[n][m]; // result
    }
}
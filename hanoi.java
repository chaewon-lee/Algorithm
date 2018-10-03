/*
 * 30 min
 * 100%
 * hard points: understanding recurvie hanoi method, change 2d arraylist into 2d array 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    List<int[]> result= new ArrayList<int[]>();
    public int[][] solution(int n) {
        Hanoi(n, 1, 2, 3);
        int[][] answer= new int[result.size()][];
        result.toArray(answer);
        return answer;
  }
    
    public void Hanoi(int n, int from, int by, int to){
        if(n == 1){
            Move(from,to,n);
        } else{           
            Hanoi(n-1,from,to,by);
            Move(from,to,n);
            Hanoi(n-1,by,from,to);           
        }       
    }
   
    public void Move(int from, int to, int n){
        result.add(new int[]{from, to});
    }
}
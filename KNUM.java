/*
* 20 min
* 100 percent
*/

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i=0; i<commands.length;i++){
            answer[i]= kNum(array, commands[i]);
            System.out.println(answer[i]);}
        return answer;
    }
    
    public int kNum(int[] array, int[] command){
        int[] target= Arrays.copyOfRange(array, command[0]-1, command[1]);
        Arrays.sort(target);
        return target[command[2]-1];
    }
    
}
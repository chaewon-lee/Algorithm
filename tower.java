/*
* 1h 30m
* 100%
* pop() func in if statement -> if를 충족하지 않더라도 pop()은 실행된 것
*/

import java.util.Stack;

class Solution {
    public int[] solution(int[] heights) {
        Stack<Integer> original = new Stack<Integer>();
        for (int i = 0; i <heights.length; i++)
            original.push(heights[i]);
        int[] answer = receiver(original, heights);
        return answer;
    }
    
    public int[] receiver (Stack original, int[] towers){
        int[] answer= new int[towers.length];
        for (int i=0; i<towers.length;i++){
            Stack<Integer> copy = (Stack<Integer>)original.clone(); 
            original.pop(); //pop out the last element
            int target= copy.pop(); //target, rightmost element
            answer[towers.length-i-1]= 0;
            int size= copy.size();
            for (int j=0; j<size;j++){
                if (target<copy.pop()){
                    answer[towers.length-i-1]= copy.size()+1; //index
                    break;
                }
            }
        }
        return answer;
    }
}
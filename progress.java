/*
* Queue Operation
* peek(): pop but not remove
* poll(): pop and remove
* remove(): pop and remove with exception when empty
*/
/*
* 2h
* 1case fail
* pop하면 length가 달라져서 for문의 parameter값이 변경됨 (size()로 설정 시) --> 고정값을 parameter로 사용해야 함
*/

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        return develop(progresses, speeds);
    }
    
    public int[] develop(int[] progress, int[] speed){
         Queue<Integer> queue= new LinkedList<Integer>(); // how many days needed?
         for (int i=0; i<progress.length; i++){
             int element= (100-progress[i])/speed[i];
             if((100-progress[i])%speed[i]!=0)
                 element++;
             queue.add(element);
             System.out.println("e:"+element);
         } // store elements in queue
        
        Queue<Integer> progPerDay= new LinkedList<Integer>(); 
        int num=1; //num of progress in a day
        int target= queue.poll();
        int size= queue.size();
        for(int i=1; i<=size;i++){
            if (target<queue.peek()){
                progPerDay.add(num);
                target= queue.poll();
                num=1;
            }
            else if (i==size){
                if(target<queue.peek()){
                    progPerDay.add(num);
                    progPerDay.add(1);
                }
                else{
                    num++;
                    progPerDay.add(num);
                }
            }
            else{
                num++;
                queue.remove();
            }
        }
        //returing result
        int[] result= new int[progPerDay.size()];
        for (int i=0; i<result.length;i++)
            result[i]= progPerDay.remove();
        return result;
    }
}
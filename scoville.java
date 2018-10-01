/*
 * 30min
 * 100%
 * priority queue as heap
 * original order: min heap
 * reverse order: max heap
 */


import java.util.PriorityQueue;

class Solution {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    public int solution(int[] scoville, int K) {
        for(int i=0; i<scoville.length;i++)
            minHeap.add(scoville[i]);
        int count=0;
        for(int i=0; i<scoville.length;i++){
            if(minHeap.size()==1 || minHeap.peek()>=K)
                break;
            else{
                count++;
                int target= minHeap.poll();
                int next= minHeap.poll();
                target += next *2 ;
                minHeap.add(target);
            }
        }
        if (minHeap.peek()<K)
            count =-1;
        return count;
    }
}
/**
 * 1.5h
 * 100%
 * absolute bfs
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    Queue<Integer> queue= new LinkedList<Integer>();
    int network = 0;
    public int solution(int n, int[][] computers) {
        boolean[] visited= new boolean[n]; //init false
        int[][] graph= new int[n][n];
        for(int i=0; i<n;i++){
            graph[i][i]=1;
            for(int j=0; j<n;j++){
                if(computers[i][j]==1)
                    graph[i][j]=1;
            }
        }
        bfs(graph, visited, 0);
        for(int i=0; i<n; i++){
            if(!visited[i])
                bfs(graph, visited, i);
        }
        return network;
    }
    
    public void bfs(int[][] graph, boolean[] visited, int s){
        visited[s] = true;
        queue.add(s);
        network++;
        // 큐(Queue)가 빌 때까지 반복
        while (queue.size() != 0) {
          s = queue.poll();
          for(int i=0; i<visited.length;i++){
              if(graph[s][i]==1){
                  if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    }
                }
            }
        }
    }
}
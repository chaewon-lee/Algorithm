import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class virus{
    public static void main(String[] args){
       Scanner sc= new Scanner(System.in);
       int comNum= sc.nextInt();
       int iterateNum= sc.nextInt();
       List<Integer> infect= new ArrayList<Integer>();
       infect.add(1);
       int[][] graph= new int[comNum+1][comNum+1]; //not using 0 index

       for (int i=0;i<iterateNum;i++){
           int a= sc.nextInt();
           int b= sc.nextInt();
           graph[a][b]=1;
           graph[b][a]=1;
       }

       for(int i=1; i<=comNum;i++){
           for(int j=1; j<=comNum;j++){
            if(infect.size()<i)
                 break;
            else{
                if(graph[infect.get(i-1)][j]==1){
                	//System.out.println(infect.get(i-1)+" "+ j);
                		if(!infect.contains(j))
                			 infect.add(j);
                		}
                }
           }
       }
       System.out.println(infect.size()-1);
       sc.close();
    }
}
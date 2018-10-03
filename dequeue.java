import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main{
    static LinkedList<Integer> dequeue= new LinkedList<Integer>();
    static StringTokenizer st;
    
    public static void readLine(String s, int target){
            switch(s){
                case "push_front":
                    push_front(target);
                case "push_back":
                    push_back(target);
                case "pop_front":
                    pop_front();
                case "pop_back":
                    pop_back();
                case "size":
                    size();
                case "back":
                    back();
                case "front":
                    front();
                case "empty":
                    empty();
        }
    }
    
    public static void push_front(int item){
        dequeue.addFirst(item); //in the front
    }
    
    public static void push_back(int item){
        dequeue.addLast(item); //in the back
    }
    
    public static void pop_front(){
        System.out.println(dequeue.pollFirst());
    }
    
    public static void pop_back(){
        System.out.println(dequeue.pollLast());
    }
    
    public static void size(){
        System.out.println(dequeue.size());
    }
    
    public static void empty(){
        if (dequeue.size()>0)
            System.out.println(0);
        else
            System.out.println(1);
    }
    
    public static void front(){
        if(dequeue.size()<1)
            System.out.println(-1);
        else
            System.out.println(dequeue.peekFirst());
    }
    
    public static void back(){
        if(dequeue.size()<1)
            System.out.println(-1);
        else
        System.out.println(dequeue.peekLast());
    }
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.valueOf(sc.nextLine());
        
        for (int i=0; i<size; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int value=0;
             if(st.hasMoreTokens()) {
                value = Integer.parseInt(st.nextToken());
            }
            readLine(command, value);
        }
    }
}
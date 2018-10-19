import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class permutation{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        List<Integer> answer= new ArrayList<Integer>();
        int N= sc.nextInt();
        boolean[] picked= new boolean[N];
        sc.close();

        recur(answer, picked, N);
    }

    public static void recur(List<Integer> picked, boolean[] isPick, int n){
        if( picked.size() == n ){
            String answer= "";
            for(int i=0; i<picked.size();i++)
                answer+=Integer.toString(picked.get(i))+" ";
            System.out.println(answer);
            return ;
        }
         
        for(int next = 0; next < n; next++){
            if(isPick[next])
                continue;
             
            picked.add(next+1);
            isPick[next] = true;
             
            recur( picked, isPick, n);
             
            picked.remove(picked.size()-1);
            isPick[next] = false;
        }
    }
}
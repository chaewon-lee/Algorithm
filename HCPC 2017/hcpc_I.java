package chaewon;

import java.util.Scanner;

class hcpc_I{
    static int[][] coms;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        coms = new int[N+1][N+1]; coms[1][1]=2;
        int[] first_= new int[N+1]; int[] second_= new int[N+1];
        first_[0]=0; second_[0]=0;
        for (int i=1; i<=N;i++)
            first_[i]= sc.nextInt();
        for (int i=1; i<=N;i++)
            second_[i]= sc.nextInt();

        for(int i=1; i<=N;i++){
            for(int j=1; j<=N;j++){
                coms[i][j]=dp(i,j,first_,second_);
            }
        }
        sc.close();
        max();
    }
/*
3
1 7 5
2 4 6
*/
    public static int dp(int i, int j, int[] first_, int[] second_){
        int first=2; int second=2;
        for(int k=1; k<i; k++){
            if(first_[k]<first_[i])
                if(first<coms[k][j]+1)
                    first= coms[k][j]+1;
            }
        for(int k=1; k<j; k++){
            if(second_[k]<second_[j])
            if(second<coms[i][k]+1)
                second= coms[i][k]+1;
        }
        System.out.println(i+"i " + first);
        System.out.println(j+"j "+second);
        if(first>second)
            return first;
        else
            return second;
    }

    public static void max(){
        int max=0;
        for(int i=0; i<coms.length; i++){
           for(int j=0; j<coms[0].length;j++){
                if(max<coms[i][j])
                    max=coms[i][j];
           }
       } 
       System.out.println(max);
    }
}
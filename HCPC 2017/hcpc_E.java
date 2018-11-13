package chaewon;

import java.util.Scanner;

class hcpc_E{
    public static void main(String[] args){
        int[] count= new int[8]; //0-9, 6==9
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        for(int j=0; j<=N; j++){
            String str= sc.nextLine();
            System.out.println(j+" "+ str);
            String[] splited = str.split("\\s+");
            for(int k=0; k<splited.length;k++){
                String cand= splited[k];
                if (isNumeric(cand)){
                    for(int i=0; i<cand.length();i++){
                        char c= cand.charAt(i);
                        int card= Character.getNumericValue(c);
                        if(card==6 || card==9)
                            count[6]++;
                        else
                            count[card]++;
                    }
                }
            }
        }
        count[6]= (count[6]+1)/2;
        int max=-1;
        for(int i=0; i<count.length; i++)
            max= max(max, count[i]);
        System.out.println(max);
        sc.close();
    }

    public static boolean isNumeric(String s)  {
        boolean flag= false;
        try {
            int d = Integer.parseInt(s);
            if(Integer.class.isInstance(d))
                flag= true;
        }  
        catch(NumberFormatException e){  
            flag= false;  
        }
        return flag;
    }

    public static int max(int a, int b){
        if(a>b)
            return a;
        else 
            return b;
    }
}
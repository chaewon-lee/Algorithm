/**
 * 4h
 */

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class chicken{
    static List<int[]> home= new ArrayList<int[]>(); //homes location
    static List<int[]> chicken= new ArrayList<int[]>(); //chickens location
    static List<int[]> comb= new ArrayList<int[]>(); //combination sets
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int size= sc.nextInt();
        int left= sc.nextInt(); //total left chicken franchise num

        int[][] city= new int[size+1][size+1]; //index start from 1
        for(int i=1; i<city.length;i++){
            for(int j=1; j<city.length;j++)
                city[i][j]= sc.nextInt();
        } //initialize adjacent matrix
        sc.close();
        for(int i=1; i<city.length;i++){
            for(int j=1; j<city.length;j++){
                if(city[i][j]==1)
                    home.add(new int[]{i,j});
                else if(city[i][j]==2)
                    chicken.add(new int[]{i,j});
            }
        }// add chicken, home locations
        
        int[] arr=new int[left];
        combination(arr, 0, chicken.size(), left, 0); //make chickens combination
        
        int[] total= new int[comb.size()]; // result for each combination
        for (int j=0; j<comb.size();j++){
        	int[] iteration= comb.get(j); // current combination
            for(int i=0; i<iteration.length;i++) {
       		 System.out.println("comb: " +iteration[i]);
       	 }
            int[] distance= new int[home.size()]; // distance for each chicken step
            for (int i=0; i<home.size(); i++){
                int[] location= home.get(i);
                int min=100;
                for (int k=0; k<iteration.length;k++){
                	System.out.println("chicken idx: "+ iteration[k]);
                    int[] dest= chicken.get(iteration[k]);
                    System.out.println("Location0: "+ location[0]);
                    System.out.println("target0: "+ dest[0]);
                    System.out.println("Location1: "+ location[1]);
                    System.out.println("target1: "+ dest[1]);
                    int target= Math.abs(location[0]-dest[0])+Math.abs(location[1]-dest[1]);
                    System.out.println("result: "+ target);
                    min= findMin(min, target);
                }
                System.out.println("total min for"+ i+"th home: "+min);
                distance[i]= min;
            }
            total[j]= Arrays.stream(distance).sum();
            System.out.println(j+" th chicken distance is "+ total[j]);
        }
        Arrays.sort(total);
        System.out.println(total[0]);
    }

    public static void combination(int[] arr, int index, int n, int r, int target) {
        // this index is index of list chicken
        if (r == 0) {
        	int[] result= new int[arr.length];
        	for (int i=0; i<result.length;i++)
        		result[i]= arr[i];
        	comb.add(result);
        }
        else if (target == n) 
            return;
        else {
            arr[index] = target; 
            combination(arr, index + 1, n, r - 1, target + 1); // current recursive
            combination(arr, index, n, r, target + 1);  //next recursive
        }
     }
    
    public static int findMin(int origin, int target) {
    	if(origin>target)
    		return target;
    	else
    		return origin;
    }
}
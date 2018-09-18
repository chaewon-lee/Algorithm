import java.util.Arrays;
import java.util.List;

/*
* unfinished
*/

class Solution {
    public int[] solution(int N, int[] stages) {
        int max_stage=stages[0];
        for (int i=0; i<stages.length-1;i++){
            if (stages[i+1]>=max_stage)
                max_stage= stages[i+1];
        }
        
        double[] result= new double[N+3]; //0 and N+1, 답제출하는 array에서 1부터 n까지만 읽기
        Arrays.sort(stages);
        for (int i=0; i<stages.length;i++){
            int target= stages[i];
            double count=0;
            double total=0;
            for (int j=0; j<stages.length; j++){
                if (target<=stages[j]){
                    total++;
                    if(target==stages[j]){
                        count++;
                    }
                }
            }
            System.out.println("c"+count);
            System.out.println("T"+total);
            result[target]= count/total;
            System.out.println(result[i]);
        }
        
        if (max_stage>N)
            max_stage= max_stage-1; //length of answer array
        
        int[] answer = new int[max_stage];
        for (int i=0;i<answer.length;i++){
            double val= getMinValue(result);
            System.out.println(val); //여러개일 수 있음
            //int idx= Arrays.asList(result).indexOf(val);
            //System.out.println(idx);
            //result[idx]= 2; //큰 수로 올려보림
        }
        
        return answer;
    }
    public static double getMinValue(double[] numbers){
      double minValue = numbers[0];
      for(int i=1;i<numbers.length;i++){
          if(numbers[i]<=1) //is this value already checked?{
            if(numbers[i] < minValue){
                minValue = numbers[i];
                //같은 값을 가지는 것들 처리?
            }
        }
    
      return minValue;
    }
}
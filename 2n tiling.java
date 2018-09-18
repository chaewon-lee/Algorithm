import java.util.HashMap; 
import java.util.Map;

/**
* 1시간 소요
* 80/100
* DP, fibonacci
* 피보나치 수열 efficiency 개선
* Integer 범위 초과 문제 (Runtime Error in Efficiency Test)
**/

class Solution {
    public int solution(int n) {
      int answer = getFibonacciOf(n);
      return answer;
    }
    
    private static Map<Integer, Integer> previousValuesHolder;
    static { //Memoization
        previousValuesHolder = new HashMap<Integer, Integer>();
        previousValuesHolder.put(Integer.valueOf(0), Integer.valueOf(0));
        previousValuesHolder.put(Integer.valueOf(1), Integer.valueOf(1));
        previousValuesHolder.put(Integer.valueOf(2), Integer.valueOf(2));
    }
    
    public static int getFibonacciOf(int n) {
        if (previousValuesHolder.containsKey(Integer.valueOf(n)))
                return previousValuesHolder.get(n);
        
        int newValue = getFibonacciOf(n-2) + getFibonacciOf(n-1);
        newValue= newValue % 1000000007;
        previousValuesHolder.put(Integer.valueOf(n),Integer.valueOf(newValue));
        return newValue;
        }
}
    
   /*public int fibo(int n) {
    if(n == 0)
        return 0;
    else if(n == 1)
      return 1;
    else if (n==2)
        return 2;
   else
      return fibo(n - 1) + fibo(n - 2);
    }*/
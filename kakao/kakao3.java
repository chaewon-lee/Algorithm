import java.lang.*;
/*
* test case pass
* real-test fail
*/

class Solution {
  public int solution(int cacheSize, String[] cities){
      String[] cache= new String[cacheSize];
      int miss=0; //counter
      int hit=0; //counter
      
      for(int i=0; i<cities.length;i++){
          cities[i]= cities[i].toLowerCase();// data preprocess
          //if cities[i] is in cache --> hit ++, put in first idx
          //else cities[i] is not in cache --> miss ++
            // if cache full --> delete last idx, put in first idx
            // else --> put in first idx
          if (checkVal(cache, cities[i])) { //check if cache contains the city
              hit++;
              cache= changeIdx(cache, cities[i], cache.length);
          }
          else{
              if(miss==0){
                  cache[0]= cities[i];
              }
              else if(cache.length==cacheSize){//cache full
                  miss++;
                  cache[cacheSize-1]= null;
                  cache= changeIdx(cache, cities[i], cacheSize);
              }
              else{
                cache= changeIdx(cache, cities[i], cacheSize);
              }
            miss++;
              }
          }
      
      
      int time= timeCal(miss, hit);
      return time;
  }
    
    public boolean checkVal(String[] arr, String targetValue) {
        for(String s: arr){
            if(s.equals(targetValue))
                return true;
        }
        return false;
    }
    public String[] changeIdx(String[] cache, String target, int size){
        //change idx
        System.out.println(cache.length);
        for (int i=0; i<cache.length;i++){
            String temp= cache[i];
            cache[i]= target;
            target= temp;
        }
        if (cache.length!=size){
            cache[cache.length]=target;
        }
        return cache;
    }
    public int timeCal(int miss, int hit){
        return (5*miss + hit);
    }
}
/*
* 2시간 소요
* 100/100
* all test pass
*/

class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
      String[] answer = new String[n];
      
      for (int i=0; i<n; i++){
           String array1= Integer.toBinaryString(arr2[i]);
           String array2= Integer.toBinaryString(arr1[i]);
           String result="";
          
          if (array1.length()!=array2.length()){
              int len;
              if (array1.length()>array2.length()){
                  len= array1.length();
                  int diff= array1.length() - array2.length();
                  for (int m=0; m<diff;m++){
                      array2= "0"+ array2;
                  }
              }
              else{
                  len= array2.length();
                  int diff= array2.length() - array1.length();
                  for (int m=0; m<diff;m++){
                      array1= "0"+ array1;
                  }
              }
              if (len<n){
                  int diff= n- len;
                  for (int m=0; m<diff; m++){
                      result+= " ";
                  }
              }
              for(int b=0; b<len;b++){
                if (array1.charAt(b)=='1'||array2.charAt(b)=='1'){
                    result+= "#";
              }
                else{
                    result+= " ";
              }
            }
          }
          else{
              if (array1.length()<n){
                  int diff= n- array1.length();
                  for (int m=0; m<diff; m++){
                      result+= " ";
                  }
              }
              for(int b=0; b<array1.length();b++){
                if(array1.charAt(b)=='1'|| array2.charAt(b)=='1'){
                    result+= "#";
              }
                else{
                    result+= " ";
              }
            }
          }
          System.out.println(result);
          answer[i]= result;
      }
      
      return answer;
  }
}
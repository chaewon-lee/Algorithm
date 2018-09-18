/*
* 1시간 반 소요
* test case pass
* inefficient
*/

class Solution {
    boolean contains(char c, char[] array) {
       for (char x : array) {
           if (x == c) {
               return true;
           }
       }
       return false;
   }
     public int solution(String dartResult) {
         char[] option= {'S', 'D', 'T', '*', '#'};
         int pointer= 0; // point to the index that will be checked
         int len= dartResult.length(); // how many characters are left?
         int[] score= {0,0,0}; // store score values
         int idx=0;
         
         while (len>=3){
             char a= dartResult.charAt(pointer); //first value
             char b= dartResult.charAt(pointer+1); //second value
             char c= dartResult.charAt(pointer+2); //third value
             
             if (!contains(c, option)){ // third value is number
                 pointer=pointer+2;
                 len-=2;
                 char[] charArr= {a,b};
                 System.out.println("2"+charArr);
                 score= calculateScore(option,charArr, score, idx);//a,b 계산
                 idx++;
                 
                 
             }
             else{ //third value is option
                 if (len==3){
                     pointer= pointer +3;
                     len-=3;
                     char[] charArr= {a,b,c};
                     System.out.println("3"+charArr);
                     score= calculateScore(option,charArr, score, idx);
                     idx++;
                 }
                 else{
                     char d= dartResult.charAt(pointer+3);
                     if(contains(d, option)){// fourth value is option?
                         pointer= pointer+4;
                         len-=4;
                         char[] charArr= {a,b,c,d};
                         System.out.println("4"+charArr);
                         score= calculateScore(option,charArr, score, idx);
                         idx++;
                     }
                     else{ //fourth value is number
                         pointer= pointer +3;
                         len-=3;
                         char[] charArr= {a,b,c};
                         System.out.println("3"+charArr);
                         score= calculateScore(option,charArr, score, idx);
                         idx++;
                     }
             }
           }
             System.out.println(score[0]);
             System.out.println(score[1]);
             System.out.println(score[2]);
         }
         if (len>0 && len<3){
             char a= dartResult.charAt(pointer);
             char b= dartResult.charAt(pointer+1);
             char[] charArr= {a,b};
             System.out.println("left"+charArr);
             score= calculateScore(option,charArr, score, idx);
             idx++;
         }
         
         System.out.println(score[0]);
         System.out.println(score[1]);
         System.out.println(score[2]);
         int answer = score[0]+score[1]+score[2];
         return answer; //total score
     }
       
     public int[] calculateScore(char[] option, char[] result, int[] prev, int idx){
         //if len==2 len==3 len==4
         int score=0;
         if (result.length==2){
             if (result[1]=='S'){
                 score+= Character.getNumericValue(result[0]);
             }
             else if (result[1]=='D'){
                 score+= Math.pow(Character.getNumericValue(result[0]), 2);
             }
             else if (result[1]=='T'){
                 score+= Math.pow(Character.getNumericValue(result[0]), 3);
             }
             prev[idx]= score;
         }
         else if (result.length==3){
             if (contains(result[1], option)){ // number is one digit
                 if (result[1]=='S'){
                 score+= Character.getNumericValue(result[0]);
                     if (result[2]=='*'){//star
                 prev[idx]= 2*score;
                 if (idx!=0)
                     prev[idx-1]*= 2;
             }
             else if (result[2]=='#'){ //아차
                 prev[idx]= score * -1;
             }
               }
                 else if (result[1]=='D'){
                 score+= Math.pow(Character.getNumericValue(result[0]), 2);
                     if (result[2]=='*'){//star
                 prev[idx]= 2*score;
                 if (idx!=0)
                     prev[idx-1]*= 2;
             }
             else if (result[2]=='#'){ //아차
                 prev[idx]= score * -1;
             }
               }
                 else if (result[1]=='T'){
                 score+= Math.pow(Character.getNumericValue(result[0]), 3);
                     if (result[2]=='*'){//star
                 prev[idx]= 2*score;
                 if (idx!=0)
                     prev[idx-1]*= 2;
             }
             else if (result[2]=='#'){ //아차
                 prev[idx]= score * -1;
             }
               }
           }
             else{ //number is two digit
                 if (result[2]=='S'){
                 score+= 10;
               }
                 else if (result[2]=='D'){
                 score+= Math.pow(10, 2);
               }
                 else if (result[2]=='T'){
                 score+= Math.pow(10, 3);
               }
           }
             prev[idx]= score;
         }
         else{ //len 4
             if (result[2]=='S'){
                 score+= 10;
                 if (result[3]=='*'){//star
                 prev[idx]= 2*score;
                 if (idx!=0)
                   prev[idx-1]*= 2;
             }
             else if (result[3]=='#'){ //아차
                 prev[idx]= score * -1;
             }
               }
                 else if (result[2]=='D'){
                 score+= Math.pow(10, 2);
                     if (result[3]=='*'){//star
                 prev[idx]= 2*score;
                 if (idx!=0)
                   prev[idx-1]*= 2;
             }
             else if (result[3]=='#'){ //아차
                 prev[idx]= score * -1;
             }
               }
                 else if (result[2]=='T'){
                 score+= Math.pow(10, 3);
                     if (result[3]=='*'){//star
                 prev[idx]= 2*score;
                 if (idx!=0)
                   prev[idx-1]*= 2;
             }
             else if (result[3]=='#'){ //아차
                 prev[idx]= score * -1;
             }
               }
         }
         
         return prev;
     }
   }
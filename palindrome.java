class Solution{
    /*
    * 1시간 소요
    * 70/100
    * for문을 두번 돌게 되어서 efficiency test 0점
    * substring을 앞에서 부터 char 하나씩 지워가면서 전부 비교
    */
        private static String longest="";
        
        public int solution(String s){
            for(int i=0; i<s.length(); i++)
                 palindrome(s.substring(i, s.length()));
            int answer = longest.length(); 
            return answer;
        }
        
        public static void palindrome(String s){
            for(int i=1;i<=s.length();i++){
                StringBuilder s1 = new StringBuilder(s.substring(0,i));
                StringBuilder s2 = new StringBuilder(s.substring(0,i));
                s2.reverse();
                if(s1.toString().equals(s2.toString())){
                    if(longest.length()<=s1.length())
                        longest = s1.toString();
                }
            }
        }
    }
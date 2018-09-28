/*
* 1h
* 100%
*/

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] student= new boolean[n+1];
        for(int i=1;i<student.length;i++)
            student[i]= true;
        
        int answer=0;
        for (int i=0; i<lost.length;i++){
            student[lost[i]]= false;
            for (int j=0; j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    reserve[j]=-1;
                    student[lost[i]]= true;
                    lost[i]= 100;
                }
            }
        } // 체육복을 2벌 가져온 학생의 체육복이 도난을 당했다면, 여벌의 체육복을 빌려줄 수 없습니다.
        
        student= lost(student, lost, reserve);
        for (int i=0; i<student.length;i++){
            if(student[i])
                answer++;
        }
        return answer;
    }
    
    public boolean[] lost(boolean[] student, int[] lost, int[] reserve){
        for(int i=0; i<lost.length;i++){
            for (int j=0; j<reserve.length;j++){
                if(reserve[j]==lost[i]-1 || reserve[j]==lost[i]+1) {
                    reserve[j]=-1;
                    student[lost[i]]=true;
                    break;
                    }
                }
            }
        return student;
    }
}
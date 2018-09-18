import java.util.Map;
import java.util.HashMap;
import java.util.Arrays; 
import java.util.ArrayList; 

/*
* test case pass
* efficiency test fail
*/

class Solution {
    Map <String, String> dict= new HashMap<String, String>(); //name_id dict
      
    public String[] solution(String[] record) {
        
        String[][]answer = new String[record.length][3];
        int arridx=0;
        
        for (int i=0; i<record.length;i++){
            String[] current= split(record[i]);
            if (current[0].trim().equals("Enter")){
                if (re_enter(current[0], current[1], current[2])){
                    answer[arridx][0]= current[2]+"님이 들어왔습니다.";
                    answer[arridx][1]= current[1];
                    answer[arridx][2]= current[0];
                    arridx++;
                    
                    for (int j=0;j<answer.length;j++){
                    if (answer[j][1]!=null && answer[j][1].equals(current[1])){
                        if(answer[j][2].equals("Enter"))
                            answer[j][0]= current[2]+"님이 들어왔습니다.";
                        else
                            answer[j][0]= current[2]+"님이 나갔습니다.";
                    }
                }
                }
                else{
                    enter(current[0], current[1], current[2]);
                    answer[arridx][0]= current[2]+"님이 들어왔습니다.";
                    answer[arridx][1]= current[1];
                    answer[arridx][2]= current[0];
                    arridx++;
                }
            }
            else if (current[0].trim().equals("Change")){
                change(current[0], current[1], current[2]);
                for (int j=0;j<answer.length;j++){
                    if (answer[j][1]!=null && answer[j][1].equals(current[1])){
                        if(answer[j][2].equals("Enter"))
                            answer[j][0]= current[2]+"님이 들어왔습니다.";
                        else
                            answer[j][0]= current[2]+"님이 나갔습니다.";
                    }
                }
                    answer= removeRow(answer);
                }
            else{
                answer[arridx][0]= dict.get(current[1])+"님이 나갔습니다.";
                answer[arridx][1]= current[1];
                answer[arridx][2]= current[0];
                arridx++;
            }
           
        }
        String[] result = new String[answer.length];
        for(int j=0;j<answer.length;j++){
            result[j]= answer[j][0];
            System.out.println(answer[j][0]);
        }
        
     return result;   
    }
    
    public String[] split(String command){
        String[] result= new String[3]; //action, Uid, Name
        result[0]= command.split(" ")[0].trim();
        if (result[0].equals("Leave"))
            result[1]= command.split(" ")[1].trim();
        else{
            result[1]= command.split(" ")[1].trim();
            result[2]= command.split(" ")[2].trim();
        }
        
        return result;
    }
    public boolean re_enter(String command, String uid, String name){
        if (dict.get(uid)==null)
            return false; //not re_enter
        else{
            dict.put(uid, name);
            return true; //re_enter
        }
    }
    public void enter(String command, String uid, String name){
        dict.put(uid, name);
    }
     public void change(String command, String uid, String name){
         dict.put(uid, name);
    }
    public String[][] removeRow(String[][] target)
    {
        String[][] dest = new String[target.length-1][target[0].length];  
        for(int r=0; r<dest.length; r++)
        {
            for(int c=0; c<target[0].length; c++)
            {
                    dest[r][c]=target[r][c];
            }         
        }
        return dest;
    }
}
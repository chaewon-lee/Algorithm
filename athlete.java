/*
* 1h
* 100 percent
*/

import java.util.HashMap; 
import java.util.Map;
import java.util.*;  //Hash table, linked list, arrayList

class Solution {
    String answer= "";
    public String solution(String[] participant, String[] completion) {
        Hashtable <String, ArrayList<Integer>> table = new Hashtable <String, ArrayList<Integer>>();

        for(String s : participant){
            if(table.containsKey(s)){
                ArrayList<Integer> list = table.get(s);
                int count= list.size();
                list.add(count+1);
                table.put(s, list);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(1);
                table.put(s, list);
            }
        }
        for(String s : completion){
            ArrayList<Integer> list = table.get(s);
            if (list.size()==1)
                table.remove(s);
            else{
                list.remove(list.size() - 1);
                table.put(s, list);
            }
        }
        Set<String> keys = table.keySet();
        for(String key: keys){
            if(table.get(key).get(0)==Integer.valueOf(1))
                answer = key;
        }
            return answer;
    }
}
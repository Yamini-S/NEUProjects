/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_invertedindex;

import java.io.IOException;
import java.util.HashMap;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author yamini
 */
public class Inverted_Reducer extends Reducer<Text, Text, Text, Text>{
    
    private Text result = new Text();
    
   /* public void reduce(Text key, Iterable<Text> values, Context context) 
            throws InterruptedException, IOException{
        
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(Text id:values){
            if(first){
                first = false;
            }
            else{
                sb.append("");
            }
            
            sb.append(id.toString());
        }
        
        result.set(sb.toString());
        context.write(key,result);
        
    }
    */
    
    public void reduce(Text key, Iterable<Text> values, Context context) 
            throws InterruptedException, IOException
    {
       HashMap m=new HashMap();
       int count=0;
       
       for(Text t:values){
           String str=t.toString();
 
           //Check if file name is present in the HashMap ,if File name is not present then add the Filename to the HashMap and increment the counter by one , This condition will be satisfied on first occurrence of that word
           if(m!=null &&m.get(str)!=null)
           {
               count=(int)m.get(str);
               m.put(str, ++count);
           }else{
               //Else part will execute if file name is already added then just increase the count for that file name which is stored as key in the hash map
               m.put(str, 1);
           }
        }
 
        // Emit word and [file1→count of the word1 in file1 , file2→count of the word1 in file2 ………] as output
        context.write(key, new Text(m.toString()));
 
    }
    
    
}



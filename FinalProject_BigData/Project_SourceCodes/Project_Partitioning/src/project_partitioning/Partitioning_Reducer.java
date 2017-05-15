/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_partitioning;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author yamini
 */
public class Partitioning_Reducer extends Reducer<Text,Text,Text,Text>{
    
    public void reduce(Text key,Iterable<Text> values, Context context) 
            throws IOException, InterruptedException
    {
        for(Text t: values)
        {
            context.write(key,t);
        }
        
    }
    
}

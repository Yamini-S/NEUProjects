/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_partitioning;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author yamini
 */
public class Partitioning_Mapper extends Mapper<Object,Text,Text,Text>{
    private Text outKey = new Text();
    
    public void map(Object key, Text value, Context context)
            throws IOException,InterruptedException
    
    {
        try{
        String[] rows = value.toString().split(",");
        outKey.set(rows[4]);
        context.write(outKey, new Text(value));
        }catch(Exception e){
            System.out.println("Exception e"+ e.getMessage());
        }
    }
    
    
}

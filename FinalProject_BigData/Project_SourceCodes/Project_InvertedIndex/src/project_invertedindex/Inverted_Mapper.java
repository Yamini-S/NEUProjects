/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_invertedindex;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

/**
 *
 * @author yamini
 */
public class Inverted_Mapper extends Mapper<Object, Text, Text, Text>{
    
    //private Text word = new Text();
    //private Text fileName = new Text();
    
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
        
        String fileName = ((FileSplit) context.getInputSplit()).getPath().getName();
        String[] line = value.toString().split(",");

        for(String s:line){
            context.write(new Text(s), new Text(fileName));
            //context.write(new Text(line[8]), new Text(strFileName));
        }
   } 

}

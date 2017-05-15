/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_distinctpattern;

import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author yamini
 */
public class Distinct_Mapper extends Mapper<Object, Text, Text, NullWritable>{
    
        @Override
        public void map(Object key, Text value, Context context) 
                throws IOException, InterruptedException
        {
           String[] tokens = value.toString().split(",");
           try{
               Text planId = new Text();
               Text state = new Text();
               state.set(tokens[10].substring(5, 7));
               planId.set((tokens[10]));
               Text planState = new Text();
               planState.set(state + "\t" + planId);
               context.write(planState, NullWritable.get());
               }catch(Exception e){
                   System.out.println(e);
                   }
        }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_meanstddev;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author yamini
 */
public class MedStd_Mapper extends Mapper<Object, Text, Text, DoubleWritable> {
    
    private Text plan = new Text();
    private DoubleWritable rate = new DoubleWritable();    
    
    public void map(Object key,Text value,Context context) 
            //throws IOException, InterruptedException
    {
        try{
            String input = value.toString();
            String[] inputs = input.split(",");
	    if(inputs[14].contains("[0-9]+") || inputs[14].contains("."))
            {
                rate.set(Double.parseDouble(inputs[14]));
                plan.set((inputs[10]));
                context.write(plan, rate);
            }
        
        }catch (Exception ex) {
            Logger.getLogger(MedStd_Mapper.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
}

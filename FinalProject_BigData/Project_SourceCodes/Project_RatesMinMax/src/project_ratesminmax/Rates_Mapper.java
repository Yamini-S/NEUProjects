/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ratesminmax;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author yamini
 */
public class Rates_Mapper extends Mapper<Object, Text, AgeCompostieKeyWritable, MinMaxCountTuple>{
    
    MinMaxCountTuple tuple = new MinMaxCountTuple();
    
    public void map(Object key, Text value, Context context)
    {
        String[] tokens = value.toString().split(",");
        
        if(tokens[3].contains("state") && tokens[10].contains("age")){
        return;
        }
        else{
            AgeCompostieKeyWritable stateAge = new AgeCompostieKeyWritable(tokens[3],tokens[10]);
        
        try{
            tuple.setMin(tokens[11]);
            tuple.setMax(tokens[11]);
            tuple.setCount(1);
            
            context.write(stateAge, tuple);
        }catch(IOException | InterruptedException | NumberFormatException  e){
            System.out.println("Error in Mapper" + e.getMessage());
        }
        }
        

    }
    
}

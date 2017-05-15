/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ratesminmax;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author yamini
 */
public class Rates_Reducer extends Reducer<AgeCompostieKeyWritable,MinMaxCountTuple,AgeCompostieKeyWritable,MinMaxCountTuple>{
    
    private MinMaxCountTuple result = new MinMaxCountTuple();
    
    public void reduce(AgeCompostieKeyWritable key, Iterable<MinMaxCountTuple> values, Context context) throws IOException, InterruptedException{
  
        result.setMax(null);
        result.setMin(null);
        result.setCount(0);
        
        long sum = 0;
        
        for(MinMaxCountTuple val : values)
        {

        if(result.getMin()== null || val.getMin().compareTo(result.getMin()) <0)
        {
            result.setMin(val.getMin());
        }

        if(result.getMax()==null || val.getMax().compareTo(result.getMax())>0)
        {
            result.setMax(val.getMax());
        }
       
        sum +=  val.getCount();
      
        }
       
        result.setCount(sum);
          
        context.write(key,result);

       }

    }
    

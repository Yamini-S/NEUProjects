/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_movingavg;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author yamini
 */
public class Avg_Reducer extends Reducer<PlanDateTuple, DoubleWritable, PlanDateTuple, DoubleWritable> 
{
    private  int windowSize = 3; // default
    private final ArrayList<Float> rates = new ArrayList<>();

    @Override
    public void reduce(PlanDateTuple key, Iterable<DoubleWritable> values, Context context) 
            throws IOException, InterruptedException
    {
        double sum = 0;
        rates.clear(); //clear the list
        double mvAvg;
        
        for(DoubleWritable val: values)
        {
            rates.add((float)val.get());
        }
        
        for (int i=0; i < windowSize-1; i++) 
        {
            try{
                sum += rates.get(i);
            }catch(Exception e){
                System.out.println("Exception e"+e.getMessage());
            }
            
        }
        
        for (int i = windowSize-1; i < rates.size(); i++)
        {
            sum += rates.get(i);
            System.out.println(sum);
            mvAvg = (sum /windowSize);
            DoubleWritable movingAverage = new DoubleWritable();
            movingAverage.set(mvAvg);

            context.write(key, movingAverage);
            sum -= rates.get(i-windowSize+1);
        }
    }
    
}


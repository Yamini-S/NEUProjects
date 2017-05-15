/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_secondarysort;

import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author yamini
 */
public class SecondarySort_Reducer extends Reducer<StateAreaRateTuple, NullWritable, StateAreaRateTuple, NullWritable>{
    
    @Override
    public void reduce(StateAreaRateTuple key, Iterable<NullWritable> values, Context context) throws IOException{
        try{
            for(NullWritable val:values){
                context.write(key, val);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}

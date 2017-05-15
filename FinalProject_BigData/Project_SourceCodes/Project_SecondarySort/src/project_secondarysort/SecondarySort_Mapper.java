/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_secondarysort;

import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author yamini
 */
public class SecondarySort_Mapper extends Mapper<Object, Text, StateAreaRateTuple, NullWritable>{
    
    private final static StateAreaRateTuple tuple = new StateAreaRateTuple();
    private Text rate = new Text();
    
    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
       
        String[] tokens = value.toString().split(",");
        rate.set(tokens[11]);
        
        tuple.setState(tokens[3]);
        tuple.setRatingArea(tokens[7]+"\t"+tokens[8] +"\t"+ tokens[9]+"\t"+tokens[10] +"\t"+tokens[11] );
        context.write(tuple, NullWritable.get());
    }
    
}

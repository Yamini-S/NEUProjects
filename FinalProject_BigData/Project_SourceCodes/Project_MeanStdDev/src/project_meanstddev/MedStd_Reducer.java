/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_meanstddev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author yamini
 */
public class MedStd_Reducer extends Reducer<Text, DoubleWritable, Text, MedStdCompositeKey>{
    
    
	ArrayList<Double> inputs = new ArrayList<Double>();
        MedStdCompositeKey mstd = new MedStdCompositeKey();
	
	public void reduce(Text key, Iterable<DoubleWritable> values,Context context) 
                throws IOException, InterruptedException
        {
		double sum = 0.0;
		int count = 0;
		inputs.clear();
		
		for(DoubleWritable value:values)
                {
                    inputs.add(value.get());		 
		    sum += value.get();
                    count++;
		}
		
		Collections.sort(inputs);
		double mean = 0.0;
		if(count != 0)
                {
		   mean = sum / count;
		}else{
                    mean = sum / 1;
		}
		
		
		//Find Median
		if(inputs.size() % 2 == 0){
			int index = (int)(inputs.size()/2);
			int index1 = index - 1;
			mstd.setMedian( ((inputs.get(index1) + inputs.get(index))/2.0) );
			
			
		}else{
			mstd.setMedian(inputs.get((int)(inputs.size()/2)));
		}
		
		//Find Standard Deviation
		double sumOfSquares = 0.0;
		for(Double eachValue: inputs){
			sumOfSquares += (eachValue - mean)*(eachValue - mean); 
		}
		
		if((inputs.size() - 1) != 0){
			mstd.setStandardDeviation( Math.sqrt(sumOfSquares/(inputs.size()-1)) );
		}else{
			mstd.setStandardDeviation( Math.sqrt(sumOfSquares/1) );
		}

		context.write(key, mstd);
	}
	
	public ArrayList<Double> getArrayList(){
		if(this.inputs == null){
			inputs = new ArrayList<Double>();
		}
		return inputs;
	}
    
}

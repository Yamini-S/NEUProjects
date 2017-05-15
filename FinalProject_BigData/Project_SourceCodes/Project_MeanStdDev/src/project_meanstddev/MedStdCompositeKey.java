/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_meanstddev;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

/**
 *
 * @author yamini
 */
public class MedStdCompositeKey implements Writable{
    
    double median;
    double standardDeviation;
	
    public MedStdCompositeKey(){
        
    }
	
    public MedStdCompositeKey(double median, double standardDeviation){
	this.median = median;
	this.standardDeviation = standardDeviation;
    }
	
    public void readFields(DataInput dataInput) throws IOException {
	median = Double.parseDouble(WritableUtils.readString(dataInput));
	standardDeviation = Double.parseDouble(WritableUtils.readString(dataInput));
    }

    public void write(DataOutput dataOutput) throws IOException {
  	 WritableUtils.writeString(dataOutput, String.valueOf(median));
	 WritableUtils.writeString(dataOutput, String.valueOf(standardDeviation));
    }

    public double getMedian() {
	return median;
    }

    public void setMedian(double median) {
	this.median = median;
    }

    public double getStandardDeviation() {
	return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
	this.standardDeviation = standardDeviation;
    }

    
    @Override
    public String toString() {
      // TODO Auto-generated method stub
	return (median + "\t"+standardDeviation);
    }

}

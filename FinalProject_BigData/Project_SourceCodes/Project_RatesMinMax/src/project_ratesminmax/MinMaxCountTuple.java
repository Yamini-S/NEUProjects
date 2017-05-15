/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ratesminmax;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

/**
 *
 * @author yamini
 */
public class MinMaxCountTuple implements Writable{
    
    private String min;
    private String max;
    private long count;

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
    
    

    @Override
    public void write(DataOutput d) throws IOException {
        d.writeLong(count);
        WritableUtils.writeString(d, min);
        WritableUtils.writeString(d, max);
    }

    @Override
    public void readFields(DataInput di) throws IOException {
        count = di.readLong();
        min = WritableUtils.readString(di);
        max = WritableUtils.readString(di);
    }
    
    public String toString(){
        return min + "\t" + max + "\t" + count ;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_secondarysort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

/**
 *
 * @author yamini
 */
public class StateAreaRateTuple implements Writable, WritableComparable<StateAreaRateTuple>{
    
    public String state;
    public String ratingArea;
    
    

    @Override
    public void write(DataOutput d) throws IOException {
        WritableUtils.writeString(d,state);
        WritableUtils.writeString(d, ratingArea);        
    }

    @Override
    public void readFields(DataInput di) throws IOException {
        state = WritableUtils.readString(di);
        ratingArea = WritableUtils.readString(di);
    }

    @Override
    public int compareTo(StateAreaRateTuple o) {
        int compareValue = this.ratingArea.compareTo(o.getRatingArea());
        if(compareValue==0){
            compareValue = state.compareTo(o.getState());
        }
        return -1*compareValue;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRatingArea() {
        return ratingArea;
    }

    public void setRatingArea(String ratingArea) {
        this.ratingArea = ratingArea;
    }
    
    public String toString(){
        return state + "\t" + ratingArea;
    }
    
}

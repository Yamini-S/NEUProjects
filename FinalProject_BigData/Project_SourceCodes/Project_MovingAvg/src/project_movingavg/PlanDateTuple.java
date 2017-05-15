/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_movingavg;

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
public class PlanDateTuple implements Writable, WritableComparable<PlanDateTuple>{
    
    
    public String plan;
    public String month;
    
    public PlanDateTuple(){
        
    }
    
    public PlanDateTuple(String p, String m){
        this.plan = p;
        this.month = m;
    } 

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
    

    @Override
    public void write(DataOutput d) throws IOException {
        WritableUtils.writeString(d, plan);
        WritableUtils.writeString(d, month);
    }

    @Override
    public void readFields(DataInput di) throws IOException {
        plan = WritableUtils.readString(di);
        month = WritableUtils.readString(di);
    }

    @Override
    public int compareTo(PlanDateTuple o) {
        int result = month.compareTo(o.month);
        if(result == 0){
            result = plan.compareTo(o.plan);
        }
        return result;
    }
    
    public String toString(){
        return  plan + "\t" + month;
    }
        
}
    
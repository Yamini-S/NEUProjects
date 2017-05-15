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
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

/**
 *
 * @author yamini
 */
public class AgeCompostieKeyWritable implements Writable,WritableComparable<AgeCompostieKeyWritable>{
    
    private String state;
    private String age;
    
    public AgeCompostieKeyWritable(){
        
    }
    
    public AgeCompostieKeyWritable(String y,String a){
        this.state = y;
        this.age = a;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public void write(DataOutput d) throws IOException {
       WritableUtils.writeString(d, state);
       WritableUtils.writeString(d, age);
    }

    @Override
    public void readFields(DataInput di) throws IOException {
       state = WritableUtils.readString(di);
       age = WritableUtils.readString(di);
    }

    @Override
    public int compareTo(AgeCompostieKeyWritable o) {
        int result = age.compareTo(o.age);
        if(result == 0){
            result = state.compareTo(o.state);
        }
        return result;
    }
    
    
    public String toString(){
        return state + "\t" + age;
    }
}

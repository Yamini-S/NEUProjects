/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_secondarysort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 *
 * @author yamini
 */
public class Project_GroupingComparator extends WritableComparator{
    
    public Project_GroupingComparator(){
        super(StateAreaRateTuple.class,true);
    }
    
    
    @Override
    public int compare(WritableComparable wc1, WritableComparable wc2){
        StateAreaRateTuple tuple1 = (StateAreaRateTuple)wc1;
        StateAreaRateTuple tuple2 = (StateAreaRateTuple)wc2;
        return tuple1.getRatingArea().compareTo(tuple2.getRatingArea());
    }
}

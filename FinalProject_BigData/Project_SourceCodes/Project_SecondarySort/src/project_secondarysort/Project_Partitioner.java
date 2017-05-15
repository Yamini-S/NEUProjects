/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_secondarysort;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 *
 * @author yamini
 */
public class Project_Partitioner extends Partitioner<StateAreaRateTuple,NullWritable>{

    @Override
    public int getPartition(StateAreaRateTuple key, NullWritable value, int i) {
        return Math.abs(key.state.hashCode()%i);
    }
    
}

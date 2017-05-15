/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_partitioning;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 *
 * @author yamini
 */
public class Partitioning_Partitioner extends Partitioner<Text,Text> {
    
     @Override
    public int getPartition(Text key, Text value, int numOfPartitions) {
        return(key.hashCode()%numOfPartitions);
    }
    
    
}

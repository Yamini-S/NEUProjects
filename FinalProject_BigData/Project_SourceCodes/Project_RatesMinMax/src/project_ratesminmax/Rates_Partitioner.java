/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ratesminmax;

import org.apache.hadoop.mapreduce.Partitioner;

/**
 *
 * @author yamini
 */
public class Rates_Partitioner extends Partitioner<AgeCompostieKeyWritable, MinMaxCountTuple>{

    @Override
    public int getPartition(AgeCompostieKeyWritable key, MinMaxCountTuple value, int i) {
        if(!key.getAge().contains("Family")){
            return (key.getAge().hashCode()%i);
        }
        else{
            return 2;
        }
    }
    
    
}

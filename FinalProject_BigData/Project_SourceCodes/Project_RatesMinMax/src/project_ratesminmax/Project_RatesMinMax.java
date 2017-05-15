/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ratesminmax;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author yamini
 */
public class Project_RatesMinMax {

    public static void main(String[] args) {
        
    try {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "RatesMinMax");
        job.setJarByClass(Project_RatesMinMax.class);
        job.setMapperClass(Rates_Mapper.class);
        job.setMapOutputKeyClass(AgeCompostieKeyWritable.class);
        job.setMapOutputValueClass(MinMaxCountTuple.class);
        job.setCombinerClass(Rates_Reducer.class);
        job.setReducerClass(Rates_Reducer.class);
        job.setOutputKeyClass(AgeCompostieKeyWritable.class);
        job.setOutputValueClass(MinMaxCountTuple.class);
        job.setPartitionerClass(Rates_Partitioner.class);
        //job.setNumReduceTasks(10);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
        } catch (IOException | InterruptedException | ClassNotFoundException ex) {
         System.out.println("Main Error" + ex.getMessage());
         }
    }


    
}

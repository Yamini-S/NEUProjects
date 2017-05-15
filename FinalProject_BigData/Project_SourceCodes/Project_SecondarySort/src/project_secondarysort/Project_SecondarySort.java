/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_secondarysort;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author yamini
 */
public class Project_SecondarySort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            try {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "SecondarySort");
        job.setJarByClass(Project_SecondarySort.class);
        job.setMapperClass(SecondarySort_Mapper.class);
        job.setMapOutputKeyClass(StateAreaRateTuple.class);
        job.setMapOutputValueClass(NullWritable.class);
        //job.setCombinerClass(SecondarySort_Reducer.class);
        job.setPartitionerClass(Project_Partitioner.class);
        job.setGroupingComparatorClass(Project_GroupingComparator.class);
        job.setNumReduceTasks(6);
        job.setReducerClass(SecondarySort_Reducer.class);
        job.setOutputKeyClass(StateAreaRateTuple.class);
        job.setOutputValueClass(NullWritable.class);
        job.setPartitionerClass(Project_Partitioner.class);
        //job.setNumReduceTasks(10);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
        } catch (IOException | InterruptedException | ClassNotFoundException ex) {
         System.out.println("Main Error" + ex.getMessage());
         }
    }
    
}

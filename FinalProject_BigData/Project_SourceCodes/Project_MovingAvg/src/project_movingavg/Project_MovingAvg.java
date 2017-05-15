/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_movingavg;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author yamini
 */
public class Project_MovingAvg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            Configuration conf = new Configuration();
            Job job = Job.getInstance(conf, "Moving Average");
            job.setJarByClass(Project_MovingAvg.class);
            job.setMapperClass(Avg_Mapper.class);
            job.setMapOutputKeyClass(PlanDateTuple.class);
            job.setMapOutputValueClass(DoubleWritable.class);
            job.setCombinerClass(Avg_Reducer.class);
            job.setReducerClass(Avg_Reducer.class);
            job.setNumReduceTasks(6);
            job.setOutputKeyClass(PlanDateTuple.class);
            job.setOutputValueClass(DoubleWritable.class);
            FileInputFormat.addInputPath(job, new Path(args[0]));
            FileOutputFormat.setOutputPath(job, new Path(args[1]));
            System.exit(job.waitForCompletion(true) ? 0 : 1);
            }catch(Exception e){
                System.out.print("Exception:"+e);
            }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_distinctpattern;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author yamini
 */
public class Project_DistinctPattern {


    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        
        try{
            Configuration conf = new Configuration();
            Job job = Job.getInstance(conf, "Project_DistinctPattern");
            job.setJarByClass(Project_DistinctPattern.class);
            job.setMapperClass(Distinct_Mapper.class);
            job.setCombinerClass(Distinct_Reducer.class);
            job.setReducerClass(Distinct_Reducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(NullWritable.class);
            FileInputFormat.addInputPath(job, new Path(args[0]));
            FileOutputFormat.setOutputPath(job, new Path(args[1]));
            System.exit(job.waitForCompletion(true) ? 0 : 1);
            }catch(Exception e){
                System.out.print("Exception:"+e);
            }
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_joins;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 *
 * @author yamini
 */
public class Project_Joins {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        try {
            Configuration conf = new Configuration();
            
            Job job = Job.getInstance(conf, "Joins");
            job.setJarByClass(Project_Joins.class);
            
            MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, Area_Mapper.class);
            MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, Network_Mapper.class);
            job.getConfiguration().set("join.type", "inner");
            //job.setNumReduceTasks(0);
            job.setReducerClass(Joins_Reducer.class);
            
            job.setOutputFormatClass(TextOutputFormat.class);
            TextOutputFormat.setOutputPath(job, new Path(args[2]));
            
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Text.class);
            
            job.waitForCompletion(true);
        } catch (IOException ex) {
            Logger.getLogger(Project_Joins.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

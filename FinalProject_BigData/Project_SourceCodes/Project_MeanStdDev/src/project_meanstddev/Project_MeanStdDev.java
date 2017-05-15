/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_meanstddev;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 *
 * @author yamini
 */
public class Project_MeanStdDev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Configuration conf = new Configuration();
	try{
                 
            Job job = Job.getInstance(conf, "Median & Standard Deviation");
	    job.setJarByClass(Project_MeanStdDev.class);
	    job.setMapperClass(MedStd_Mapper.class);
	    job.setReducerClass(MedStd_Reducer.class);
	    job.setMapOutputKeyClass(Text.class);
	    job.setMapOutputValueClass(DoubleWritable.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(MedStdCompositeKey.class);
	    FileInputFormat.addInputPath(job, new Path(args[0]));            
            FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
            }catch (IOException e) {
		System.out.println("IOException Inside Stock Price Driver");
	    }catch (ClassNotFoundException e) {
		System.out.println("Class Not Found Exception in Stock Price Driver");
	    }catch(InterruptedException e){
		System.out.println("Interrupted Exception in Stock Price Driver");
	    }
	}
    
}

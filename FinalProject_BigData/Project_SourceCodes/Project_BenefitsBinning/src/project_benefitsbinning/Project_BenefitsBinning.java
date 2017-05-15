/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_benefitsbinning;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 *
 * @author yamini
 */
public class Project_BenefitsBinning {


    public static class Binning_Mapper extends Mapper<Object, Text, Text, Text>{
        
        private MultipleOutputs<Text,Text> mos = null;
        private Text outKey = new Text();
        
        protected void setup(Context context)
        {
            mos = new MultipleOutputs(context);
        }
        
        protected void map(Object key, Text value, Context context) throws IOException, InterruptedException
        {
            String[] rows = value.toString().split(",");
            String s = rows[3];
            
            
            for(String k: rows){
               String StateCode = s;
                
                if(StateCode.equalsIgnoreCase("AK")){
                    mos.write("bins",value,NullWritable.get(),"AK");
                }
                if(StateCode.equalsIgnoreCase("AL")){
                    mos.write("bins",value,NullWritable.get(),"AL");
                }
                if(StateCode.equalsIgnoreCase("AZ")){
                    mos.write("bins",value,NullWritable.get(),"AZ");
                }
                if(StateCode.equalsIgnoreCase("FL")){
                    mos.write("bins", value,NullWritable.get(),"FL");
                }
                if(StateCode.equalsIgnoreCase("GA")){
                    mos.write("bins", value,NullWritable.get(),"GA");
                }
                if(StateCode.equalsIgnoreCase("IN")){
                    mos.write("bins", value,NullWritable.get(),"IN");
                }
                if(StateCode.equalsIgnoreCase("LA")){
                    mos.write("bins", value,NullWritable.get(),"LA");
                }
                if(StateCode.equalsIgnoreCase("MO")){
                    mos.write("bins", value,NullWritable.get(),"MO");
                }
                if(StateCode.equalsIgnoreCase("MS")){
                    mos.write("bins",value,NullWritable.get(),"MS");
                }
                if(StateCode.equalsIgnoreCase("NC")){
                    mos.write("bins", value,NullWritable.get(),"NC");
                }
                if(StateCode.equalsIgnoreCase("NJ")){
                    mos.write("bins", value,NullWritable.get(),"NJ");
                }
                if(StateCode.equalsIgnoreCase("OK")){
                    mos.write("bins", value,NullWritable.get(),"OK");
                }
                if(StateCode.equalsIgnoreCase("PA")){
                    mos.write("bins", value,NullWritable.get(),"PA");
                }
                if(StateCode.equalsIgnoreCase("SC")){
                    mos.write("bins", value,NullWritable.get(),"SC");
                }
                
                if(StateCode.equalsIgnoreCase("TN")){
                    mos.write("bins", value,NullWritable.get(),"TN");
                }
                if(StateCode.equalsIgnoreCase("TX")){
                    mos.write("bins", value,NullWritable.get(),"TX");
                }
                if(StateCode.equalsIgnoreCase("WI")){
                    mos.write("bins", value,NullWritable.get(),"WI");
                }
                if(StateCode.equalsIgnoreCase("WY")){
                    mos.write("bins", value,NullWritable.get(),"WY");
                }
        
            }
            
        } 
        
          protected void cleanup(Context context) throws IOException, InterruptedException{
            mos.close();
            
        }
    
    }    
        
        
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Binning");
        job.setJarByClass(Project_BenefitsBinning.class);
        job.setMapperClass(Binning_Mapper.class);
        job.setNumReduceTasks(0);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        //MultipleOutputs.addNamedOutput(job, namedOutput, outputFormatClass, keyClass, valueClass);
        MultipleOutputs.addNamedOutput(job, "bins", TextOutputFormat.class, Text.class, NullWritable.class);
        MultipleOutputs.setCountersEnabled(job, true);
        
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true)?0:1);
    }
    
}

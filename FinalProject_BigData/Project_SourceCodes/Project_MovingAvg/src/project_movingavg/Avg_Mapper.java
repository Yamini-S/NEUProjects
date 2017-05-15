/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_movingavg;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author yamini
 */
public class Avg_Mapper extends Mapper<Object, Text, PlanDateTuple, DoubleWritable>{
    
    DoubleWritable rate = new DoubleWritable();
    
    public void map(Object key, Text value, Context context) 
            throws IOException, InterruptedException
    {
        try {
            String[] values = value.toString().split(",");
            
            //String date = values[8];
            String date = values[5];
            
            DateFormat frmt = new SimpleDateFormat("yyyy-mm-dd");
            //DateFormat frmt = new SimpleDateFormat("mm/dd/yyyy");            
            Date newDate = frmt.parse(date);
            
            DateFormat df = new SimpleDateFormat("mm");
            String month = df.format(newDate);
            
            PlanDateTuple planDate = new PlanDateTuple(values[7], month);
            
            rate.set(Double.parseDouble(values[11]));
            context.write(planDate, rate);
        } catch (ParseException ex) {
            Logger.getLogger(Avg_Mapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}


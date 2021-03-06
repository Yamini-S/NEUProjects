/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_joins;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author yamini
 */
public class Network_Mapper extends Mapper<Object, Text, Text, Text>{
    
    private Text issuerID = new Text();
    private Text rateValue = new Text();
    
    public void map(Object key, Text value, Context context) 
            throws IOException, InterruptedException
    {
        try{
        String[] tokens = value.toString().split(",");
	String id = tokens[3];
			
	if (id == null) 
        {
            return;
        }
        
        issuerID.set(id);
	rateValue.set("R" + tokens[9] + "\t" + tokens[13] + "\t" + tokens[14]);
	context.write(issuerID, rateValue);
    }catch(Exception e){
        System.out.println("Exception is:"+e.getMessage());
    }
    }
    
}

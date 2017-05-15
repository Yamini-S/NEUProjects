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
public class Area_Mapper extends Mapper<Object, Text, Text, Text> {
    
    private Text issuerID = new Text();
    private Text areaValue = new Text();

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
			
	areaValue.set("A" + tokens[2]+"\t"+tokens[4] +"\t"+tokens[10]+ "\t"+tokens[11]);
	context.write(issuerID, areaValue);
    }catch(Exception e){
        System.out.println("Exception is:"+ e.getMessage());
    }
    }
}


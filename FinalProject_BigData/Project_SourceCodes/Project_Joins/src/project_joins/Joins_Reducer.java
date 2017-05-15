/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_joins;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author yamini
 */
public class Joins_Reducer extends Reducer<Text, Text, Text, Text>{
    
    private static final Text EMPTY_TEXT = new Text("");
    private Text tmp = new Text();
    private ArrayList<Text> listA = new ArrayList<Text>();
    private ArrayList<Text> listR = new ArrayList<Text>();
    private String joinType = null;

    public void setup(Context context) 
    {
        // Get the type of join from our configuration
        joinType = context.getConfiguration().get("join.type");
    }

    
    public void reduce(Text key, Iterable<Text> values, Context context) 
            throws IOException, InterruptedException 
    {
        // Clear our lists
        listA.clear();
        listR.clear();
        // iterate through all our values, binning each record based on what
        // it was tagged with. Make sure to remove the tag!
        
        while (values.iterator().hasNext()) {
            tmp = values.iterator().next();
            System.out.println(Character.toString((char) tmp.charAt(0)));
            if (Character.toString((char) tmp.charAt(0)).equals("A")) 
            {
                System.out.println("here4");
                listA.add(new Text(tmp.toString().substring(1)));
            }
            
            
            if (Character.toString((char) tmp.charAt(0)).equals("R"))
            {
                System.out.println("here5");
                listR.add(new Text(tmp.toString().substring(1)));
            }
            
                System.out.println(tmp);
            }
        
        
            // Execute our join logic now that the lists are filled

            System.out.println(listR.size());
            executeJoinLogic(context);
        }

        private void executeJoinLogic(Context context) throws IOException, InterruptedException {

            if (joinType.equalsIgnoreCase("inner")) {
                // If both lists are not empty, join A with B
                if (!listA.isEmpty() && !listR.isEmpty()) {
                    System.out.println("here");
                    for (Text A : listA) {
                        //System.out.println("here1");
                        for (Text R : listR) {
                            //System.out.println("here2");
                            context.write(A, R);
                        }
                    }
                }
            } else if (joinType.equalsIgnoreCase("leftouter")) {
                // For each entry in A,
                for (Text A : listA) {
                    // If list B is not empty, join A and B
                    if (!listR.isEmpty()) {
                        for (Text R : listR) {
                            context.write(A, R);
                        }
                    } else {
                        // Else, output A by itself
                        context.write(A, EMPTY_TEXT);
                    }
                }
            } 
        }
    }

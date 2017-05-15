/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Sink;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author yamini
 */
public class BloomFilter_Mapper extends Mapper<Object, Text, Text, NullWritable> {
    
    
     Funnel<PlanBenefits> pfunnel = new Funnel<PlanBenefits>() {
         
        @Override
        public void funnel(PlanBenefits p, Sink into) {
             into.putString(p.benefitName, Charsets.UTF_8).putString(p.isCovered, Charsets.UTF_8);
			
         }
    };
     
     
    private BloomFilter<PlanBenefits> planBenefitsFilter = BloomFilter.create(pfunnel, 500, 0.1);

    @Override
    public void setup(Context context) throws IOException, InterruptedException {
                    
        PlanBenefits p1 = new PlanBenefits("Accidental Dental", "Covered");
        PlanBenefits p2 = new PlanBenefits("Routine Dental Services (Adult)", "Covered");
        PlanBenefits p3 = new PlanBenefits("Basic Dental Care - Child", "Covered");
        ArrayList<PlanBenefits> planBenefitsList = new ArrayList<PlanBenefits>();
	planBenefitsList.add(p1);
        planBenefitsList.add(p2);
        planBenefitsList.add(p2);
                    
        for (PlanBenefits pb : planBenefitsList) {
             planBenefitsFilter.put(pb);
        }
		
    }

		
    @Override
    public void map(Object key, Text value, Context context) 
            throws IOException, InterruptedException 
    {
        String values[] = value.toString().split(",");
	PlanBenefits b = new PlanBenefits(values[0], values[1]);
	if (planBenefitsFilter.mightContain(b)) {
            context.write(value, NullWritable.get());
	
        }
    }

}

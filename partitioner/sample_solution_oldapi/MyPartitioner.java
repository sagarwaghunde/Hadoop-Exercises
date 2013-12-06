import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Partitioner;

public class MyPartitioner<K2, V2> implements Partitioner<Text, Text> {
	
	HashMap months = new HashMap();

	public void configure(JobConf job) { 
		months.put("Jan", 0);
		months.put("Feb", 1);
		months.put("Mar", 2);
		months.put("Apr", 3);
		months.put("May", 4);
		months.put("Jun", 5);
		months.put("Jul", 6);
		months.put("Aug", 7);
		months.put("Sep", 8);
		months.put("Oct", 9);
		months.put("Nov", 10);
		months.put("Dec", 11);
	}

    public int getPartition(Text key, Text value,
                                      int numReduceTasks) {
    	
    	return (Integer) (months.get(value.toString()));
    }

}

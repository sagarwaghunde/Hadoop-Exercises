import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.Mapper;

public class LogFileMapper extends MapReduceBase implements
    Mapper<LongWritable, Text, Text, Text> {
  /*
   * Input line looks like: 96.7.4.14 - - [24/Apr/2011:04:20:11 -0400]
   * "GET /cat.jpg HTTP/1.1" 200 12433
   */
  @Override
  public void map(LongWritable key, Text value,
      OutputCollector<Text, Text> output, Reporter reporter)
      throws IOException {
    String[] fields = value.toString().split(" ");
    if (fields.length > 3) {
      String ip = fields[0];
      String[] dtFields = fields[3].split("/");
      if (dtFields.length > 1) {
    	  String theMonth = dtFields[1];
      
    	  output.collect(new Text(ip), new Text(theMonth));
      }
    }
  }
}

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Example input line:
 * 96.7.4.14 - - [24/Apr/2011:04:20:11 -0400] "GET /cat.jpg HTTP/1.1" 200 12433
 *
 */
public class LogFileMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

    /*
     * Split the line using into fields using the space character as the 
     * delimiter. Use a call similar to value.toString().split("\")
     */
    /*
     * TODO implement 
     */

    /*
     * If there is one or more fields in the line, place the
     * field into a String variable. Then emit the first field 
     * (an IP address) as the key and the number 1 as the value.
     */
    /*
     * TODO implement 
     */
 
  }
}
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class ImageCounterMapper extends MapReduceBase implements
    Mapper<LongWritable, Text, Text, IntWritable> {
  /*
   * Input line looks like: 96.7.4.14 - - [24/Apr/2011:04:20:11 -0400]
   * "GET /cat.jpg HTTP/1.1" 200 12433 "http://google.com" "Firefox/3.6.16"
   */
  @Override
  public void map(LongWritable key, Text value,
      OutputCollector<Text, IntWritable> output, Reporter reporter)
      throws IOException {
    String[] fields = value.toString().split("\"");
    if (fields.length > 1) {
      String request = fields[1];
      fields = request.split(" ");
      if (fields.length > 1) {
        String fileName = fields[1].toLowerCase();
        if (fileName.endsWith(".jpg")) {
          reporter.getCounter("ImageCounter", "jpg").increment(1);
        } else if (fileName.endsWith(".gif")) {
          reporter.getCounter("ImageCounter", "gif").increment(1);
        } else {
          reporter.getCounter("ImageCounter", "other").increment(1);
        }
      }
    }
  }
}

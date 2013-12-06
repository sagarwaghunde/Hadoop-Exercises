import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCoMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    /*
     * Convert the line to lower case.
     */
    String line_lc = value.toString().toLowerCase();
    String last = null;
    
    /*
     * Split the line into words. For each word on the line
     * except for the first word, emit an output record that has
     * "previous word, this word" as the key and 1 as the value.
     */
    for (String word : line_lc.split("\\W+")) {
      if (word.length() > 0) {
        if (last != null) {
          context.write(new Text(last + "," + word), new IntWritable(1));
        }
        last = word;
      }
    }
  }
}

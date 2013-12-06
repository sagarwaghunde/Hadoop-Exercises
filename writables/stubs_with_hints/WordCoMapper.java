import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCoMapper extends
    Mapper<LongWritable, Text, StringPairWritable, LongWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    /*
     * Convert the line, which is received as a Text object,
     * to a String object, then convert it to lower case.
     */
    /*
     * TODO implement
     */
    
    /*
     * Split the line into words. For each word on the line
     * except for the first word, emit an output record that has
     * "previous word, this word" as the key and 1 as the value.
     * Hint: for each word in the line, emit a StringPairWritable 
     * object as the key.
     */
    /*
     * TODO implement
     */

  }
}

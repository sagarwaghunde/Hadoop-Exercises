import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SumReducer extends Reducer<Text, Text, Text, IntWritable> {

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
    int wordCount = 0;

    /*
     * The following code lets you iterate through the values without 
     * referencing them. We're not interested in referencing the
     * values - we only want to count them.  
     * Using
     *   for (Text value : values)  
     * produces a compiler warning unless you reference the value. 
     */
    while (values.iterator().hasNext()) {
      values.iterator().next();
      wordCount++;
    }
    context.write(key, new IntWritable(wordCount));
  }
}

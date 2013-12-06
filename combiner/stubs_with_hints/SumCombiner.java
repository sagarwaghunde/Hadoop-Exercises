import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * This is the combiner class. Observe that the code in this class
 * is identical to the reducer code.
 */ 
public class SumCombiner extends Reducer<Text, IntWritable, Text, IntWritable> {

  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {

    /*
     * For each value in the set of values passed to us by the mapper:
     */
    /*
     * TODO implement - start your loop here
     */
      
      /*
       * Get the value and add it to the wordCount variable
       */
      /*
       * TODO implement
       */
    /*
     * TODO implement - end your loop here
     */

    /*
     * Call the write method on the Context object to emit a key
     * (the word) and a value (the works count for this word)
     */
    /*
     * TODO implement
     */
  }
}
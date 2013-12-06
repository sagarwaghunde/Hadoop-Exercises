import java.io.IOException;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Reducer;

/**
 * On input, the reducer receives a word as the key and a set
 * of locations in the form "play name@line number" for the values. 
 * The reducer builds a readable string in the valueList variable that
 * contains an index of all the locations of the word. 
 */
public class IndexReducer extends Reducer<Text, Text, Text, Text> {

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {

    /*
     * TODO implement 
     * For each "play name@line number" in the input value set:
     */

      /*
       * If this is not the word's first location, add a comma to the
       * end of valueList.
       */
      /*
       * TODO implement 
       */
      
      /*
       * Convert the location to a String and append it to valueList.
       */
      /*
       * TODO implement 
       */

    /*
     * Emit the index entry. 
     */
    /*
     * TODO implement 
     */
  }
}
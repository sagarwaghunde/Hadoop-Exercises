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

  private static final String SEP = ",";

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {

    StringBuilder valueList = new StringBuilder();
    boolean firstValue = true;

    /*
     * For each "play name@line number" in the input value set:
     */
    for (Text value : values) {

      /*
       * If this is not the word's first location, add a comma to the
       * end of valueList.
       */
      if (!firstValue) {
        valueList.append(SEP);
      } else {
        firstValue = false;
      }
      
      /*
       * Convert the location to a String and append it to valueList.
       */
      valueList.append(value.toString()); 
    }

    /*
     * Emit the index entry. 
     */
    context.write(key, new Text(valueList.toString()));
  }
}
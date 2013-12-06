import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
/*
 * TO DO implement
 * Provide additional import statements here
 */
import org.junit.Before;
import org.junit.Test;

public class TestWordCount {

  /*
   * Declare harnesses that let you test a mapper, a reducer, and
   * a mapper and a reducer working together.
   */
  MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;
  /*
   * TODO implement for mapper and mapper/reducer working together
   */

  /*
   * Set up the test. This method will be called before every test.
   */
  @Before
  public void setUp() {

    /*
     * Set up the mapper test harness.
     */
    WordMapper mapper = new WordMapper();
    mapDriver = new MapDriver<LongWritable, Text, Text, IntWritable>();
    mapDriver.setMapper(mapper);

    /*
     * Set up the reducer test harness.
     */
    /*
     * TODO implement 
     */

    /*
     * Set up the mapper/reducer test harness.
     */
    /*
     * TODO implement 
     */
  }

  /*
   * Test the mapper.
   */
  @Test
  public void testMapper() {

    /*
     * For this test, the mapper's input will be "1 cat cat dog" 
     */
    /*
     * TODO implement 
     */

    /*
     * The expected output is "cat 1", "cat 1", and "dog 1".
     */
    /*
     * TODO implement 
     */

    /*
     * Run the test.
     */
    /*
     * TODO implement 
     */
  }

  /*
   * Test the reducer.
   */
  @Test
  public void testReducer() {

    List<IntWritable> values = new ArrayList<IntWritable>();
    values.add(new IntWritable(1));
    values.add(new IntWritable(1));

    /*
     * For this test, the reducer's input will be "cat 1 1".
     */
    /*
     * TODO implement 
     */

    /*
     * The expected output is "cat 2"
     */
    /*
     * TODO implement 
     */


    /*
     * Run the test.
     */
    /*
     * TODO implement 
     */
  }

  /*
   * Test the mapper and reducer working together.
   */
  @Test
  public void testMapReduce() {

    /*
     * For this test, the mapper's input will be "1 cat cat dog" 
     */
    /*
     * TODO implement 
     */

    /*
     * The expected output (from the reducer) is "cat 2", "dog 1". 
     */
    /*
     * TODO implement 
     */

    /*
     * Run the test.
     */
    /*
     * TODO implement 
     */
  }
}

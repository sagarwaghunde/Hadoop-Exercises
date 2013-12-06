/*
 * TO DO implement
 * Provide additional import statements here
 */
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCo extends Configured implements Tool {

  @Override
  public int run(String[] args) throws Exception {

    if (args.length != 2) {
      System.out.printf("Usage: WordCo <input dir> <output dir>\n");
      return -1;
    }

    Job job = new Job(getConf());
    job.setJarByClass(WordCo.class);
    job.setJobName("Custom Writable Comparable");

    /*
     * Set the input and output paths.
     */
    /*
     * TODO implement 
     */

    /*
     * Set the mapper and reducer classes. For the reducer class, use 
     * LongSumReducer, which is a Hadoop API class that sums values into
     * A LongWritable.
     */
    /*
     * TODO implement 
     */

    /*
     * Set the output key and value classes.
     */
    /*
     * TODO implement 
     */

    boolean success = job.waitForCompletion(true);
    return success ? 0 : 1;
  }

  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new Configuration(), new WordCo(), args);
    System.exit(exitCode);
  }
}

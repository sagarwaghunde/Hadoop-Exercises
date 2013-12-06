/*
 * TO DO implement
 * Provide additional import statements here
 */
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ImageCounter extends Configured implements Tool {

  @Override
  public int run(String[] args) throws Exception {

    if (args.length != 2) {
      System.out.printf("Usage: ImageCounter <input dir> <output dir>\n");
      return -1;
    }

    Job job = new Job(getConf());
    job.setJarByClass(ImageCounter.class);
    job.setJobName("Image Counter");

    /*
     * Set the input and output paths.
     */
    /*
     * TODO implement 
     */

    /*
     * Set the mapper class.
     * This is a map-only job, so we do not call setReducerClass.
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

    /*
     * Set the number of reduce tasks to 0. 
     */
     /*
     * TODO implement 
     */

    boolean success = job.waitForCompletion(true);
    if (success) {
      /*
       * Print out the counters that the mappers have been incrementing.
       * Use a call similar to job.getCounters().findCounter("ImageCounter","jpg").getValue()
       * to get the JPG counter.
       * Use System.out.println to print out each counter.
       */
     /*
     * TODO implement 
     */

      return 0;
    } else
      return 1;
  }

  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new Configuration(), new ImageCounter(), args);
    System.exit(exitCode);
  }
}
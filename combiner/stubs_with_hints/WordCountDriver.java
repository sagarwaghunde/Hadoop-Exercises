/*
 * TO DO implement
 * Provide additional import statements here
 */
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/*
 * This driver class is called using the ToolRunner.run method
 * call in the main method (below). Extending the Configured class 
 * enables the driver class to access Hadoop configuration options.
 */
public class WordCountDriver extends Configured implements Tool {

  @Override
  public int run(String[] args) throws Exception {

    if (args.length != 2) {
      System.out.printf("Usage: WordCountDriver <input dir> <output dir>\n");
      return -1;
    }

    Job job = new Job(getConf());
    job.setJarByClass(WordCountDriver.class);
    job.setJobName("Word Count Driver");

    /*
     * Set the input and output paths.
     */
    /*
     * TODO implement 
     */

    /*
     * Set the mapper and reducer classes.
     */
    /*
     * TODO implement 
     */

    /*
     * Specify SumCombiner as the combiner class.
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

    if (job.getCombinerClass() == null) {
      throw new Exception("Combiner not set");
    }

    boolean success = job.waitForCompletion(true);
    return success ? 0 : 1;
  }

  /*
   * The main method calls the ToolRunner.run method, which
   * calls an options parser that interprets Hadoop command-line
   * options and puts them into a Configuration object.
   */
  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new Configuration(), new WordCountDriver(), args);
    System.exit(exitCode);
  }
}

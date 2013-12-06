/*
 * TO DO implement
 * Provide additional import statements here
 */
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class InvertedIndex extends Configured implements Tool {

  public int run(String[] args) throws Exception {

    if (args.length != 2) {
      System.out.printf("Usage: InvertedIndex <input dir> <output dir>\n");
      return -1;
    }

    Job job = new Job(getConf());
    job.setJarByClass(InvertedIndex.class);
    job.setJobName("Inverted Index");

    /*
     * We are using a KeyValueText file as the input file.
     * Therefore, we must call setInputFormatClass.
     * There is no need to call setOutputFormatClass, because the
     * application uses a text file for output.
     */
    /*
     * TODO implement 
     */

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
     * Set the output key and value classes.
     */
    /*
     * TODO implement 
     */

    boolean success = job.waitForCompletion(true);
    return success ? 0 : 1;
  }

  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new Configuration(), new InvertedIndex(), args);
    System.exit(exitCode);
  }
}

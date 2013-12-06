/*
 * You will need the following additional import statements:
 * import org.apache.hadoop.fs.Path;
 * import org.apache.hadoop.io.DoubleWritable;
 * import org.apache.hadoop.io.IntWritable;
 * import org.apache.hadoop.io.Text;
 * import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
 * import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
 */
import org.apache.hadoop.mapreduce.Job;

public class AvgWordLength {

  public static void main(String[] args) throws Exception {

    /*
     * Validate that two arguments were passed from the command line.
     */
    if (args.length != 2) {
      System.out.printf("Usage: AvgWordLength <input dir> <output dir>\n");
      System.exit(-1);
    }

    /*
     * Instantiate a Job object for your job's configuration. 
     */
    Job job = new Job();
    
    /*
     * Specify the jar file that contains your driver, mapper, and reducer.
     * Hadoop will transfer this jar file to nodes in your cluster running 
     * mapper and reducer tasks.
     */
    job.setJarByClass(AvgWordLength.class);
    
    /*
     * Specify an easily-decipherable name for the job.
     * This job name will appear in reports and logs.
     */
    job.setJobName("Average Word Length");

    /*
     * Specify the paths to the input and output data based on the
     * command-line arguments. 
     */
    /*
     * TODO implement
     */

    /*
     * Specify the mapper and reducer classes.
     */
    /*
     * TODO implement
     */

    /*
     * The input file and output files are text files, 
     * so there is no need to call the setInputFormatClass and 
     * setOutputFormatClass methods.
     */

    /*
     * The mapper's output keys and values have different data types
     * than the reducer's output keys and values. Therefore, you must 
     * call the setMapOutputKeyClass and setMapOutputValueClass 
     * methods.
     */
    /*
     * TODO implement
     */

    /*
     * Specify the job's output key and value classes.
     */
    /*
     * TODO implement
     */

    /*
     * Start the MapReduce job and wait for it to finish.
     * If it finishes successfully, return 0. If not, return 1.
     */
    boolean success = job.waitForCompletion(true);
    System.exit(success ? 0 : 1);
  }
}

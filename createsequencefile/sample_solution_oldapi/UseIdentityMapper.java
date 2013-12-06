import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.lib.IdentityMapper;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class UseIdentityMapper extends Configured implements Tool {

  @Override
  public int run(String[] args) throws Exception {

    String input, output;
    if(args.length == 2) {
      input = args[0];
      output = args[1];
    } else {
      input = "your-input-dir";
      output = "your-output-dir";
    }

    JobConf conf = new JobConf(getConf(), CreateSequenceFile.class);
    conf.setJobName(this.getClass().getName());

    FileInputFormat.setInputPaths(conf, new Path(input));
    FileOutputFormat.setOutputPath(conf, new Path(output));

    // No need to specify TextInputFormat, because it is the default
    // Set output format to SequenceFileOutputFormat
    conf.setOutputFormat(SequenceFileOutputFormat.class);

    // Set compression options: compress output, use block compression, 
    //   use Snappy compression
    SequenceFileOutputFormat.setCompressOutput(conf, true);
    SequenceFileOutputFormat.setOutputCompressionType(conf, CompressionType.BLOCK);
    conf.set("mapred.output.compression.codec","org.apache.hadoop.io.compress.SnappyCodec");

    conf.setMapperClass(IdentityMapper.class);

    // Set the number of reduce tasks to 0 for a map-only MapReduce job
    conf.setNumReduceTasks(0);

    JobClient.runJob(conf);
    return 0;
  }

  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new UseIdentityMapper(), args);
    System.exit(exitCode);
  }
}

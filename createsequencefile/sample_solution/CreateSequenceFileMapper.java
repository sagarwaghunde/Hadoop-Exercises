import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;

/** 
 * In this exercise, you convert a text file to a SequenceFile.
 * The content in the two files is identical. Therefore, this
 * mapper simply emits what was passed to it as input.
 */
public class CreateSequenceFileMapper extends
    Mapper<LongWritable, Text, LongWritable, Text> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    context.write(key, value);
  }
}

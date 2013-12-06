import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class AverageReducer extends MapReduceBase implements
    Reducer<Text, IntWritable, Text, DoubleWritable> {

  @Override
  public void reduce(Text key, Iterator<IntWritable> values,
      OutputCollector<Text, DoubleWritable> output, Reporter reporter)
      throws IOException {

    double sum = 0, count = 0;
    while (values.hasNext()) {
      IntWritable value = values.next();
      sum += value.get();
      count++;
    }
    if (count != 0d) {
      double result = sum / count;
      output.collect(key, new DoubleWritable(result));
    }
  }
}

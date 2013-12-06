import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class IndexMapper extends MapReduceBase implements
    Mapper<Text, Text, Text, Text> {

  @Override
  public void map(Text key, Text value, OutputCollector<Text, Text> output,
      Reporter reporter) throws IOException {

    FileSplit fileSplit = (FileSplit) reporter.getInputSplit();
    Path path = fileSplit.getPath();
    String wordPlace = path.getName() + "@" + key.toString();
    Text location = new Text(wordPlace);
    String s = value.toString().toLowerCase();
    for (String word : s.split("\\W+")) {
      if (word.length() > 0) {
        output.collect(new Text(word), location);
      }
    }
  }
}

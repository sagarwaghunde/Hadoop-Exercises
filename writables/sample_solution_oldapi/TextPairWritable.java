import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class TextPairWritable implements
    WritableComparable<TextPairWritable> {
  public Text left = new Text(), right = new Text();

  /* empty constructor required for serialization */
  public TextPairWritable() {

  }

  public TextPairWritable(String left, String right) {
    this.left.set(left);
    this.right.set(right);
  }

  public void write(DataOutput out) throws IOException {
    out.writeUTF(left.toString());
    out.writeUTF(right.toString());
  }

  public void readFields(DataInput in) throws IOException {
    String s = in.readUTF();
    left.set(s);
    s = in.readUTF();
    right.set(s);
  }

  public int compareTo(TextPairWritable other) {
    int ret = left.compareTo(other.left);
    if (ret == 0) {
      return right.compareTo(other.right);
    }
    return ret;
  }

  public String toString() {
    return "(" + left + "," + right + ")";
  }

  /*
   * Both equals and hashCode were implemented by Eclipse. Right click -> Source
   * -> Generate equals/hashCode
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TextPairWritable other = (TextPairWritable) obj;
    if (left == null) {
      if (other.left != null)
        return false;
    } else if (!left.equals(other.left))
      return false;
    if (right == null) {
      if (other.right != null)
        return false;
    } else if (!right.equals(other.right))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((left == null) ? 0 : left.hashCode());
    result = prime * result + ((right == null) ? 0 : right.hashCode());
    return result;
  }
}

/**
 * This class stores the information required for outputting the Huffman Code.
 *
 * @author Francis Lawlor
 */
public class Code {
  private String value;
  private String huffmanCode;

  Code(String value, String huffmanCode) {
    this.value = value;
    this.huffmanCode = huffmanCode;
  }

  public String getHuffmanCode() {
    return this.huffmanCode;
  }

  public String getValue() {
    return this.value;
  }
}

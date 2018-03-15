import java.util.*;

/**
 * Simple class for demonstrating use of the HuffmanEncoder.
 *
 * @author Francis Lawlor
 */
public class Main {
  public static void main(String[] args) {
		LinkedList<Double> input = new LinkedList<Double>();

		input.add(0.27);
    input.add(0.26);
    input.add(0.23);
    input.add(0.11);
    input.add(0.04);
    input.add(0.04);
    input.add(0.03);
    input.add(0.02);

		LinkedList<Code> codes = HuffmanEncoder.generateHuffmanCode(input, 3);

		System.out.println("P\tCode\tLength");

		Collections.sort(input);

		for (int i = 0; i < codes.size(); i++) {
			System.out.println(codes.get(i).getValue() + "\t" + codes.get(i).getHuffmanCode() + "\t" + codes.get(i).getHuffmanCode().length());
		}
  }
}

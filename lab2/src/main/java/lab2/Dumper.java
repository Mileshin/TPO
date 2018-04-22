package lab2;

import java.io.*;

public class Dumper {

	private final String FILE_HEADER = "X,cos,tg,sin,ln,log_2,log_3,log_5,leftFunc,rightFunc,Main";
  private final String SEP = ",";

	private String filename;

  private PrintWriter writer;

	public Dumper(String filename) {
		this.filename = filename;
    try {
      writer = new PrintWriter(filename, "UTF-8");
      writer.println(FILE_HEADER);
    }
    catch (IOException e) {
      System.out.println("Failed opening");
    }
	}

  public void writeLine (double x, double cos, double tg, double sin,
                          double ln, double log_2, double log_3, double log_5,
                          double left, double right, double main) {

    String line = x + SEP + cos + SEP + tg + SEP + sin + SEP +
                  ln + SEP + log_2 + SEP + log_3 + SEP + log_5 + SEP +
                  left + SEP + right + SEP + main;
    writer.println(line);

  }

  public void close() {
    writer.close();
  }
}

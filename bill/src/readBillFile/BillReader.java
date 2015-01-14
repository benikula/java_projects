package readBillFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BillReader {
	
	private String fileName;
	private String splitter;
	
	private BufferedReader br = null;
	private String line;
	private String[] lineParts;
	
	
	public BillReader(String fileName, String splitter) {
		this.fileName = fileName;
		this.splitter = splitter;
	}
	
	public void init() throws IOException {
		br = new BufferedReader(new FileReader(fileName));
	}
	
	@Override
	protected void finalize() throws Throwable {
		br.close();
	}

	public boolean isReady() {
		try {
			return br.ready();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void readLine() throws IOException {
		line = br.readLine();
		lineParts = line.split(splitter);
	}

	public int getQuantity() {
		return Integer.parseInt(lineParts[1]);
	}

	public double getValue() {
		return Double.parseDouble(lineParts[2]);
	}

	public String getCurrency() {
		return lineParts[3];
	}

}

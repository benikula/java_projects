package readBillFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BillFileReader implements BillReader {
	
	private String fileName;
	private String splitter;
	
	private BufferedReader br = null;
	private String line;
	private String[] lineParts;
	
	
	public BillFileReader(String fileName, String splitter) {
		this.fileName = fileName;
		this.splitter = splitter;
	}
	
	
	/* (non-Javadoc)
	 * @see readBillFile.BillReader#init()
	 */
	@Override
	public void init() throws IOException {
		br = new BufferedReader(new FileReader(fileName));
	}
	
	@Override
	protected void finalize() throws Throwable {
		br.close();
	}

	/* (non-Javadoc)
	 * @see readBillFile.BillReader#isReady()
	 */
	@Override
	public boolean isReady() {
		try {
			return br.ready();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see readBillFile.BillReader#readLine()
	 */
	@Override
	public void readLine() throws IOException {
		line = br.readLine();
		lineParts = line.split(splitter);
	}

	/* (non-Javadoc)
	 * @see readBillFile.BillReader#getQuantity()
	 */
	@Override
	public int getQuantity() {
		return Integer.parseInt(lineParts[1]);
	}

	/* (non-Javadoc)
	 * @see readBillFile.BillReader#getValue()
	 */
	@Override
	public double getValue() {
		return Double.parseDouble(lineParts[2]);
	}

	/* (non-Javadoc)
	 * @see readBillFile.BillReader#getCurrency()
	 */
	@Override
	public String getCurrency() {
		return lineParts[3];
	}

}

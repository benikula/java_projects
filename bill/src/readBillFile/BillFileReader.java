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
	private BillData data = new BillData();
	
	public BillFileReader(String fileName, String splitter) {
		this.fileName = fileName;
		this.splitter = splitter;
	}
	
	
	
	@Override
	public void init() throws IOException {
		br = new BufferedReader(new FileReader(fileName));
	}
	
	@Override
	protected void finalize() throws Throwable {
		br.close();
	}

		@Override
	public boolean isReady() {
		try {
			return br.ready();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
		
	public BillData getBillData() throws IOException {
		readLine();
		data.quantity = getQuantity();
		data.value = getValue();
		data.currency = getCurrency();
		
		return data;
	}
	

	private void readLine() throws IOException {
		line = br.readLine();
		lineParts = line.split(splitter);
	}

	private int getQuantity() {
		return Integer.parseInt(lineParts[1]);
	}

	private double getValue() {
		return Double.parseDouble(lineParts[2]);
	}

	private String getCurrency() {
		return lineParts[3];
	}

}

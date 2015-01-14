package readBillFile;

import java.io.IOException;

public interface BillReader {

	public abstract void init() throws IOException;

	public abstract boolean isReady();

	public abstract void readLine() throws IOException;

	public abstract int getQuantity();

	public abstract double getValue();

	public abstract String getCurrency();

}
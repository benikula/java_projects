package rater;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class FileRater implements Rater {

	private String fileName;
	private Map<String, Double> rates = new HashMap<String, Double>();
	
	public FileRater(String fileName) {
		this.fileName = fileName;
	}
	
	/* (non-Javadoc)
	 * @see rater.Rater#init()
	 */
	@Override
	public void init() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		try {
			while((line = br.readLine()) != null) {
			    String[] words = line.split("=");
			    rates.put(words[0],  Double.parseDouble(words[1]));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		br.close();
	}
	
	/* (non-Javadoc)
	 * @see rater.Rater#getRate(java.lang.String)
	 */
	@Override
	public double getRate(String currency) throws NoSuchElementException {
		Double d = rates.get(currency);
		
		if(null == d) {
			throw new NoSuchElementException("the currency is not found");
		}
		return d;
	}
	
//	public double getRate(String currency) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//		String line;
//		try {
//			while((line = br.readLine()) != null) {
//			    String[] words = line.split("=");
//
//			    if (words[0].equalsIgnoreCase(currency)) {
//			    	br.close();
//			    	
//			    	return Double.parseDouble(words[1]);
//			    }
//			}
//		} catch (NumberFormatException | IOException e) {
//			e.printStackTrace();
//		}
//		br.close();
//		return 1;
//	}
}

package calculator;

import java.io.IOException;

import rater.Rater;
import readBillFile.BillReader;

public class BillCalculator {
	
	private BillReader billReader;
	private Rater rater;
	private String currency;
	
	private int currQuantity;
	private double currValue;
	private String currCurrency;
	private double sum = 0; 
	
	
	public BillCalculator(BillReader billReader, Rater rater, String currency) {
		this.billReader = billReader;
		this.rater = rater;
		this.currency = currency ;
	}
	
	public double calculate() throws IOException {
		billReader.init();
		rater.init();
		while(billReader.isReady()) {
			try {
				getBillParams();
				addToSum();
			} catch (IOException e) {
				e.printStackTrace();
				sum += 0;
			}
		}
		
		adjustSumToCurrency();
		
		return sum;
	}
	
	private void getBillParams() throws IOException {
		billReader.readLine();
		currQuantity = billReader.getQuantity();
		currValue = billReader.getValue();
		currCurrency = billReader.getCurrency();
		
		System.out.println(currQuantity + ":" + currValue + ":" + currCurrency);
	}

	private void addToSum() {
		double currRate;
		
		currRate = rater.getRate(currCurrency);
		sum += (currRate * currQuantity * currValue);
		
	}

	private void adjustSumToCurrency() {
		if(sum == 0) {
			return;
		}
		double currRate;
		
		currRate = rater.getRate(currency);
		sum /= currRate;
		
	}
}

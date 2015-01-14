package calculator;

import java.io.IOException;

import rater.Rater;
import readBillFile.BillData;
import readBillFile.BillReader;

public class BillCalculator implements Calculator {
	
	private BillReader billReader;
	private Rater rater;
	private String currency;
	private double sum = 0; 
	private BillData data;
	
	public BillCalculator(BillReader billReader, Rater rater, String currency) {
		this.billReader = billReader;
		this.rater = rater;
		this.currency = currency ;
	}
	
	@Override
	public double calculate() throws IOException {
		billReader.init();
		rater.init();
		while(billReader.isReady()) {
			getBillParams();
			addToSum();
		}
		
		adjustSumToCurrency();
		
		return sum;
	}
	
	private void getBillParams() {
		try {
			data = billReader.getBillData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(data.quantity + ":" + data.value + ":" + data.currency);
	}

	private void addToSum() {
		double currRate;
		
		currRate = rater.getRate(data.currency);
		sum += (currRate * data.quantity * data.value);
		
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

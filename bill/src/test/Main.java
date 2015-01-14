package test;

import java.io.IOException;

import calculator.BillCalculator;
import rater.Rater;
import readBillFile.BillReader;


public class Main {

	public static void main(String[] args)  {
		BillReader b = new BillReader("bill.txt", ":");
		Rater r = new Rater("rates.txt");
		BillCalculator bc = new BillCalculator(b, r, "nis");
		try {
			System.out.println(bc.calculate());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

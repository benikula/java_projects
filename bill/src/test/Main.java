package test;

import java.io.IOException;

import calculator.BillCalculator;
import calculator.Calculator;
import rater.FileRater;
import rater.Rater;
import readBillFile.BillFileReader;
import readBillFile.BillReader;


public class Main {

	public static void main(String[] args)  {
		BillReader b = new BillFileReader("bill.txt", ":");
		Rater r = new FileRater("rates.txt");
		Calculator bc = new BillCalculator(b, r, "nis");
		try {
			System.out.println(bc.calculate());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

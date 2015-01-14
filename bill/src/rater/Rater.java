package rater;

import java.io.IOException;
import java.util.NoSuchElementException;

public interface Rater {

	public abstract void init() throws IOException;

	public abstract double getRate(String currency)
			throws NoSuchElementException;

}
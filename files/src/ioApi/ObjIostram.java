package ioApi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjIostram {

	String fileName;
	ObjectOutputStream oout;
	ObjectInputStream oin;
	
	public ObjIostram(String fileName) {
		this.fileName = fileName;
		
		try {
			oout = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			oin = new ObjectInputStream(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(Object o) {
		try {
			oout.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			oout.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object read() {
		Object read;
		try {
			read =  oin.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return read;
	}
	
	public void close() {
		try {
			oout.close();
			oin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

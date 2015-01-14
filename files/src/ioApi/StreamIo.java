package ioApi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamIo {
	
	String fileName;
	DataOutputStream out = null;
	DataInputStream in = null;

	public StreamIo(String fileName) {
		this.fileName = fileName;
		try {
			out = new DataOutputStream(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			in = new DataInputStream(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void writeString(String outString) {
		try {
			out.writeUTF(outString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeInt(int outInt) {
		try {
			out.writeInt(outInt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String readString() {
		String s = null;
		try {
			s = in.readUTF();
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		
		return s;
	}
	
	int readInt() {
		int i = 0;
		try {
			i = in.readInt();
		} catch (IOException e1) {
			e1.printStackTrace();
			return -1;
		}
		
		return i;
	}
	
	public void closeOutStram() {
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeInStram() {
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void writeByteArray(int size, String string) {
		
	}
}

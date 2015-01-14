package ioApi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestIo {

	public static void main(String[] args) {
		//lowLevelIo();
		//iostream();
		testSerialization();
	}
	
	private static void iostream() {
		StreamIo io = new StreamIo
				("C:\\Users\\ws1234\\Documents\\beni_java\\files\\test1.txt");
		
		io.writeString("vghsrjkbcfhjkls\n");
		io.writeInt(15123);
		io.writeByteArray(5, "AAAAA");
		io.closeOutStram();	
		
		

		System.out.println(io.readString());
		
		System.out.println(io.readInt());
		
		ObjIostram objIo = new ObjIostram
				("C:\\Users\\ws1234\\Documents\\beni_java\\files\\test1.txt");
		
		String s = "String Obgect\n";
		char c =  'e';
		objIo.write(s);
		objIo.write(c);
		System.out.println(objIo.read());
		System.out.println(objIo.read());
		
	}
		
	private static void testSerialization() {
		ObjIostram objIo = new ObjIostram
				("test3.txt");
		
		A a = new A();
		Employee emp = new Employee();
        emp.setId(100);
        emp.setName("MMMMM");
        emp.setSalary(5000);
        emp.setA(a);
        
		objIo.write(emp);
		System.out.println(emp);
		
		Employee empNew = (Employee)objIo.read();
		System.out.println(empNew);
		
	}
	
	private static void lowLevelIo() {
		File file1 = null;
		file1 = new File ("C:\\Users\\ws1234\\Documents\\beni_java\\files\\file1");
		
		try {
			file1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		FileWriter f1Write = null;
		try {
			f1Write = new FileWriter(file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			f1Write.write("Hello");
		} catch (IOException e) {
			e.printStackTrace();
		}			
		try {
			f1Write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		char[] buf = new char[64];
		FileReader f1Read = null;
		try {
			f1Read = new FileReader(file1);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			f1Read.read(buf);
			//System.out.println(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			f1Read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

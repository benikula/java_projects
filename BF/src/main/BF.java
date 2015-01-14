package main;
//import java.io.*;
import java.util.*;

public class BF 
{
	public static void main(String[] args) 
	{
//		String input = null;
		String str = "++++++++++[>+++++<-]>.";
		int len = str.length();
		//open up standard input
//	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		int n = 10;
		char[] arr = new char[n];
		int ptr = 0;
		
		//Stack stack = new Stack();
		
		while(i < len) 
		{
			char c = str.charAt(i++);
			System.out.println(c);
			switch (c) 
			{
				case '>':
					++ptr;
					break;
				case '<':
					--ptr;
					break;
				case '+':
					++arr[ptr];
					break;
				case '-':
					--arr[ptr];
					break;
				case '.':
					//ReadChar();
					printChar(arr[ptr]);
					break;
				case ',':
					arr[ptr] = getChar();
//					try
//					{
//						input = br.readLine();
//					}
//					catch (IOException ioe) 
//					{
//						System.out.println("IO error trying to read your name!");
//					    System.exit(1);
//					}
					break;
				case '[':
					if(arr[ptr] == 0)
					{
						int cntr = 0;
						while(']' != str.charAt(i) && cntr != 0)
						{
							if('[' == str.charAt(i))
							{
								++cntr;
							}
							else if(']' == str.charAt(i))
							{
								--cntr;
							}
							++i;
						}
					}
					
					break;
				case ']':
					if(arr[ptr] > 0)
					{
						int cntr = 0;
						while('[' != str.charAt(i) && cntr == 0)
						{
							if(']' == str.charAt(i))
							{
								++cntr;
							}
							else if('[' == str.charAt(i))
							{
								--cntr;
							}
							--i;
						}
					}
					break;
					
				default:
					break;
			}
		}
	}

	private static char getChar() {
		Scanner reader = new Scanner(System.in);
		char c = reader.next().charAt(0);
		reader.close();
		return c;
	}

	private static void printChar(char c) {
		System.out.println(c);
	}
}

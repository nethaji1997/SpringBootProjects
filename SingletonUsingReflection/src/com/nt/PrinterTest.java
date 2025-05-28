package com.nt;

import java.lang.reflect.Constructor;

public class PrinterTest {


	public static void main(String[] args) {
		try {
			Class c=Printer.class;

			Constructor[] cons = c.getDeclaredConstructors();

			//getting access to private constructor
			cons[0].setAccessible(true);

			Printer p1=(Printer)cons[0].newInstance();
			Printer p2=(Printer)cons[0].newInstance();
			Printer p3=Printer.getInstance();
			System.out.println(p1.hashCode()+" "+p2.hashCode()+" "+p3.hashCode());

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

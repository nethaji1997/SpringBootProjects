package com.nt;

public class PrinterTest {
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Printer p1 = Printer.getInstance();
		Printer p2 = Printer.getInstance();
		//Printer c1 = (Printer) p1.clone();
		System.out.println(p1.hashCode()+" "+p2.hashCode());
	}
}

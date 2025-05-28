package com.nt;

public class Printer {
	private static Printer INSTANCE;
	private static boolean isInstantiated=false;

	//protection from Reflection API
	private Printer() {
		if(isInstantiated)
			throw new RuntimeException("Object already created");
		else
			isInstantiated=true;
		System.out.println("0-param constructor");
	}
	
	private class PrinterInner
	{
		private static Printer INSTANCE=new Printer();
	}

	public static Printer getInstance()
	{
		return PrinterInner.INSTANCE;
	}

	//Protection from Cloning
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException("Cloning is restricted");
	}

	//Protection from Deserialization
	public Object readResolve()
	{
		return INSTANCE;
	}
}

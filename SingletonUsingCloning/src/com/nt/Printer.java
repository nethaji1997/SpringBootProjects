package com.nt;

public class Printer extends CommonsUtils {
	private static Printer INSTANCE;

	private Printer() {
		System.out.println("0-param constructor");
	}

	public static Printer getInstance()
	{
		if(INSTANCE==null)
			synchronized(Printer.class) {
				if(INSTANCE==null)
					INSTANCE=new Printer();

			}
		return INSTANCE;
	}
	
	//Solution to Object creation using Cloning
	@Override
	public Object clone() throws CloneNotSupportedException {
		 throw new CloneNotSupportedException("Cloning is restricted");
	}
}

package com.nt;

public class Printer extends CommonsUtils {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	//solution to object creation using Serialization
	public Object readResolve()
	{
		return INSTANCE;
	}
}

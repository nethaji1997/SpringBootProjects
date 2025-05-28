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

	public static Printer getInstance()
	{
		if(INSTANCE==null)
		{
			//Protection from Multi-Threading issue
			synchronized (Printer.class) 
			{
				if(INSTANCE==null)
				{
					INSTANCE=new Printer();
				}
			}
		}
		return INSTANCE;
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

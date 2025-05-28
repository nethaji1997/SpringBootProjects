package com.nt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PrinterTest {

	private static void doSerialization(Printer p1) {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("data.ser"))){
			oos.writeObject(p1); //serialization
			oos.flush();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Object serialization is done");
	}

	private static Printer doDeserialization() {
		Printer p=null;
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("data.ser")))
		{
			p=(Printer) ois.readObject(); //deserialization
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p; 
	}

	public static void main(String[] args) {
		Printer p1 = Printer.getInstance();
		doSerialization(p1);
		System.out.println("-------------------");
		Printer p2=doDeserialization();
		Printer p3=doDeserialization();
		System.out.println(p1.hashCode()+" "+p2.hashCode()+" "+p3.hashCode());
	}
	
}

package com.java.class09;

public class InheritanceTest04 {
	public static void main(String[] args) {
		Printer printer = new Samsung();
		printer.print();
		
		printer = new Canon();
		printer.print();
		
		printer = new HP();
		printer.print();
	}
}

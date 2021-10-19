package rmi.impl;

public class Printer {
	private String printerName;
	private PrinterState state = PrinterState.stop;
}



enum PrinterState{
	start,
	print,
	stop
}
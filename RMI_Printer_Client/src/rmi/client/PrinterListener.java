package rmi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JComboBox;

import rmi.IPrinter;

public class PrinterListener implements ActionListener{
	private String userName;
	JComboBox jobCbx;
	JComboBox printerCbx;
	int right;
	
	public PrinterListener(String userName, JComboBox jobCbx, JComboBox printerCbx, char c) {
		this.userName=userName;
		this.jobCbx=jobCbx;
		this.printerCbx=printerCbx;
		this.right=Integer.parseInt(String.valueOf(c));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(right==0) {
			System.out.println("print failed, you don't have right");
		}
		else if(right==1) {
			try {
				boolean result=false;
				IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
				result=printerServer.print(userName, (String)jobCbx.getSelectedItem(), (String)printerCbx.getSelectedItem());
				if (result==true) System.out.println("print successful");
				else if (result==false) System.out.println("print failed");
			} catch (Exception ex) {
				System.out.println("error£º"+ex.getMessage());
			}
		}
	}

}

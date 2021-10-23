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
	
	public PrinterListener(String userName, JComboBox jobCbx, JComboBox printerCbx) {
		this.userName=userName;
		this.jobCbx=jobCbx;
		this.printerCbx=printerCbx;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
			printerServer.print(userName, (String)jobCbx.getSelectedItem(), (String)printerCbx.getSelectedItem());
		} catch (Exception ex) {
			System.out.println("调用远程对象失败，原因是："+ex.getMessage());
		}
	}

}

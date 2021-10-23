package rmi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JComboBox;

import rmi.IPrinter;

public class StartListener implements ActionListener{
	String userName;
	JComboBox printerCbx;
	public StartListener(String userName, JComboBox printerCbx) {
		this.userName=userName;
		this.printerCbx=printerCbx;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
			printerServer.start(userName, (String)printerCbx.getSelectedItem());
		} catch (Exception ex) {
			System.out.println("调用远程对象失败，原因是："+ex.getMessage());
		}
	}
}

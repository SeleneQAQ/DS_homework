package rmi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JComboBox;

import rmi.IPrinter;

public class StateListener implements ActionListener{
	JComboBox printerCbx;
	String userName;
	public StateListener(String userName,JComboBox printerCbx) {
		this.userName=userName;
		this.printerCbx=printerCbx;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
			String s=printerServer.states(userName, (String)printerCbx.getSelectedItem());
			System.out.println("the state of "+(String)printerCbx.getSelectedItem()+" is "+s);
		} catch (Exception ex) {
			System.out.println("get server failed£º"+ex.getMessage());
		}
	}
}

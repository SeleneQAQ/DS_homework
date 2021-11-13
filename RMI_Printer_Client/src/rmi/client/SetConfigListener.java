package rmi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JComboBox;

import rmi.IPrinter;

public class SetConfigListener implements ActionListener {
	String userName;
	JComboBox printerCbx;
	String value;
	int right;

	SetConfigListener(String userName, JComboBox printerCbx, String value, char c) {
		this.userName = userName;
		this.printerCbx = printerCbx;
		this.value = value;
		this.right = Integer.parseInt(String.valueOf(c));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (right == 0) {
			System.out.println("setConfig failed, you don't have right");
		} else if (right == 1) {
			try {
				IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
				printerServer.setConfig(userName, (String) printerCbx.getSelectedItem(), value);
			} catch (Exception ex) {
				System.out.println("error£º" + ex.getMessage());
			}
		}
	}
}

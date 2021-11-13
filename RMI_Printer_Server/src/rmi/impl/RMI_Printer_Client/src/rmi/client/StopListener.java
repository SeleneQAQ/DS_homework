package rmi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JComboBox;

import rmi.IPrinter;

public class StopListener implements ActionListener {
	String userName;
	JComboBox printerCbx;
	int right;

	public StopListener(String userName, JComboBox printerCbx, char c) {
		this.userName = userName;
		this.printerCbx = printerCbx;
		this.right = Integer.parseInt(String.valueOf(c));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (right == 0) {
			System.out.println("stop failed, you don't have right");
		} else if (right == 1) {
			try {
				boolean result = true;
				IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
				result = printerServer.stop(userName, (String) printerCbx.getSelectedItem());
				if (result == true)
					System.out.println("stop successful");
				else if (result == false)
					System.out.println("stop failed");
			} catch (Exception ex) {
				System.out.println("error£º" + ex.getMessage());
			}
		}
	}
}

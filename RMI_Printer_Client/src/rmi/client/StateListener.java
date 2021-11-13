package rmi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JComboBox;

import rmi.IPrinter;

public class StateListener implements ActionListener {
	JComboBox printerCbx;
	String userName;
	int right;

	public StateListener(String userName, JComboBox printerCbx, char c) {
		this.userName = userName;
		this.printerCbx = printerCbx;
		this.right = Integer.parseInt(String.valueOf(c));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (right == 0) {
			System.out.println("check state failed, you don't have right");
		} else if (right == 1) {
			try {
				IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
				String s = printerServer.states(userName, (String) printerCbx.getSelectedItem());
				System.out.println("the state of " + (String) printerCbx.getSelectedItem() + " is " + s);
			} catch (Exception ex) {
				System.out.println("get server failed£º" + ex.getMessage());
			}
		}
	}
}

package rmi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import rmi.IPrinter;

public class TopQueueListener implements ActionListener {
	JFrame frame;
	String userName;
	JComboBox jobCbx;
	JComboBox printerCbx;
	int right;

	public TopQueueListener(JFrame frame, String userName, JComboBox jobCbx, JComboBox printerCbx, char c) {
		this.frame = frame;
		this.userName = userName;
		this.jobCbx = jobCbx;
		this.printerCbx = printerCbx;
		this.right = Integer.parseInt(String.valueOf(c));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (right == 0) {
			System.out.println("topqueue failed, you don't have right");
		} else if (right == 1) {
			try {
				boolean result = false;
				IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
				result = printerServer.topQueue(userName, (String) printerCbx.getSelectedItem(),
						(String) jobCbx.getSelectedItem());
				if (result == true)
					System.out.println("topqueue successful");
				else if (result == false)
					System.out.println("topqueue failed");
				frame.invalidate();
			} catch (Exception ex) {
				System.out.println("error£º" + ex.getMessage());
			}
		}
	}
}

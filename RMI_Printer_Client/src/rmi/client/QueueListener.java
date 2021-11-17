package rmi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import rmi.IPrinter;

public class QueueListener implements ActionListener {
	JFrame frame;
	String userName;
	JComboBox jobCbx;
	JComboBox printerCbx;
	int right;

	public QueueListener(JFrame frame, String userName, JComboBox jobCbx, JComboBox printerCbx, char c) {
		this.frame = frame;
		this.userName = userName;
		this.jobCbx = jobCbx;
		this.printerCbx = printerCbx;
		this.right = Integer.parseInt(String.valueOf(c));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (right == 0) {
			System.out.println("queue failed, you don't have right");
		} else if (right == 1) {
			try {
				IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
				String queue = printerServer.queue(userName, (String) printerCbx.getSelectedItem());
				String[] s = queue.split(",");
				jobCbx.removeAllItems();
				for (int i = 0; i < s.length; i++) {
					jobCbx.addItem(s[i]);
				}
				frame.invalidate();
				System.out.println("Check queue success!");
			} catch (Exception ex) {
				System.out.println("error£º" + ex.getMessage());
			}
		}
	}
}

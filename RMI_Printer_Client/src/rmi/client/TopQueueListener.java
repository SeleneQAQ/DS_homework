package rmi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import rmi.IPrinter;

public class TopQueueListener implements ActionListener{
	JFrame frame;
	String userName;
	JComboBox jobCbx;
	JComboBox printerCbx;
	public TopQueueListener(JFrame frame, String userName, JComboBox jobCbx, JComboBox printerCbx) {
		this.frame=frame;
		this.userName=userName;
		this.jobCbx=jobCbx;
		this.printerCbx=printerCbx;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
			printerServer.topQueue(userName,(String)printerCbx.getSelectedItem() , (String)jobCbx.getSelectedItem());
			frame.invalidate();
		} catch (Exception ex) {
			System.out.println("调用远程对象失败，原因是："+ex.getMessage());
		}
	}
}

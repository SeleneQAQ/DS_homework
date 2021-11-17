package rmi.client;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rmi.IPrinter;

public class MainFrame {

	public void init(String userName) {
		JFrame frame = new JFrame("Login");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(userName, frame, panel);
		frame.setVisible(true);
	}

	private static void placeComponents(String userName, JFrame frame, JPanel panel) {
		panel.setLayout(new GridLayout(0, 2));
		String accessControl = "";
		try {
			IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
			accessControl = printerServer.accessControl(userName);
		} catch (Exception ex) {
			System.out.println("error£º" + ex.getMessage());
		}
		if (accessControl.length() == 9) {
			JLabel printerLab = new JLabel("Printer£º");
			JComboBox printerCbx = new JComboBox();
			JLabel jobLab = new JLabel("Job£º");
			JComboBox jobCbx = new JComboBox();
			JButton printBtn = new JButton("Print");
			JButton queueBtn = new JButton("Queue");
			JButton topQueueBtn = new JButton("TopQueue");
			JButton startBtn = new JButton("Start");
			JButton stopBtn = new JButton("Stop");
			JButton restartBtn = new JButton("Restart");
			JButton statesBtn = new JButton("Status");
			JButton readConfigBtn = new JButton("readConfig");
			JButton setConfigBtn = new JButton("setConfig");
			JButton ExitBtn = new JButton("Exit");
			panel.add(printerLab);
			printerCbx.addItem("printer1");
			printerCbx.addItem("printer2");
			panel.add(printerCbx);
			panel.add(jobLab);
			jobCbx.addItem("file_1");
			panel.add(jobCbx);
			printBtn.addActionListener(new PrinterListener(userName, jobCbx, printerCbx,accessControl.charAt(0)));
			panel.add(printBtn);
			queueBtn.addActionListener(new QueueListener(frame, userName, jobCbx, printerCbx,accessControl.charAt(1)));
			panel.add(queueBtn);
			topQueueBtn.addActionListener(new TopQueueListener(frame, userName, jobCbx, printerCbx,accessControl.charAt(2)));
			panel.add(topQueueBtn);
			startBtn.addActionListener(new StartListener(userName, printerCbx,accessControl.charAt(3)));
			panel.add(startBtn);
			stopBtn.addActionListener(new StopListener(userName, printerCbx,accessControl.charAt(4)));
			panel.add(stopBtn);
			restartBtn.addActionListener(new RestartListener(userName, printerCbx,accessControl.charAt(5)));
			panel.add(restartBtn);
			statesBtn.addActionListener(new StateListener(userName, printerCbx,accessControl.charAt(6)));
			panel.add(statesBtn);
			readConfigBtn.addActionListener(new ReadConfigListener(userName, printerCbx,accessControl.charAt(7)));
			panel.add(readConfigBtn);
			setConfigBtn.addActionListener(new SetConfigListener(userName, printerCbx, "red color",accessControl.charAt(8)));
			panel.add(setConfigBtn);
			ExitBtn.addActionListener(new ExitListener(frame));
			panel.add(ExitBtn);
		}
	}

}

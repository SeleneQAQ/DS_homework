package rmi.client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import rmi.IPrinter;

public class LoginListener implements ActionListener {
	private JTextField text_name;
	private JPasswordField text_password;
	private JFrame login;

	public LoginListener(JFrame login,JTextField text_name,JPasswordField text_password) {
		this.login = login;
		this.text_name = text_name;
		this.text_password = text_password;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
			if(printerServer.isCustomer(text_name.getText(), text_password.getText())==true) {
				System.out.println("login success��");
				login.setVisible(false);
				MainFrame mf=new MainFrame();
				mf.init(text_name.getText());
			}
			else {
				System.out.println("login failed��");
			}
		}catch(Exception ex) {
			System.out.println("error��"+ex.getMessage());
		}
	}
}
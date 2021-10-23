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
			IPrinter example = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
			if(example.isCustomer(text_name.getText(), text_password.getText())==true) {
				System.out.println("登录成功！");
				login.setVisible(false);
				MainFrame mf=new MainFrame();
				mf.init(text_name.getText());
			}
			else {
				System.out.println("登录失败！");
			}
		}catch(Exception ex) {
			System.out.println("调用远程对象失败，原因是："+ex.getMessage());
		}
	}
}
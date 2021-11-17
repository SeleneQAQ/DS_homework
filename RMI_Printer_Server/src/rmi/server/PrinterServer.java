package rmi.server;
import java.rmi.registry.LocateRegistry;

import rmi.IPrinter;
import rmi.impl.PrinterImpl;

//�������ˣ��������ΪѧУͼ��ݴ�ӡ������������Ҫ����֤�û�id����һ�£�����Ҫ�����û���Ϣ����ʹ洢����
public class PrinterServer {
	public static void main(String[] args) {
		//ȷ���û�id������һ�º��ṩ��Ӧ����
		
		//�÷���Ϊʾ����������������ɾ����ע�͡�
		try {
			IPrinter server =new PrinterImpl();
			//������ip�ϴ������ṩһ����ע���ʵ������������ָ�����˿ڡ�������
			//һ���˿�һ��ֻ������һ��ʵ��ռ�ã������1ռ����8888�˿ڣ���ô�������̽��޷���ʹ��8888�˿�
			LocateRegistry.createRegistry(8888);
			java.rmi.Naming.rebind("rmi://127.0.0.1:8888/server", server);
			System.out.println("server is ready");
		}catch(Exception e) {
			System.out.println("server is not ready��"+e.getMessage());
		}
	}
}

package rmi;
import java.rmi.Remote;

//����Զ�̽ӿ�,Server����Ҫ�ķ�����Ӹýӿڵ��ò���
public interface IPrinter extends Remote{
	
	//1.��ӡ��������"printer"��ӡ���ϴ�ӡ"filename"�ļ�
	public boolean print(String userName, String filename, String printer) throws java.rmi.RemoteException;
	
	//2.��ʾĿǰ"printer"�Ĵ�ӡ���У���Ҫ��ʾ"job number"��"filename"
	public String queue(String userName, String printer) throws java.rmi.RemoteException;
	
	//3.��"job"���������"printer"�Ĵ�ӡ���ж���
	public boolean topQueue(String userName, String printer, String job) throws java.rmi.RemoteException;
	
	//4.������ӡ������
	public boolean start(String userName,String printer) throws java.rmi.RemoteException;
	
	//5.�رմ�ӡ������
	public boolean stop(String userName,String printer) throws java.rmi.RemoteException;
	
	//6.������ӡ��������մ�ӡ������
	public boolean restart(String userName,String printer) throws java.rmi.RemoteException;
	
	//7.��ʾ��ӡ����״̬
	public String states(String userName, String printer) throws java.rmi.RemoteException;
	
	//8.��ȡ�û�������id���û���
	public void readConfig(String userName,String parameter) throws java.rmi.RemoteException;
	
	//9.�����û��������û��������룺
	public void setConfig(String userName,String parameter, String value) throws java.rmi.RemoteException;
	
	//�÷���Ϊʾ��������������ע�͵�
	public void example(String example) throws  java.rmi.RemoteException;
	
	//У���û���������
	public boolean isCustomer(String userName,String userPassword) throws  java.rmi.RemoteException;
	
	public String accessControl(String userName) throws  java.rmi.RemoteException;
}

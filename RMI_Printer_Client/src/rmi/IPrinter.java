package rmi;
import java.rmi.Remote;

//����Զ�̽ӿ�,Server����Ҫ�ķ�����Ӹýӿڵ��ò���
public interface IPrinter extends Remote{
	
	//��ӡ��������"printer"��ӡ���ϴ�ӡ"filename"�ļ�
	public boolean print(String userName, String filename, String printer) throws java.rmi.RemoteException;
	
	//��ʾĿǰ"printer"�Ĵ�ӡ���У���Ҫ��ʾ"job number"��"filename"
	public String queue(String userName,String printer) throws java.rmi.RemoteException;
	
	//��"job"���������"printer"�Ĵ�ӡ���ж���
	public boolean topQueue(String userName,String printer, String job) throws java.rmi.RemoteException;
	
	//������ӡ������
	public boolean start(String userName,String printer) throws java.rmi.RemoteException;
	
	//�رմ�ӡ������
	public boolean stop(String userName,String printer) throws java.rmi.RemoteException;
	
	//������ӡ��������մ�ӡ������
	public boolean restart(String userName,String printer) throws java.rmi.RemoteException;
	
	//��ʾ��ӡ����״̬
	public String states(String userName,String printer) throws java.rmi.RemoteException;
	
	//��ȡ�û�������id���û���
	public void readConfig(String userName,String parameter) throws java.rmi.RemoteException;
	
	//�����û��������û��������룺
	public void setConfig(String userName,String parameter, String value) throws java.rmi.RemoteException;
	
	//�÷���Ϊʾ��������������ע�͵�
	public void example(String example) throws  java.rmi.RemoteException;
	
	//У���û���������
	public boolean isCustomer(String userName,String userPassword) throws  java.rmi.RemoteException;
	
	public String accessControl(String userName) throws  java.rmi.RemoteException;
}

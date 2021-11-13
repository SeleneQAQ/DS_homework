package rmi;
import java.rmi.Remote;

//定义远程接口,Server所需要的服务均从该接口调用参数
public interface IPrinter extends Remote{
	
	//1.打印操作，在"printer"打印机上打印"filename"文件
	public boolean print(String userName, String filename, String printer) throws java.rmi.RemoteException;
	
	//2.显示目前"printer"的打印队列，需要显示"job number"和"filename"
	public String queue(String userName, String printer) throws java.rmi.RemoteException;
	
	//3.将"job"任务放置在"printer"的打印队列顶端
	public boolean topQueue(String userName, String printer, String job) throws java.rmi.RemoteException;
	
	//4.开启打印机服务
	public boolean start(String userName,String printer) throws java.rmi.RemoteException;
	
	//5.关闭打印机服务
	public boolean stop(String userName,String printer) throws java.rmi.RemoteException;
	
	//6.重启打印机服务，清空打印机队列
	public boolean restart(String userName,String printer) throws java.rmi.RemoteException;
	
	//7.显示打印机的状态
	public String states(String userName, String printer) throws java.rmi.RemoteException;
	
	//8.读取用户参数：id，用户名
	public void readConfig(String userName,String parameter) throws java.rmi.RemoteException;
	
	//9.设置用户参数：用户名，密码：
	public void setConfig(String userName,String parameter, String value) throws java.rmi.RemoteException;
	
	//该方法为示例方法，理解后请注释掉
	public void example(String example) throws  java.rmi.RemoteException;
	
	//校验用户名与密码
	public boolean isCustomer(String userName,String userPassword) throws  java.rmi.RemoteException;
	
	public String accessControl(String userName) throws  java.rmi.RemoteException;
}

package rmi;
import java.rmi.Remote;

//定义远程接口,Server所需要的服务均从该接口调用参数
public interface IPrinter extends Remote{
	
	//打印操作，在"printer"打印机上打印"filename"文件
	public void print(String filename, String printer) throws java.rmi.RemoteException;
	
	//显示目前"printer"的打印队列，需要显示"job number"和"filename"
	public void queue(String printer) throws java.rmi.RemoteException;
	
	//将"job"任务放置在"printer"的打印队列顶端
	public void topQueue(String printer, int job) throws java.rmi.RemoteException;
	
	//开启打印机服务
	public void start() throws java.rmi.RemoteException;
	
	//关闭打印机服务
	public void stop() throws java.rmi.RemoteException;
	
	//重启打印机服务，清空打印机队列
	public void restrat() throws java.rmi.RemoteException;
	
	//显示打印机的状态
	public void status(String printer) throws java.rmi.RemoteException;
	
	//读取用户参数：id，用户名
	public void readConfig(String parameter) throws java.rmi.RemoteException;
	
	//设置用户参数：用户名，密码：
	public void setConfig(String parameter, String value) throws java.rmi.RemoteException;
	
	//该方法为示例方法，理解后请注释掉
	public void example(String example) throws  java.rmi.RemoteException;
	
	//校验用户名与密码
	public void isCustomer(String userName,String userPassword) throws  java.rmi.RemoteException;
	
}

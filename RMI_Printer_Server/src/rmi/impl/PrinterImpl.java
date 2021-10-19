package rmi.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import rmi.IPrinter;

//对调用接口的方法的实现
public class PrinterImpl extends UnicastRemoteObject implements IPrinter{
	public PrinterImpl() throws RemoteException {
	    super();
	  }
	
	//打印操作，在"printer"打印机上打印"filename"文件
	@Override
	public void print(String fileName, String printer) throws RemoteException{
		String fileContent;
		String filePath="file/"+fileName+".txt";
		FileInputStream fin;
		try {
			fin = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            System.out.println(printer+" now start to print."+fileName);
            while ((fileContent=buffReader.readLine()) != null){
            	System.out.println(fileContent);
            	}
            System.out.println(printer+" finished.");
            }catch(Exception e) {
            	System.out.println(e);
		}
		
	}
		
	//显示目前"printer"的打印队列，需要显示"job number"和"filename"
	@Override
	public void queue(String printer) throws RemoteException{
		
	}
		
	//将"job"任务放置在"printer"的打印队列顶端
	@Override
	public void topQueue(String printer, int job) throws RemoteException{
		
	}
		
	//开启打印机服务
	@Override
	public void start() throws RemoteException{
		
	}
		
	//关闭打印机服务
	@Override
	public void stop() throws RemoteException{
		
	}
		
	//重启打印机服务，清空打印机队列
	@Override
	public void restrat() throws RemoteException{
		
	}
		
	//显示打印机的状态
	@Override
	public void status(String printer) throws RemoteException{
		
	}
		
	//读取用户参数
	@Override
	public void readConfig(String parameter) throws RemoteException{
		
	}
		
	//设置用户参数
	@Override
	public void setConfig(String parameter, String value) throws RemoteException{
		
	}
	
	//该方法为示例方法，理解后请注释掉
	@Override
	public void example(String example) throws RemoteException {
		 System.out.println(example+"调用了示例方法,该方法是在Impl里实现的。");
		 return;
	}
	
	//校验用户名与密码
	@Override
	public boolean isCustomer(String userName, String userPassword) throws RemoteException {
		boolean isFound = false;
	    String record_userName;
	    String record_userPassword;
	    String filePath = "login.txt";
        FileInputStream fin;
        //一行一行读取用户名与密码，当用户名密码匹配时返回true，否则返回false
		try {
			fin = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
	        while ((record_userName=buffReader.readLine()) != null){
	        	if (userName.equals(record_userName)) {
	            	record_userPassword=buffReader.readLine();
	            	if(record_userPassword.equals(record_userPassword)) {
	            		isFound=true;
	            		}
	            	}
	        	}
	        buffReader.close();
	        buffReader = null;
	        }catch(Exception e){
	        	System.out.println(e);
	        	}
		if(isFound==true) {
			 System.out.println(userName+"身份校验通过.");
		}
		else {
			 System.out.println("不存在匹配的账号密码.");
		}
		return isFound;
	}
}

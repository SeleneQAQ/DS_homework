package rmi.server;
import java.rmi.registry.LocateRegistry;

import rmi.IPrinter;
import rmi.impl.PrinterImpl;

//服务器端，可以理解为学校图书馆打印器服务器，需要在验证用户id密码一致，并需要考虑用户信息传输和存储问题
public class PrinterServer {
	public static void main(String[] args) {
		//确认用户id，密码一致后提供相应服务
		
		//该方法为示例方法，请在理解后删除或注释。
		try {
			IPrinter server =new PrinterImpl();
			//在主机ip上创建并提供一个“注册表”实例，用来接收指明“端口”的请求
			//一个端口一次只能允许一个实例占用，如进程1占用了8888端口，那么其它进程将无法再使用8888端口
			LocateRegistry.createRegistry(8888);
			java.rmi.Naming.rebind("rmi://127.0.0.1:8888/server", server);
			System.out.println("server is ready");
		}catch(Exception e) {
			System.out.println("server is not ready："+e.getMessage());
		}
	}
}

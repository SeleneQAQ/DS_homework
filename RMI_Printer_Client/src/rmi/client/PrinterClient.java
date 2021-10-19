package rmi.client;
import java.rmi.*;
import rmi.IPrinter;

//客户端，可以理解为学校图书馆打印机终端，需要考虑用户密码传输的安全问题
public class PrinterClient {
	public static void main(String[] args) {
		//输入用户名密码
		//服务器校验用户名密码正确后开启打印服务
		//用户选择自己所需要的服务：
		//打印文件
		//显示文件队列
		//指定文件置顶
		//显示打印机状态
		//读取用户参数：id，用户名
		//设置用户参数：用户名，密码
		//退出
		//重启
		
		//该方法为示例方法，请在理解后删除或注释
		try {
			IPrinter example = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/example");
			example.example("Pinter1");
			example.isCustomer("123", "1234");
			example.print("file_1", "printer1");
			System.out.println("调用成功！");
		}catch(Exception e) {
			System.out.println("调用远程对象失败，原因是："+e.getMessage());
		}
	}
}

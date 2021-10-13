package rmi;
import java.rmi.Remote;

//定义远程接口
public interface IText extends Remote{

	 public String sayText(String name) throws java.rmi.RemoteException;
	 
}

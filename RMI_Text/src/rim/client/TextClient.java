package rim.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import rmi.IText;


public class TextClient {

  public static void main(String[] args) {

    try {
      
      /*
      返回指定名字的远程 对象的一个引用
       */
      IText hello = (IText) Naming.lookup("rmi://127.0.0.1:8888/hello");
      System.out.println("调用远程对象，开始测试："+hello.sayText("韩梅梅"));
    } catch (Exception e) {
      System.out.println("调用远程对象失败，原因是："+e.getMessage());
    }
  }
}

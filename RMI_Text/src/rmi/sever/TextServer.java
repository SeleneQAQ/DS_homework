package rmi.sever;

import java.rmi.registry.LocateRegistry;
import rmi.IText;
import rmi.impl.TextImpl;

public class TextServer {
  public static void main(String[] args) {
    try {
      IText hello = new TextImpl();
      /*
      在主机ip上创建并提供一个“注册表”实例，用来接收指明“端口”的请求
       */
      LocateRegistry.createRegistry(8888);

      /*
      给一个远程对象重新绑定一个“给定”的名字
      @param name:必须为一个URI形式
      这个方法会覆盖之前已经绑定的名字
       */
      java.rmi.Naming.rebind("rmi://127.0.0.1:8888/hello", hello);
      System.out.print("Ready");
    } catch (Exception e) {
      System.out.println("提供远程对象失败，原因是："+e.getMessage());
    }
  }
}

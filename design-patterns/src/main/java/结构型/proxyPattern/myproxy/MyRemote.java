package 结构型.proxyPattern.myproxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {  //接口必须扩展java.rmi.Remote

    //远程方法的变量和返回值，必须属于原语类型或Serializable类型。
    public String sayHello() throws RemoteException;////所有的远程方法都必须声明 RemoteException

}

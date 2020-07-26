package 结构型.proxyPattern.myproxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    //必须重载父类（UnicastRemoteObject）构造器抛出RemoteException, 否则编译不过
    // （当类被实例化的时候，超类的构造器总是会被调用。如果超类抛出异常，子类也必须抛出）
    protected MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello() {
        return "Server says, 'Hey'";
    }

    public static void main(String[] args) {
        String host = "localhost";
        host = "172.16.11.104";
        try {
            MyRemote service = new MyRemoteImpl();
//            MyRemote stub = (MyRemote) UnicastRemoteObject.exportObject(service, 0);
            //Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(1098);
//            registry.bind("Hello", stub);
//            System.out.println("Server ready");
//            System.setProperty("java.rmi.server.hostname",host);

            Naming.rebind("rmi://" + host + ":1098/RemoteHello", service);
        } catch (Exception ex) {
            System.out.println("Server exception:" + ex.toString());
            ex.printStackTrace();
        }
    }
}

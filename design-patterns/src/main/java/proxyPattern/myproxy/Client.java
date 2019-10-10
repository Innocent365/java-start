package proxyPattern.myproxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        host = "172.16.11.104";
        try {
//            Registry registry = LocateRegistry.getRegistry(host);
//            MyRemote stub = (MyRemote) registry.lookup("RemoteHello");

            MyRemote stub = (MyRemote) Naming.lookup("rmi://" + host + ":1098/RemoteHello");
            String response = stub.sayHello();
            System.out.println("Response:" + response);
        } catch (RemoteException ex) {
            System.out.println("Run exception: " + ex.toString());
            ex.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

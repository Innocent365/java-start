package 结构型.proxyPattern.machine;



import org.junit.Test;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class GumballMachineTest {
    public static void main(String[] args) {

        Global.list.forEach(p -> {
            new GumballMachineTest().TestServer1(p.getKey(), p.getValue());
        });
    }

    @Test
    public void outputRandom() {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(10)); //0-9
        }
    }

    public void TestServer1(String location, Integer count) {
        GumballMachineRemote machine;


        //if(args.length < 2){
        //    //利用命令行的方式传入位置和初始的糖果数
        //    System.out.println("GumballMachine <name> <inventory>");
        //    System.exit(1);
        //}
//        location = "localhost";
        try {
            Registry registry = LocateRegistry.createRegistry(count);

            machine = new GumballMachine(location, count);
            Naming.rebind("rmi://" + location + ":" + count + "/gumballmachine", machine);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

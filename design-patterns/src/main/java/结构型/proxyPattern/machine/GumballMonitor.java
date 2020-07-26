package 结构型.proxyPattern.machine;

import java.rmi.RemoteException;

public class GumballMonitor {
    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("机器所在位置：" + machine.getLocation());
            System.out.println("当前剩余糖果数：" + machine.getCount() + "个");
            System.out.println("机器当前状态：" + machine.getState());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}

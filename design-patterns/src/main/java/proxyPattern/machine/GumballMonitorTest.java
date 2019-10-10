package proxyPattern.machine;

import javafx.util.Pair;

import java.rmi.Naming;

public class GumballMonitorTest {
    public static void main(String[] args) {

        String form = "rmi://%s:%d/gumballmachine";
        GumballMonitor[] monitors = new GumballMonitor[Global.list.size()];

        for (int i = 0; i < Global.list.size(); i++) {
            try {
                Pair pair = Global.list.get(i);
//                if(i==0) location[i] = "rmi://localhost:1092/gumballmachine";
                String str = String.format(form, pair.getKey(), pair.getValue());
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(str);
                monitors[i] = new GumballMonitor(machine);
                System.out.println(monitors[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < monitors.length; i++) {
            monitors[i].report();
        }
    }
}

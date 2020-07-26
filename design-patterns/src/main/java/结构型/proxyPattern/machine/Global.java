package 结构型.proxyPattern.machine;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Global {

    static List<Pair<String, Integer>> list;

    static {
        list = new ArrayList<>();
        list.add(new Pair<>("localhost", 1000));
        list.add(new Pair<>("localhost", 1500));
        list.add(new Pair<>("localhost", 2000));
    }

}

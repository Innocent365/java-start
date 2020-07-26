package snippet;


import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.util.StringTokenizer;

/**
 * @author hw
 * @version on 2019/12/14
 */
public class TestGetProperty {

    public static void main(String[] args) {
        System.out.println(System.getProperty("catalina.home"));

        System.out.println(System.getProperty("user.dir"));

        StringTokenizer tokenizer = new StringTokenizer("D:\\Users\\hw\\IdeaProjects\\tc7.0.42\\output\\build/lib,D:\\Users\\hw\\IdeaProjects\\tc7.0.42\\output\\build/lib/*.jar,D:\\Users\\hw\\IdeaProjects\\tc7.0.42\\output\\build/lib,D:\\Users\\hw\\IdeaProjects\\tc7.0.42\\output\\build/lib/*.jar", ",");

        try {
            ObjectName objectName = new ObjectName("Catalina:type=ServerClassLoader,name=_0_beans");
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }

        System.out.println( System.nanoTime());

        System.out.println(new TestGetProperty().returnSHit());
    }

    public int returnSHit(){
        return (2);
    }
}

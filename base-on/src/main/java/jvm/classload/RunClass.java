package jvm.classload;

/**
 * @author hw
 * @version on 2020/2/11
 */
public class RunClass {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        MyClassLoader loader1 = new MyClassLoader("loader1", "D:/Users/hw/IdeaProjects/java-start/base-on/target/classes/jvm.classload/a/");

        MyClassLoader loader2 = new MyClassLoader(loader1, "loader2", "D:/Users/hw/IdeaProjects/java-start/base-on/target/classes/jvm.classload/b/");

        MyClassLoader loader3 = new MyClassLoader(null, "loader3", "D:/Users/hw/IdeaProjects/java-start/base-on/target/classes/");

        Class c = loader3.loadClass("jvm.classload.c.Demo");

        c.newInstance();

    }

}

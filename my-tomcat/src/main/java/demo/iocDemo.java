package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

/**
 * @author hw
 * @version on 2019/2/21
 */
public class iocDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        InputStream ips = new FileInputStream("conf.properties");   //读取硬盘中的文件. 实际应该放在src同级才能读到
        Properties properties = new Properties();
        properties.load(ips);
        String className = properties.getProperty("className");
        Collection collection = (Collection) Class.forName(className).newInstance();
        collection.add("动脑学院0");
        collection.add("动脑学院1");
        collection.add("动脑学院2");
        collection.add("动脑学院3");

        System.out.println(className);
    }
}

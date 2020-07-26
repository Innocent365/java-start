package jvm.classload;

import java.io.*;

/**
 * @author hw
 * @version on 2020/2/11
 */
public class MyClassLoader extends ClassLoader {

    private String name;

    private String path;


    public MyClassLoader(String name, String path) {
        super();
        this.name = name;
        this.path = path;
    }

    public MyClassLoader(ClassLoader parent, String name, String path) {
        super(parent);
        this.name = name;
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = readFile2ByteArray(name);
        return this.defineClass(name, b, 0, b.length);
    }

    /**
     * 将包名转换成全部路径名，比如
     *
     * temp.a.com.dn.Demo -> D:/temp/a/com/dn/Demo.class
     *
     * @param name
     * @return
     */
    private byte[] readFile2ByteArray(String name) {
        InputStream is = null;
        byte[] rtnData = null;

        name = name.replaceAll("\\.", "/");

        String filePath = this.path + name + ".class";
        File file = new File(filePath);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try{
            is = new FileInputStream(file);
            int tmp = 0;
            while ((tmp = is.read()) != -1){
                os.write(tmp);
            }
            rtnData = os.toByteArray();

            return rtnData;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null){
                try{
                    is.close();
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
            if(os != null){
                try{
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new byte[0];
    }


}

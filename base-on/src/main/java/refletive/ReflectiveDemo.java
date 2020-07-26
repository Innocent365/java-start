package refletive;


import model.Student;
import org.junit.Test;

import java.lang.reflect.*;

public class ReflectiveDemo {


    @Test//1.获取Class对象
    public void getClassObj() {
        try {
            //1.Class类的forName静态方法
            Class x = Class.forName("java.lang.String");//先从java虚拟机中找这个类模板，找不到会调用类加载器去加载这个类
            System.out.println(x);

            //2.直接获取某一个对象的class
            Class<?> kclass = String.class;
            System.out.println(kclass);

            //3.调用某个对象的getClass()方法
            Class<?> lass = new String("123").getClass();
            System.out.println(lass);

            System.out.println(x==kclass);      //true
            System.out.println(x==lass);        //true 字节码只会存在一份

            //Integer和int
            System.out.println(Integer.class==int.class);   //false, Integer是int的包装类，但不是同一个类
            System.out.println(Integer.TYPE == int.class);  //true, 通过 Integer.type这种方式把简单类型给抽取出来

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test//2.判断是否为某个类的实例
    public void testIsInstance() {
        Object obj = Integer.valueOf("10");
        System.out.println(obj instanceof Integer); //注意是instanceof关键字，不是方法
    }


    @Test//3.获取实例
    public void getInstance(){
        Class clazz = String.class;
        try {
            //1.Class对象的newInstance()方法
            Object str = clazz.newInstance();

            //2.根据构造器创建实例
            Constructor constructor = clazz.getConstructor(String.class);   //获取String类带一个String参数的构造器
            Object obj = constructor.newInstance("23333");
            System.out.println(obj);

        } catch (InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Test//4.1 获取类的成员变量（字段）信息
    public void getFields() throws NoSuchFieldException {
        Subject subject = new RealSubject();
        Subject demo = new Proxy(subject);

        Class clazz = Subject.class;
        Field[] fileds = clazz.getFields();
        Field[] declaredFileds = clazz.getDeclaredFields();
        Field filed = clazz.getField("add");
        Field declaredField = clazz.getDeclaredField("add");    //所有已声明的成员变量。但不能得到其父类的成员变量
    }

    @Test//4.2 获取方法
    public void getMethods() throws NoSuchMethodException {
        Class clazz = String.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();  //返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。

        Method[] methods = clazz.getMethods(); //getMethods()方法返回某个类的所有公用（public）方法，包括其继承类的公用方法。

        Method method = clazz.getMethod("wait");//其中第一个参数为方法名称，后面的参数为方法的参数对应Class的对象
        //public Method getMethod(String name, Class<?>... parameterTypes)
        System.out.println(method);
    }

    @Test//5.获取构造器信息
    public void getConstructorMethod() throws NoSuchMethodException {
        Class clazz = String.class;
        Constructor constructor = clazz.getConstructor(String.class);   //获取String类带一个String参数的构造器

        //Constructor[] getConstructors() -- 获得类的所有公共构造函数
        //Constructor[] getDeclaredConstructors(); //-- 获得类的所有构造函数(与接入级别无关)
        //Constructor getConstructor(Class[] params) -- 获得使用特殊的参数类型的公共构造函数，
        //Constructor getDeclaredConstructor(Class[] params) -- 获得使用特定参数类型的构造函数(与接入级别无关)

        try {
            Object obj = constructor.newInstance(String.class.getTypeName());
            //Constructor类有一个newInstance方法可以创建一个对象实例,
            //      public T newInstance(Object ... initargs)
            //此方法可以根据传入的参数来调用对应的Constructor创建对象实例~
            System.out.println(obj);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test//6.调用方法
    public void invoke() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //public Object invoke(Object obj, Object... args)
        //        throws IllegalAccessException, IllegalArgumentException,
        //           InvocationTargetException

        Class<?> klass = methodClass.class;
        //创建methodClass的实例
        Object obj = klass.newInstance();
        //获取methodClass类的add方法
        Method method = klass.getMethod("add", int.class, int.class);
        //调用method对应的方法 => add(1,4)
        Object result = method.invoke(obj,1,4);
        System.out.println(result);
    }

    @Test//7.利用反射创建数组
    public void createArray() throws ClassNotFoundException {
        Class<?> clz = Class.forName("java.lang.String");
        Object array = Array.newInstance(clz, 25);
        Array.set(array, 0, "hello");
        Array.set(array, 1, "Java");
        Array.set(array, 2, "Scala");
        System.out.println(Array.get(array,2));
    }

    @Test//8.获取对象指定字段的值
    public void getValueWithField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        student.setAge(24);
        student.setGender(false);
        student.setName("张三");

        Class clazz = Student.class;
        Field[] fileds = clazz.getFields();
        Field[] declaredFileds = clazz.getDeclaredFields();
        Field filed = clazz.getDeclaredField("age");


        System.out.println(filed.get(student));
    }
}

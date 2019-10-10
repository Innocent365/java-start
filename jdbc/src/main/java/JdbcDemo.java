
import dao.DBUtil;
import org.junit.Test;

import java.sql.*;
import java.util.Scanner;


/**
 * DriverManager: 负责加载驱动并建立与数据库的连接
 *
 * Connection: 表示数据库的连接，并可以创建Statement,以及负责事务的管理。
 *
 * Statement: 用于执行SQL语句
 *
 * ResultSet: 表示查询的结果集
 *
 * 连接数据库的过程:
 * 1:加载驱动类(不同的数据库字符串内容不同)
 * 2:通过DriverManager根据数据库地址，用户名、密码来连接数据库.(不同的数据库地址格式不同)连接成功会返回Connection对象
 * 3:通过Connection创建Statement对象
 * 4:通过Statement对象执行SQL语句，发送给数据库并得到返回结果，
 * 若是DML则返回一个数字，表示影响了数据库多少条数据，
 * 若是DQL，则会返回查询结果集。
 * 5:若有查询结果集则会返回ResultSet对象，通过遍历该对象来获取结果集内容。
 */
public class JdbcDemo {

    //最原始的方法获取数据库连接
    public Connection getConn() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");   //要求JVM查找并加载指定的类，如果在类中有静态初始化器的话，JVM必然会执行该类的静态代码段。

            //加载驱动类的字符串不同的数据库, 内容不同
            String url = "jdbc:mysql://vva.space:3306/hwq";

            /*
             * DriverManager的静态方法 getConnection在建立于数据库连接时
             * 要求传入三个参数：
             *      1:数据库地址:oracle的是:jdbc:oracle:thin:@host:port:sid
             *      2:数据库用户名
             *      3:数据库密码
             */
            connection = DriverManager.getConnection(url, "sa", "123");
            System.out.println("成功连接数据库!");
            /*
             * Connection的方法
             * Statement createStatement()
             * 可以创建用来执行SQL语句的Statement
             * 对象。
             */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Test
    public void testSelect() throws SQLException {
        Connection conn = getConn();

        Statement state = conn.createStatement();

        String sql = "SELECT empno,ename,sal,deptno FROM emp";
        System.out.println(sql);

        //执行查询语句并获取查询结果集
        ResultSet rs = state.executeQuery(sql);

        /*
         * 遍历结果集
         * boolean next()方法：
         *      使当前结果集表示下一条记录，若结果集还有下一条记录则返回 true,并表示这条记录。
         *      若没有则返回false指针默认在结果集第一条记录之上
         */
        while (rs.next()) {
            int empno = rs.getInt("empno");//获取empno对应的值
            String ename = rs.getString("ename");//获取ename对应的值
            int sal = rs.getInt("sal");//获取sal对应的值
            int deptno = rs.getInt("deptno");//获取deptno对应的值

            System.out.println(empno + "," + ename + "," + sal + "," + deptno);
        }

        rs.close();
        state.close();
        conn.close();
    }

    @Test//DML: create
    public void testCreate() {
        /*
         * 执行DDL 创建一张表:
         */
        try {
            Connection conn = getConn();
            Statement state = conn.createStatement();

            String sql = "CREATE TABLE userinfo(   " +
                    "  id NUMBER(5),          " +
                    "  username VARCHAR2(36), " +
                    "  password VARCHAR2(36), " +
                    "  email VARCHAR2(60),    " +
                    "  age NUMBER(3),         " +
                    "  account NUMBER(10)     " +
                    ")";
            System.out.println(sql);

            state.execute(sql);
            System.out.println("表创建完毕!");

            state.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test//DML: insert
    public void testInsert() {
        try {
            Connection conn = getConn();
            Statement state = conn.createStatement();

            String sql = "INSERT INTO userinfo " +
                    "(id,username,password,email,age,account) " +
                    "VALUES " + // id由序列seq_userinfo_id生成
                    "(seq_userinfo_id.NEXTVAL,'JACK','123456','JACK@tarena.com',22,50000)";
            System.out.println(sql);

            //JDBC默认自动提交事务所以每当执行一条DML操作，就将事务提交了！
            int n = state.executeUpdate(sql);
            if (n > 0) {
                System.out.println("插入成功");
            }

            state.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Statement对于执行不同种类的SQL语句，提供了相关的方法:
     * 1:ResultSet executeQuery(String sql)
     *   该方法用来执行SELECT语句，返回为值为查询的结果集
     * 2:int executeUpdate(String sql)
     *   该方法用来执行DML语句，返回值为影响了数据库多少条数据
     * 3:boolean execute(String sql)
     *   什么SQL语句都可以执行，但DML与DQL语句都有单独的方法，所以该方法通常用来执行DDL等操作。
     *   返回为:若执行完SQL语句后有查询结果集就返回true，否则返回false.
     */

    @Test//DML: insert
    public void testUpdate() {
        try {
            Connection conn = getConn();
            Statement state = conn.createStatement();

            String sql = "UPDATE userinfo  SET account=60000, age=23, email='jack@tarena.com.cn' " +
                    "WHERE username='JACK' ";
            System.out.println(sql);

            int n = state.executeUpdate(sql);
            if(n>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
            state.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Statement适合执行静态SQL语句。
     *
     * PreparedStatement适合执行动态SQL语句
     *
     * PreparedStatement执行动态SQL语句相对
     * Statement执行有几个优势:
     *      1:简化sql语句拼接的复杂度
     *      2:多次执行效率高
     *      3:可以防止SQL注入攻击
     *
     */
    public static void main(String[] args) {
        System.out.println("欢迎!请注册:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();

        System.out.println("请输入密码:");
        String password = scanner.nextLine();

        System.out.println("请输入年龄");
        String age= scanner.nextLine();

        System.out.println("请输入邮箱:");
        String email = scanner.nextLine();

        System.out.println("请输入余额:");
        String account = scanner.nextLine();

        String sql = "INSERT INTO userinfo " +
                "(id,username,password,age,email,account) " +
                "VALUES " +
                "(seq_userinfo_id.NEXTVAL,?,?,?,?,?)";

        try {
            Connection conn = DBUtil.getConnection();
            /*
             * PreparedStatement preparedStatement(String sql)
             * 该方法用来获取一个可以执行预编译SQL语句
             * 的Statement。
             * PreparedStatement是Statement的子类。
             */
            PreparedStatement ps = conn.prepareStatement(sql);

            /*
             * 指定问号对应的具体值
             */
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, Integer.parseInt(age));
            ps.setString(4, email);
            ps.setInt(5, Integer.parseInt(account));
            //执行DML操作
            int n = ps.executeUpdate();
            if(n>0){
                System.out.println("注册成功!");
            }
            ps.close();
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test//ResultSetMetaData获取查询结构元数据
    public void testMeta() {
        try {
            Connection conn = DBUtil.getConnection();

            Statement state = conn.createStatement();

            String sql = "SELECT * FROM userinfo";

            ResultSet rs = state.executeQuery(sql);
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();

            //结果集中的字段数
            int colCount = rsmd.getColumnCount();

            for(int i=1;i<=colCount;i++){
                //获取对应字段的字段名
                String colName = rsmd.getColumnName(i);
                System.out.println(colName);
            }
            state.close();
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test//开启事务
    public void testTransaction() {

        //A->B 1000
        // 关闭自动提交
        // A 取出1000
        //  如果账户余额不足 抛异常
        // B 增加1000
        // 提交执行
        // 处理异常时候 回滚操作
        // 封装为一个方法
        // boolean trans(fromId, toId, money)

        String sql1="update robin_account set balance=balance+?  where account_id=?";
        String sql2 ="select balance from robin_account where account_id=?";
        Connection conn=null;
        try {
            conn=DBUtil.getConnection();
            //关闭自动提交，开启事务提交
            conn.setAutoCommit(false);

            //业务操作
            PreparedStatement ps1= conn.prepareStatement(sql1);
            PreparedStatement ps2= conn.prepareStatement(sql2);
            //执行 A(1)->B(2) 转款
            ps1.setDouble(1, -1000);//取1000
            ps1.setInt(2, 1);//ID
            int n = ps1.executeUpdate();
            if(n!=1){
                throw new Exception("扣款失败");
            }
            //检查余额情况
            ps2.setInt(1, 1);//替换 ID
            ResultSet rs=ps2.executeQuery();
            while(rs.next()){
                double balance=rs.getDouble(1); //查询余额
                if(balance<0){
                    throw new Exception("木够钱");//抛出异常引发回滚操作
                }
            }
            //B(2)增加1000块
            ps1.setDouble(1, 1000);
            ps1.setInt(2, 2);
            n = ps1.executeUpdate();
            if(n!=1){
                throw new Exception("不成功！");
            }
            //提交执行
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();    ////有任何异常，进行回滚处理
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }finally{
            DBUtil.closeConnection(conn);
        }
    }

    @Test
    public void testAddBatch(){
        Connection conn=null;
        try{
            conn = DBUtil.getConnection();
            Statement st =
                    conn.createStatement();
            for(int i=0; i<1000; i++){
                String sql = "insert into "+
                        "robin_account " +
                        " values ("+i+", 'n"+i+"', 10)";
                st.addBatch(sql);
            }
            //executeBatch()成批的执行SQL
            int[] val = st.executeBatch();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBUtil.closeConnection(conn);
        }
    }
}

package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 该类用来负责管理数据库的连接。所有业务逻辑
 * 类需要使用数据库时，都向该类索取数据库连接
 * 这样的好处在于，若数据库发生变动，只修改这里
 * 一个地方即可。
 * @author Administrator
 *
 */
public class DBUtil {
	//数据库连接池 
	private static BasicDataSource ds;
	
	static{
		//加载properties配置文件
		Properties prop = new Properties();
		try{
			//读取配置文件
			prop.load(new FileInputStream("config.properties"));
		}catch(Exception e){
			e.printStackTrace();
		}
		String className = prop.getProperty("classname");
		
		String url = prop.getProperty("url");
		
		String username = prop.getProperty("username");
		
		String password = prop.getProperty("password");
		
		int maxActive = Integer.parseInt(prop.getProperty("maxactive"));
		
		int maxWait = Integer.parseInt(prop.getProperty("maxwait"));
		
		
		//初始化连接池
		ds = new BasicDataSource();
		//设置驱动名，原Class.forName()中的内容
		ds.setDriverClassName(className);
		//设置数据库url
		ds.setUrl(url);
		//设置用户名
		ds.setUsername(username);
		//设置密码
		ds.setPassword(password);
		//设置连接池的最大连接数
		ds.setMaxActive(maxActive);
		//设置最大等待时间
		/*
		 * 最大等待时间，当连接池中的所有连接均在使用中时，若还需要向连接池获取连接时，获取方法会进入阻塞，排队等
		 * 待分配连接，阻塞的时间为这里设定的时间，若在期间有空闲连接可用，会立刻返回该链接，若超时后仍没有空闲连
		 * 接则获取连接方法会抛出一个超时异常
		 */
		ds.setMaxWait(maxWait);
		
	} 
	
	/**
	 * 获取一个数据库的连接
	 * @return
	 * @throws Exception 
	 */
	public static Connection getConnection() throws Exception{
		try {
			return ds.getConnection();
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * 关闭给定的数据库连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









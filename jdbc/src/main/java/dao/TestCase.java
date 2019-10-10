package dao;

import org.junit.Test;

import java.util.List;

public class TestCase {
	@Test
	public void testAdd(){
		Dept ios=new Dept("IOS","潘家园");
		DeptDao deptDao = new DeptDaoImpl();
		//将部门数据添加到 数据库中
		deptDao.add(ios);
	}
	@Test
	public void testFindById(){
		DeptDao deptDao = new DeptDaoImpl();
		Dept d = deptDao.findById(1);
		System.out.println(d); 
	}	
	@Test
	public void testFindAll(){
		DeptDao deptDao = new DeptDaoImpl();
		List<Dept> all = deptDao.findAll();
		
		System.out.println(all); 
	}
	@Test
	public void testUpdate(){
		DeptDao deptDao = new DeptDaoImpl();
		Dept d = deptDao.findById(2);
		System.out.println(d); 
		d.setDname("Android");
		deptDao.update(d);
		d = deptDao.findById(2);
		System.out.println(d); 
	}
	@Test
	public void testDelete(){
		DeptDao deptDao = new DeptDaoImpl();
		Dept d = deptDao.findById(1);
		System.out.println(d); 
		deptDao.delete(d);
		//已经删除，查询结果为 null
		d = deptDao.findById(1);
		System.out.println(d); 
	}
}




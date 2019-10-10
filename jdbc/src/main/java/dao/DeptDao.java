package dao;

import java.util.List;

/**
 * DAO接口，声明实体对象的 CRUD 操作 
 */
public interface DeptDao {
	/** 将对象数据添加到数据库 C */
	void add(Dept dept);
	/** 根据ID从数据库寻回 Dept对象 */
	Dept findById(int deptno);
	List<Dept> findAll();
	List<Dept> findByLoc(String loc);
	/** 将dept对象的数据更新到数据库中 */
	void update(Dept dept);
	/** 将dept对应的数据在数据库中删除 */
	void delete(Dept dept);
}






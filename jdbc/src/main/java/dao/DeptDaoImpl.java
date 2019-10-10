package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DeptDaoImpl implements DeptDao {

	public void add(Dept dept) {
		String sql = "insert into dept " +
			"(deptno, dname, loc) values "+
			"(seq_dept.nextval, ?, ?)";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1,dept.getDname());
			ps.setString(2, dept.getLoc());
			int n = ps.executeUpdate();
			if(n != 1){
				throw new RuntimeException(
						"插入失败！");
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"木搞定!",e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	public void delete(Dept dept) {
		String sql = "delete from dept " +
				"where deptno=?";
		//              dept.getDeptno()
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1,dept.getDeptno());
			int n = ps.executeUpdate();
			if(n != 1){
				throw new RuntimeException(
						"删除失败！");
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"木搞定!",e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	public List<Dept> findAll() {
		String sql = "select deptno, " +
			"dname, loc from dept";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Dept> list = new ArrayList<Dept>();
			while(rs.next()){
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
			}
			rs.close();
			ps.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"木搞定!",e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return null;
	}
	public Dept findById(int deptno) {
		String sql = "select deptno, " +
		"dname, loc from dept " +
		"where deptno=?";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, deptno);
			ResultSet rs = ps.executeQuery();
			Dept dept = null;
			while(rs.next()){
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}
			rs.close();
			ps.close();
			return dept;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"木搞定!",e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return null;
	}
	public List<Dept> findByLoc(String loc) {
		String sql = "select deptno, " +
		"dname, loc from dept " +
		"where loc=?";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, loc);
			ResultSet rs = ps.executeQuery();
			List<Dept> list = new ArrayList<Dept>();
			while(rs.next()){
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
			}
			rs.close();
			ps.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"木搞定!",e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return null;
	}
	public void update(Dept dept) {
		String sql = "update dept set dname=?, loc=? where deptno=?";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1,dept.getDname());
			ps.setString(2,dept.getLoc());
			ps.setInt(3,dept.getDeptno());
			int n = ps.executeUpdate();
			if(n != 1){
				throw new RuntimeException(
						"更新失败！");
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"木搞定!",e);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}

}

package dao;
/**
 * 部门实体类 
 */
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	public Dept(String dname, String loc) {
		super();
		this.dname = dname;
		this.loc = loc;
	}

	public Dept() {
	}
	
	public Dept(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + deptno;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Dept other = (Dept) obj;
		if (deptno != other.deptno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return deptno+","+dname+","+loc;
	}
	
}







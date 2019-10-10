
import dao.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PagingDemo {

    public static void main(String[] args) {
        int start = 6;
        int end = 10;

        try {
            Connection conn = DBUtil.getConnection();

            /**
             * oracle使用三层查询结构，最里层使用OrderBy表示排序后的
             * int page ;       //当前页码
             * int pageSize;    //每页显示数据条数
             * int startRow = (page-1)*pageSize +1;     //开始行
             * int endRow = page*pageSize+1;            //结束行
             */
            String sql = "SELECT * FROM (SELECT ROWNUM rn,t.* FROM ( " +
                    "SELECT empno,ename,sal,job,deptno FROM emp ORDER BY sal DESC) t) " +
                    "WHERE rn BETWEEN ? AND ?";

            PreparedStatement ps =	conn.prepareStatement(sql);

            ps.setInt(1, start);
            ps.setInt(2, end);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int rn = rs.getInt("rn");
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                int sal = rs.getInt("sal");
                String job = rs.getString("job");
                int deptno = rs.getInt("deptno");
                System.out.println(rn+","+empno+","+ename+","+sal+","+job+","+deptno);
            }
            ps.close();
            DBUtil.closeConnection(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

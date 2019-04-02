package cn.edu.lingnan.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.DataAccess;
public class salaryDao {
   //通过员工id查找员工工资信息
	 public boolean findsalaryBysid(String _sid)
     {
     	boolean flag =false;
     	Connection conn=null;
     	Statement stat =null;
     	ResultSet rs =null;
     	try {
     		conn = DataAccess.getConnection();
     		//执行sql语句
     		stat = conn.createStatement();
     		rs = stat.executeQuery("select * from salary where hidden=0 and sid='"+_sid+"'");
     		//处理结果；
     		rs.next();
     		flag=true;
     	}
     	catch(SQLException e) {
     		
     			e.printStackTrace();
     		}
    	finally{
    		DataAccess.closeConnection(conn, stat, rs);
    	}
    	
     	
     	return true;
     }
  
	 //查找所有员工的工资信息；
     public Vector<salary> findAllsal(){
     	Vector<salary> v=new Vector<salary>();
     	Connection conn=null;
     	Statement stat =null;
     	ResultSet rs =null;
     	try {
     		conn = DataAccess.getConnection();
     		//执行sql语句
     		stat = conn.createStatement();
     		rs = stat.executeQuery("select * from salary where hidden=0");
     		while(rs.next()) {
     			//每查找到一条学生记录，创建一个对象，存入可变数组。
     			salary s=new salary();
     			s.setSid(rs.getString("sid"));
     		    s.setSname(rs.getString("sname"));
     		    s.setBasic(rs.getFloat("basic"));
     		    s.setBonus(rs.getFloat("bonus"));
     		    s.setSubvention(rs.getFloat("subvention"));
     		    s.setPenalty(rs.getFloat("penalty"));
     		    s.setDate(rs.getString("date"));
     		    s.setHidden(rs.getInt("hidden"));
     		   
     		    
     		v.add(s);
     		System.out.println(s.getSid()+" "+s.getSname()+" "+s.getBasic()+" "+s.getBonus()+" "+s.getSubvention()+" "+s.getPenalty()+" "+s.getDate()+" "+s.getHidden());
     		}
           }
     	catch(SQLException e) {
     		
     			e.printStackTrace();
     		}
     	
     	finally{
     		DataAccess.closeConnection(conn, stat, rs);
     	}
     	return v;
     	}
     
     //通过sid删除员工的工资信息；
     public boolean deletesalBysid(String _sid)
 	{
 		boolean flag =false;
 		Connection conn=null;
 		Statement stat =null;
 		ResultSet rs =null;
 		try {
 			conn = DataAccess.getConnection();
 			//执行sql语句
 			stat = conn.createStatement();
 			stat.executeUpdate("update salary set hidden=1 where sid='"+_sid+"'");
 	      }
 		catch(SQLException e) {
 			
 				System.out.println(_sid+"的工资信息删除失败");
 				return false;
 			}
 		finally{
 			DataAccess.closeConnection(conn, stat, rs);
 			
 		
 		}
 		System.out.println(_sid+"的工资信息删除成功");
 		return true;
 	} 
     
     //插入工资信息；
     public boolean insertsal(salary s) {
 		
 		boolean flag =false;
 		Connection conn=null;
 		Statement stat =null;
 	    PreparedStatement prep=null;
 			
 			//执行sql语句
 			try {
 				conn = DataAccess.getConnection();
 				stat = conn.createStatement();
 				prep=conn.prepareStatement("insert into salary values(?,?,?,?,?,?,?,?)");
 			    prep.setString(1, salary.getSid());
 				prep.setString(2, salary.getSname());
 				prep.setFloat(3, salary.getBasic());
 				prep.setFloat(4, salary.getBonus());
 				prep.setFloat(5, salary.getSubvention());
 				prep.setFloat(6, salary.getPenalty());
 				prep.setString(7, salary.getDate());
 				prep.setInt(8, salary.getHidden());
 				
 			    prep.execute();
 			    
 		      }
 		catch(SQLException e) {
 			
 			System.out.println("工资信息插入失败");
 			return false;
 				//e.printStackTrace();
 			}
 		finally{
 			DataAccess.closeConnection(conn, stat);
 		
 		}
 		System.out.println("工资信息插入成功");
 		return true;
 	}
     
     //修改员工工资信息；
     public boolean updatesal(salary s,String sdid1,int i) {
 		//i表示要修改的参数；
 		//
 		Connection conn=null;
 		PreparedStatement prep=null;
 		Statement stat =null;
 		//
 			//执行sql语句
 			try {
 			   conn = DataAccess.getConnection();
 			   stat = conn.createStatement();
              switch (i) {
			  case 1:
				    prep=conn.prepareStatement("update salary set sid=? where sid='"+sdid1+"'");
				    prep.setString(1, salary.getSid());
				    break;
			  case 2:
			        prep=conn.prepareStatement("update salary set sname=? where sid='"+sdid1+"'");
                    prep.setString(1, salary.getSname());
                    break;
			  case 3:
					 prep=conn.prepareStatement("update salary set basic=? where sid='"+sdid1+"'");
		             prep.setFloat(1, salary.getBasic());
		             break;
			  case 4:
					 prep=conn.prepareStatement("update salary set bonus=? where sid='"+sdid1+"'");
		             prep.setFloat(1, salary.getBonus());
		             break;
			  case 5:
					 prep=conn.prepareStatement("update salary set subvention=? where sid='"+sdid1+"'");
		             prep.setFloat(1, salary.getSubvention());
		             break;
			  case 6:
					 prep=conn.prepareStatement("update salary set penalty=? where sid='"+sdid1+"'");
		             prep.setFloat(1, salary.getPenalty());
		             break;
			  case 7:
					 prep=conn.prepareStatement("update salary set date=? where sid='"+sdid1+"'");
		             prep.setString(1, salary.getDate());
		             break;
			  case 8:
					 prep=conn.prepareStatement("update salary set hidden=? where sid='"+sdid1+"'");
		             prep.setInt(1, salary.getHidden());
		             break;
		             
			default:
				break;
			} 
 			   prep.execute();
 		      }
 		catch(SQLException e) {
 			   System.out.println("员工信息更新失败");
 				return false;
 			   //e.printStackTrace();
 			}
 		finally{
 			DataAccess.closeConnection(conn, stat);
 			
 		
 		}
 		System.out.println("员工信息更新成功");
 		return true;
 	}
 	
}

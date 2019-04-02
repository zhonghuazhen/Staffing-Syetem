package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.salary;
import cn.edu.lingnan.dto.time;
import cn.edu.lingnan.util.DataAccess;

public class timeDao {
	//通过sid查找员工工作表
	 public boolean findtimeBysid(String _sid)
     {
     	boolean flag =false;
     	Connection conn=null;
     	Statement stat =null;
     	ResultSet rs =null;
     	try {
     		conn = DataAccess.getConnection();
     		//执行sql语句
     		stat = conn.createStatement();
     		rs = stat.executeQuery("select * from time where hidden=0 and sid='"+_sid+"'");
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
	 
	 //查找全部的员工工作表
	  public Vector<time> findAlltim(){
	     	Vector<time> v=new Vector<time>();
	     	Connection conn=null;
	     	Statement stat =null;
	     	ResultSet rs =null;
	     	try {
	     		conn = DataAccess.getConnection();
	     		//执行sql语句
	     		stat = conn.createStatement();
	     		rs = stat.executeQuery("select * from time where hidden=0");
	     		while(rs.next()) {
	     			//每查找到一条时间记录，创建一个对象，存入可变数组。
	     			time s=new time();
	     			s.setSid(rs.getString("sid"));
	     		    s.setWorktime(rs.getInt("worktime"));
	     		    s.setVacate(rs.getInt("vacate"));
	     		    s.setRest(rs.getInt("rest"));
	     		    s.setHidden(rs.getInt("hidden"));
	     		v.add(s);
	     		System.out.println(s.getSid()+" "+s.getWorktime()+" "+s.getVacate()+" "+s.getRest()+" "+s.getHidden());
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
	  
	  //通过sid删除工作时间信息；
	     public boolean deletetimBysid(String _sid)
	 	{
	 		boolean flag =false;
	 		Connection conn=null;
	 		Statement stat =null;
	 		ResultSet rs =null;
	 		try {
	 			conn = DataAccess.getConnection();
	 			//执行sql语句
	 			stat = conn.createStatement();
	 			stat.executeUpdate("update time set hidden=1 where sid='"+_sid+"'");
	 	      }
	 		catch(SQLException e) {
	 			
	 				System.out.println(_sid+"的工作时间信息删除失败");
	 				return false;
	 			}
	 		finally{
	 			DataAccess.closeConnection(conn, stat, rs);
	 			
	 		
	 		}
	 		System.out.println(_sid+"的工作时间信息删除成功");
	 		return true;
	 	}  
	     
	     //插入工资信息；
	     public boolean inserttim(time t) {
	 		
	 		boolean flag =false;
	 		Connection conn=null;
	 		Statement stat =null;
	 	    PreparedStatement prep=null;
	 			
	 			//执行sql语句
	 			try {
	 				conn = DataAccess.getConnection();
	 				stat = conn.createStatement();
	 				prep=conn.prepareStatement("insert into time values(?,?,?,?,?)");
	 			    prep.setString(1, time.getSid());
	 				prep.setInt(2, time.getWorktime());
	 				prep.setInt(3, time.getVacate());
	 				prep.setInt(4, time.getRest());
	 				prep.setInt(5, time.getHidden());
	 				
	 			    prep.execute();
	 			    
	 		      }
	 		catch(SQLException e) {
	 			
	 			System.out.println("工作时间信息插入失败");
	 			return false;
	 				//e.printStackTrace();
	 			}
	 		finally{
	 			DataAccess.closeConnection(conn, stat);
	 		
	 		}
	 		System.out.println("工作时间信息插入成功");
	 		return true;
	 	}
	     
	     //修改员工工作时间信息；
	     public boolean updatetim(time t,String sdid1,int i) {
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
					    prep=conn.prepareStatement("update time set sid=? where sid='"+sdid1+"'");
					    prep.setString(1, time.getSid());
					    break;
				  case 2:
				       prep=conn.prepareStatement("update time set worktime=? where sid='"+sdid1+"'");
	                   prep.setInt(1, time.getWorktime());
	                   break;
				  case 3:
						 prep=conn.prepareStatement("update time set vacate=? where sid='"+sdid1+"'");
			             prep.setInt(1, time.getVacate());
			             break;
				  case 4:
						 prep=conn.prepareStatement("update time set rest=? where sid='"+sdid1+"'");
			             prep.setInt(1, time.getRest());
			             break;
				  case 5:
						 prep=conn.prepareStatement("update time set hidden=? where sid='"+sdid1+"'");
			             prep.setInt(1, time.getHidden());
	                     break;
			             
				default:
					break;
				} 
	 			   prep.execute();
	 		      }
	 		catch(SQLException e) {
	 			   System.out.println("员工工作时间更新失败");
	 				return false;
	 			   //e.printStackTrace();
	 			}
	 		finally{
	 			DataAccess.closeConnection(conn, stat);
	 			
	 		
	 		}
	 		System.out.println("员工工作时间更新成功");
	 		return true;
	 	}
}

package cn.edu.lingnan.dao;
import java.sql.*;
import java.util.Vector;
import cn.edu.lingnan.util.*;
import cn.edu.lingnan.dto.*;
public class staffDao {
	public boolean findstaffByNameAndPassword(String _sname,String _spass)
	{
		//通过员工名字和密码查找员工是否存在；
	boolean flag =false;
	Connection conn=null;
	Statement stat =null;
	ResultSet rs =null;
	try {
		conn = DataAccess.getConnection();
		//执行sql语句
		stat = conn.createStatement();
		rs = stat.executeQuery("select * from staff where sname='"+_sname+"' and spass='"+_spass+"'and hidden=0");
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
	
	return flag;
		}
//查找所有的员工记录
	public Vector<staff> findAllSta(){
	Vector<staff> v=new Vector<staff>();
	Connection conn=null;
	Statement stat =null;
	ResultSet rs =null;
	try {
		conn = DataAccess.getConnection();
		//执行sql语句
		stat = conn.createStatement();
		rs = stat.executeQuery("select * from staff where hidden=0");
		while(rs.next()) {
			//每查找到一条学生记录，创建一个对象，存入可变数组。
		staff s=new staff();
		s.setDid(rs.getString("did"));
		s.setSid(rs.getString("sid"));
		s.setSname(rs.getString("sname"));
		s.setSpass(rs.getString("spass"));
		s.setSex(rs.getString("sex"));
		s.setAge(rs.getInt("age"));
		s.setZhiwu(rs.getString("zhiwu"));
		s.setTel(rs.getInt("tel"));
		s.setEmail(rs.getString("email"));
		s.setSuperuser(rs.getInt("superuser"));	
		s.setHidden(rs.getInt("hidden"));
		v.add(s);
		System.out.println(s.getDid()+" "+s.getSid()+" "+s.getSname()+" "+s.getSpass()+" "+s.getSex()+" "+s.getAge()+" "+s.getZhiwu()+" "+s.getTel()+" "+s.getEmail()+" "+s.getSuperuser());
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
	//删除学生记录；
	//通过姓名删除员工记录
	public boolean deletestaByName(String _name)
	{
		boolean flag =false;
		Connection conn=null;
		Statement stat =null;
		ResultSet rs =null;
		try {
			conn = DataAccess.getConnection();
			//执行sql语句
			stat = conn.createStatement();
			stat.executeUpdate("update staff set hidden=1 where sname='"+_name+"'");
			//把staff表中的hidden改为1，实现软删除。
			stat.executeUpdate("update salary set hidden=1 where sname='"+_name+"'");
			//把salary中的hidden改为1.
			stat.executeUpdate("update time set hidden=1 where sid=(select sid from staff where sname='"+_name+"' )");
			//通过查找staff表找到sid，然后通过sid把time中的hidden改为1.
			
	      }
		catch(SQLException e) {
			
				System.out.println("员工信息删除失败");
				return false;
			}
		finally{
			DataAccess.closeConnection(conn, stat, rs);
			
		
		}
		System.out.println("员工信息删除成功");
		return true;
	}
	
	public boolean deleteBySid(String _sid)
	{
		boolean flag =false;
		Connection conn=null;
		Statement stat =null;
			
			//执行sql语句
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();
				
				stat.executeUpdate("update staff set hidden=1 where sid='"+_sid+"'");
				//把staff表中的hidden改为1，实现软删除。
				stat.executeUpdate("update salary set hidden=1 where sid='"+_sid+"'");
				//把salary中的hidden改为1.
				stat.executeUpdate("update time set hidden=1 where sidsid='"+_sid+"'");
				//把time中的hidden改为1.
				
				
				//stat.executeQuery("delete * from staff where sname='"+_sid+"'");
			
		      }
		catch(SQLException e) {
			
				e.printStackTrace();
			}
		finally{
			DataAccess.closeConnection(conn, stat);
			
		
		}
		
		return flag;
	}
	
	//插入语句；
	public boolean insertsta(staff s) {
		
		//boolean flag =false;
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat =null;
		 
			
			//执行sql语句
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();
		        //stat.executeUpdate("insert into staff values()");
			
			 prep=conn.prepareStatement("insert into staff values(?,?,?,?,?,?,?,?,?,?,?)");
			   prep.setString(1,staff.getDid());
			   prep.setString(2,staff.getSid() );
			   prep.setString(3, staff.getSname());
			   prep.setString(4, staff.getSpass());
			   prep.setString(5, staff.getSex());
			   prep.setInt(6, staff.getAge());
			   prep.setString(7, staff.getZhiwu());
			   prep.setInt(8, staff.getTel());
			   prep.setString(9, staff.getEmail());
			   prep.setInt(10, staff.getSuperuser());
			   prep.setInt(11, staff.getHidden());
			   prep.executeUpdate();
		      }
		catch(SQLException e) {
			   System.out.println("员工信息插入失败");
				return false;
			   //e.printStackTrace();
			}
		finally{
			DataAccess.closeConnection(conn, stat);
			
		
		}
		System.out.println("员工信息插入成功");
		return true;
	}
	

	//根据Sid修改staff表
	public boolean updatesta(staff s,int i) {
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
				   prep=conn.prepareStatement("update staff set did=? where sid=?");
				   prep.setString(1,staff.getDid());
				   prep.setString(2,staff.getSid());
				break;
			case 2:
				prep=conn.prepareStatement("update staff set sname=? where sid=?");
	               prep.setString(1, staff.getSname());
				   prep.setString(2,staff.getSid());
				   break;
			case 3:
				   prep=conn.prepareStatement("update staff set spass=? where sid=?");
	               prep.setString(1, staff.getSpass());
				   prep.setString(2,staff.getSid());
				   break;
			case 4:
				   prep=conn.prepareStatement("update staff set sex=? where sid=?");
	               prep.setString(1, staff.getSex());
				   prep.setString(2,staff.getSid());
				   break;
			case 5: 
				   prep=conn.prepareStatement("update staff set age=? where sid=?");
	               prep.setInt(1, staff.getAge());
				   prep.setString(2,staff.getSid());  
				   break;
			case 6:
				   prep=conn.prepareStatement("update staff set zhiwu=? where sid=?");
	               prep.setString(7, staff.getZhiwu());
				   prep.setString(2,staff.getSid());
			case 7:
				   prep=conn.prepareStatement("update staff set tel=? where sid=?");
	               prep.setInt(1, staff.getTel());
				   prep.setString(2,staff.getSid());
				   break;
			case 8:
				   prep=conn.prepareStatement("update staff set email=? where sid=?");
	               prep.setString(1, staff.getEmail());
				   prep.setString(2,staff.getSid());
				   break;
			case 9:
				   prep=conn.prepareStatement("update staff set superuser=? where sid=?");
	               prep.setInt(1, staff.getSuperuser());
				   prep.setString(2,staff.getSid());
				   break;
			case 10:
				   prep=conn.prepareStatement("update staff set hidden=? where sid=?");
	               prep.setInt(1, staff.getHidden());
				   prep.setString(2,staff.getSid());
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


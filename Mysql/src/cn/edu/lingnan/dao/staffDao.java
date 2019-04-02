package cn.edu.lingnan.dao;
import java.sql.*;
import java.util.Vector;
import cn.edu.lingnan.util.*;
import cn.edu.lingnan.dto.*;
public class staffDao {
	public boolean findstaffByNameAndPassword(String _sname,String _spass)
	{
		//ͨ��Ա�����ֺ��������Ա���Ƿ���ڣ�
	boolean flag =false;
	Connection conn=null;
	Statement stat =null;
	ResultSet rs =null;
	try {
		conn = DataAccess.getConnection();
		//ִ��sql���
		stat = conn.createStatement();
		rs = stat.executeQuery("select * from staff where sname='"+_sname+"' and spass='"+_spass+"'and hidden=0");
		//��������
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
//�������е�Ա����¼
	public Vector<staff> findAllSta(){
	Vector<staff> v=new Vector<staff>();
	Connection conn=null;
	Statement stat =null;
	ResultSet rs =null;
	try {
		conn = DataAccess.getConnection();
		//ִ��sql���
		stat = conn.createStatement();
		rs = stat.executeQuery("select * from staff where hidden=0");
		while(rs.next()) {
			//ÿ���ҵ�һ��ѧ����¼������һ�����󣬴���ɱ����顣
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
	//ɾ��ѧ����¼��
	//ͨ������ɾ��Ա����¼
	public boolean deletestaByName(String _name)
	{
		boolean flag =false;
		Connection conn=null;
		Statement stat =null;
		ResultSet rs =null;
		try {
			conn = DataAccess.getConnection();
			//ִ��sql���
			stat = conn.createStatement();
			stat.executeUpdate("update staff set hidden=1 where sname='"+_name+"'");
			//��staff���е�hidden��Ϊ1��ʵ����ɾ����
			stat.executeUpdate("update salary set hidden=1 where sname='"+_name+"'");
			//��salary�е�hidden��Ϊ1.
			stat.executeUpdate("update time set hidden=1 where sid=(select sid from staff where sname='"+_name+"' )");
			//ͨ������staff���ҵ�sid��Ȼ��ͨ��sid��time�е�hidden��Ϊ1.
			
	      }
		catch(SQLException e) {
			
				System.out.println("Ա����Ϣɾ��ʧ��");
				return false;
			}
		finally{
			DataAccess.closeConnection(conn, stat, rs);
			
		
		}
		System.out.println("Ա����Ϣɾ���ɹ�");
		return true;
	}
	
	public boolean deleteBySid(String _sid)
	{
		boolean flag =false;
		Connection conn=null;
		Statement stat =null;
			
			//ִ��sql���
			try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();
				
				stat.executeUpdate("update staff set hidden=1 where sid='"+_sid+"'");
				//��staff���е�hidden��Ϊ1��ʵ����ɾ����
				stat.executeUpdate("update salary set hidden=1 where sid='"+_sid+"'");
				//��salary�е�hidden��Ϊ1.
				stat.executeUpdate("update time set hidden=1 where sidsid='"+_sid+"'");
				//��time�е�hidden��Ϊ1.
				
				
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
	
	//������䣻
	public boolean insertsta(staff s) {
		
		//boolean flag =false;
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat =null;
		 
			
			//ִ��sql���
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
			   System.out.println("Ա����Ϣ����ʧ��");
				return false;
			   //e.printStackTrace();
			}
		finally{
			DataAccess.closeConnection(conn, stat);
			
		
		}
		System.out.println("Ա����Ϣ����ɹ�");
		return true;
	}
	

	//����Sid�޸�staff��
	public boolean updatesta(staff s,int i) {
		//i��ʾҪ�޸ĵĲ�����
		//
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat =null;
		//
			//ִ��sql���
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
			   System.out.println("Ա����Ϣ����ʧ��");
				return false;
			   //e.printStackTrace();
			}
		finally{
			DataAccess.closeConnection(conn, stat);
			
		
		}
		System.out.println("Ա����Ϣ���³ɹ�");
		return true;
	}
	
}


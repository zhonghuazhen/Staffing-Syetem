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
	//ͨ��sid����Ա��������
	 public boolean findtimeBysid(String _sid)
     {
     	boolean flag =false;
     	Connection conn=null;
     	Statement stat =null;
     	ResultSet rs =null;
     	try {
     		conn = DataAccess.getConnection();
     		//ִ��sql���
     		stat = conn.createStatement();
     		rs = stat.executeQuery("select * from time where hidden=0 and sid='"+_sid+"'");
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
     	return true;
     }
	 
	 //����ȫ����Ա��������
	  public Vector<time> findAlltim(){
	     	Vector<time> v=new Vector<time>();
	     	Connection conn=null;
	     	Statement stat =null;
	     	ResultSet rs =null;
	     	try {
	     		conn = DataAccess.getConnection();
	     		//ִ��sql���
	     		stat = conn.createStatement();
	     		rs = stat.executeQuery("select * from time where hidden=0");
	     		while(rs.next()) {
	     			//ÿ���ҵ�һ��ʱ���¼������һ�����󣬴���ɱ����顣
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
	  
	  //ͨ��sidɾ������ʱ����Ϣ��
	     public boolean deletetimBysid(String _sid)
	 	{
	 		boolean flag =false;
	 		Connection conn=null;
	 		Statement stat =null;
	 		ResultSet rs =null;
	 		try {
	 			conn = DataAccess.getConnection();
	 			//ִ��sql���
	 			stat = conn.createStatement();
	 			stat.executeUpdate("update time set hidden=1 where sid='"+_sid+"'");
	 	      }
	 		catch(SQLException e) {
	 			
	 				System.out.println(_sid+"�Ĺ���ʱ����Ϣɾ��ʧ��");
	 				return false;
	 			}
	 		finally{
	 			DataAccess.closeConnection(conn, stat, rs);
	 			
	 		
	 		}
	 		System.out.println(_sid+"�Ĺ���ʱ����Ϣɾ���ɹ�");
	 		return true;
	 	}  
	     
	     //���빤����Ϣ��
	     public boolean inserttim(time t) {
	 		
	 		boolean flag =false;
	 		Connection conn=null;
	 		Statement stat =null;
	 	    PreparedStatement prep=null;
	 			
	 			//ִ��sql���
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
	 			
	 			System.out.println("����ʱ����Ϣ����ʧ��");
	 			return false;
	 				//e.printStackTrace();
	 			}
	 		finally{
	 			DataAccess.closeConnection(conn, stat);
	 		
	 		}
	 		System.out.println("����ʱ����Ϣ����ɹ�");
	 		return true;
	 	}
	     
	     //�޸�Ա������ʱ����Ϣ��
	     public boolean updatetim(time t,String sdid1,int i) {
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
	 			   System.out.println("Ա������ʱ�����ʧ��");
	 				return false;
	 			   //e.printStackTrace();
	 			}
	 		finally{
	 			DataAccess.closeConnection(conn, stat);
	 			
	 		
	 		}
	 		System.out.println("Ա������ʱ����³ɹ�");
	 		return true;
	 	}
}

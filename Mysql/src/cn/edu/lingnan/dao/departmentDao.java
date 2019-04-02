package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.DataAccess;

public class departmentDao {
	//ͨ��did���Ҳ�����Ϣ��
        public boolean findDepartmentBydid(String _did)
        {
        	boolean flag =false;
        	Connection conn=null;
        	Statement stat =null;
        	ResultSet rs =null;
        	try {
        		conn = DataAccess.getConnection();
        		//ִ��sql���
        		stat = conn.createStatement();
        		rs = stat.executeQuery("select * from department where did='"+_did+"'");
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
        //�������в��ŵ���Ϣ��
        public Vector<department> findAllDep(){
        	Vector<department> v=new Vector<department>();
        	Connection conn=null;
        	Statement stat =null;
        	ResultSet rs =null;
        	try {
        		conn = DataAccess.getConnection();
        		//ִ��sql���
        		stat = conn.createStatement();
        		rs = stat.executeQuery("select * from department where hidden=0");
        		while(rs.next()) {
        			//ÿ���ҵ�һ��ѧ����¼������һ�����󣬴���ɱ����顣
        		department d=new department();
        		d.setDid(rs.getString("did"));	
        	    d.setDname(rs.getString("dname"));
        	    d.setHidden(rs.getInt("hidden"));
        		v.add(d);
        		System.out.println(d.getDid()+" "+d.getDname()+" "+d.getHidden());
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
        //ͨ��didɾ��������Ϣ��
        public boolean deleteDepBydid(String _did)
    	{
    		boolean flag =false;
    		Connection conn=null;
    		Statement stat =null;
    		ResultSet rs =null;
    		try {
    			conn = DataAccess.getConnection();
    			//ִ��sql���
    			stat = conn.createStatement();
    			stat.executeUpdate("update staff set hidden=1 where did='"+_did+"'");
    			//��staff���е�hidden��Ϊ1��ʵ����ɾ����
    			stat.executeUpdate("update department set hidden=1 where did='"+_did+"'");
    			//��department�е�hidden��Ϊ1.
    	      }
    		catch(SQLException e) {
    			
    				System.out.println("������Ϣɾ��ʧ��");
    				return false;
    			}
    		finally{
    			DataAccess.closeConnection(conn, stat, rs);
    			
    		
    		}
    		System.out.println("������Ϣɾ���ɹ�");
    		return true;
    	} 
        
        //���벿����Ϣ��
        public boolean insertdep(department d) {
    		
    		boolean flag =false;
    		Connection conn=null;
    		Statement stat =null;
    	    PreparedStatement prep=null;
    			
    			//ִ��sql���
    			try {
    				conn = DataAccess.getConnection();
    				stat = conn.createStatement();
    				prep=conn.prepareStatement("insert into department values(?,?,?)");
    			    prep.setString(1, department.getDid());
    			    prep.setString(2, department.getDname());
    			    prep.setInt(3, department.getHidden());
    			    prep.execute();
    			    
    		      }
    		catch(SQLException e) {
    			
    			System.out.println("������Ϣ����ʧ��");
    			return false;
    				//e.printStackTrace();
    			}
    		finally{
    			DataAccess.closeConnection(conn, stat);
    		
    		}
    		System.out.println("������Ϣ����ɹ�");
    		return true;
    	}
        //�޸Ĳ�����Ϣ��
        public boolean updatedep(department d,String did1,int i) {
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
					 prep=conn.prepareStatement("update department set did=? where did='"+did1+"'");
                	 prep.setString(1, department.getDid());
					break;
				case 2:
					   prep=conn.prepareStatement("update department set dname=? where did='"+did1+"'");
	    			   prep.setString(1, department.getDname());
	    			   break;
				case 3:
					   prep=conn.prepareStatement("update department set hidden=? where did='"+did1+"'");
	    			   prep.setInt(1,department.getHidden());
	    			   break;
				default:
					break;
				}
            
    			   prep.execute();
    		      }
    		catch(SQLException e) {
    			   System.out.println("������Ϣ����ʧ��");
    				return false;
    			   //e.printStackTrace();
    			}
    		finally{
    			DataAccess.closeConnection(conn, stat);
    			
    		
    		}
    		System.out.println("����Ϣ���³ɹ�");
    		return true;
    	}
    	
        
}

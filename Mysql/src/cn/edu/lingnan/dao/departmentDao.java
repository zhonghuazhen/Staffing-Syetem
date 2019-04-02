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
	//通过did查找部门信息；
        public boolean findDepartmentBydid(String _did)
        {
        	boolean flag =false;
        	Connection conn=null;
        	Statement stat =null;
        	ResultSet rs =null;
        	try {
        		conn = DataAccess.getConnection();
        		//执行sql语句
        		stat = conn.createStatement();
        		rs = stat.executeQuery("select * from department where did='"+_did+"'");
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
        //查找所有部门的信息；
        public Vector<department> findAllDep(){
        	Vector<department> v=new Vector<department>();
        	Connection conn=null;
        	Statement stat =null;
        	ResultSet rs =null;
        	try {
        		conn = DataAccess.getConnection();
        		//执行sql语句
        		stat = conn.createStatement();
        		rs = stat.executeQuery("select * from department where hidden=0");
        		while(rs.next()) {
        			//每查找到一条学生记录，创建一个对象，存入可变数组。
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
        //通过did删除部门信息；
        public boolean deleteDepBydid(String _did)
    	{
    		boolean flag =false;
    		Connection conn=null;
    		Statement stat =null;
    		ResultSet rs =null;
    		try {
    			conn = DataAccess.getConnection();
    			//执行sql语句
    			stat = conn.createStatement();
    			stat.executeUpdate("update staff set hidden=1 where did='"+_did+"'");
    			//把staff表中的hidden改为1，实现软删除。
    			stat.executeUpdate("update department set hidden=1 where did='"+_did+"'");
    			//把department中的hidden改为1.
    	      }
    		catch(SQLException e) {
    			
    				System.out.println("部门信息删除失败");
    				return false;
    			}
    		finally{
    			DataAccess.closeConnection(conn, stat, rs);
    			
    		
    		}
    		System.out.println("部门信息删除成功");
    		return true;
    	} 
        
        //插入部门信息；
        public boolean insertdep(department d) {
    		
    		boolean flag =false;
    		Connection conn=null;
    		Statement stat =null;
    	    PreparedStatement prep=null;
    			
    			//执行sql语句
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
    			
    			System.out.println("部门信息插入失败");
    			return false;
    				//e.printStackTrace();
    			}
    		finally{
    			DataAccess.closeConnection(conn, stat);
    		
    		}
    		System.out.println("部门信息插入成功");
    		return true;
    	}
        //修改部门信息；
        public boolean updatedep(department d,String did1,int i) {
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
    			   System.out.println("部门信息更新失败");
    				return false;
    			   //e.printStackTrace();
    			}
    		finally{
    			DataAccess.closeConnection(conn, stat);
    			
    		
    		}
    		System.out.println("部信息更新成功");
    		return true;
    	}
    	
        
}

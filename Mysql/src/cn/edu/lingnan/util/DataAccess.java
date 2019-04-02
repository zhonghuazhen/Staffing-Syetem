package cn.edu.lingnan.util;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//�������ݿ�
public class DataAccess {
   public static Connection getConnection()
   {
	   Connection conn=null;
	   try {
		   Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/system","root","root");
	   }
	   catch(ClassNotFoundException e)
	   {
		   System.out.println("��ȡconnectionʱ�Ҳ������ļ�");
		   
	   }
	   catch(SQLException e) {
		   System.out.println("��ȡconnectionʱSQL�쳣");
	   }
	   return conn;
   }
   
   //�ر����ݿ�
   public static void close(ResultSet rs) throws SQLException {
	    if (rs != null) {
	        rs.close();
	    }
	}

	public static void close(Statement stmt) throws SQLException {
	    if (stmt != null) {
	        stmt.close();
	    }
	}

	public static void close(Connection conn) throws SQLException {
	    if (conn != null) {
	        conn.close();
	    }
	}

	public static void closeConnection(Connection conn) {
	    try {
	        close(conn);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void closeConnection(ResultSet rs) {
	    try {
	        close(rs);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void closeConnection(Statement stmt) {
	    try {
	        close(stmt);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void closeConnection(Connection conn,Statement stat,ResultSet rs) {
		try {
			if(rs!=null)
				rs.close();
			if(stat!=null)
				stat.close();
			if(conn!=null)
				conn.close();
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void closeConnection(Connection conn,Statement stat) {
		try {
			if(stat!=null)
				stat.close();
			if(conn!=null)
				conn.close();
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
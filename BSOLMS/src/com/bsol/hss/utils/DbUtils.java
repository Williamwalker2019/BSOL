package com.bsol.hss.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DbUtils {
	private static String username="root";
	private static String password="Root";
	private static String dburl="jdbc:mysql://localhost:3306/bsol";
	private static String dirverClass="com.mysql.jdbc.Driver";
	
	/**
	 * ���ܣ���ȡ���ݿ������
	 * @return
	 */
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			Class.forName(dirverClass);//1.��������
			con= DriverManager.getConnection(dburl, username, password);//2.��ȡ����
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����û�ҵ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("��ȡ����ʧ��");
		}
		
		return con;
	}
	/**
	 * ���ܣ��ر����ݿ������
	 * @param con
	 * @param st
	 */
	public static void close(Connection con, Statement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * ���ܣ��ر����ݿ������
	 * @param con
	 * @param st
	 * @param rs
	 */
	public static void close(Connection con,Statement st,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

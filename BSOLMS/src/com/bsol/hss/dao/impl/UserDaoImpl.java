package com.bsol.hss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bsol.hss.bean.User;
import com.bsol.hss.dao.UserDao;
import com.bsol.hss.utils.DbUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean addUser(User user) {
		Connection con=null;//�������ݿ����Ӷ���Ϊ��ֵ
		PreparedStatement ps=null;
		String sql="insert into user(username,password) values(?,?)";
		con=DbUtils.getConnection();
		int n=0;
		if(con!=null) {
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				n=ps.executeUpdate();//ִ��sql���ķ���	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DbUtils.close(con, ps);
			}
		}
		if(n>0)
		return true;
		return false;
	}

	@Override
	public User findUserByName(String username) {
		Connection con=null;//�������ݿ����Ӷ���Ϊ��ֵ
		PreparedStatement ps=null;
		String sql="select * from user where userName=?";//ͨ�������ֲ����û�
		con=DbUtils.getConnection();
		ResultSet rs=null;
		User user=null;
		if(con!=null) {
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, username);//���ݵĲ�����String���;Ϳ���ֱ����username��������String������ҪUser�����get����ȥ�������
				rs=ps.executeQuery();//ִ��sql����ѯ�ķ��������ص��ǽ����	
				if(rs.next()) {
					user=new User();
					user.setUserid(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setManagement(rs.getInt(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("sql�쳣");
				e.printStackTrace();
			}finally {
				DbUtils.close(con, ps);
			}
		}
		return user;
		
	}

	@Override
	public boolean updateUserById(int userID, String password) {
		Connection con=null;//�������ݿ����Ӷ���Ϊ��ֵ
		PreparedStatement ps=null;
		String sql=" update user set password=? where userID=? ";
		con=DbUtils.getConnection();
		int n=0;
		if(con!=null) {
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1,password);
				ps.setInt(2,userID);
				n=ps.executeUpdate();//ִ��sql���ķ���	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DbUtils.close(con, ps);
			}
		}
		if(n>0)
		return true;
		return false;
	}
}

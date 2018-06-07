package com.bsol.hss.dao;

import com.bsol.hss.bean.User;

public interface UserDao {
	
	/**
	 * ����û�
	 * @return
	 */
	public boolean addUser(User user);
	
	/**
	 * �����û�
	 * @return
	 */
	public User findUserByName(String username);
	
	/**
	 * ͨ���û�ID�޸��û�����
	 * @param userID
	 * @return
	 */
	public boolean updateUserById(int userID,String password);

}

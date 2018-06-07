package com.bsol.hss.dao;

import java.util.List;

import com.bsol.hss.bean.Book;
import com.bsol.hss.bean.Order;
import com.bsol.hss.bean.TrueOrder;

public interface OrderDao {
	
	public boolean addOrder(Order order);
	
	public List<TrueOrder> findAllOrders();
	
//	������Ӳ�ѯ
//	select  u.userName,b.bookName,o.date
//	from user u,book b,`order` o
//	where o.userID=u.userID AND o.bookID=b.bookID;
	
	//��ѯ��������
	public int getOrderCount();
	
	//��ҳ��ѯ
	public List<TrueOrder> getPageDates(int startindex,int endindex);
	
	//ͨ���û�ID��ѯ�û�����
	public List<TrueOrder> getUserOrders(int startindex,int endindex,int userID);
	
	//ͨ���û�ID�õ��û���������
	public int getUserOrderCount(int userID);
}

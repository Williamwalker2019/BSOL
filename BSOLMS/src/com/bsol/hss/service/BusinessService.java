package com.bsol.hss.service;

import java.util.List;

import com.bsol.hss.bean.Book;
import com.bsol.hss.bean.Order;
import com.bsol.hss.bean.Page;
import com.bsol.hss.bean.TrueOrder;
import com.bsol.hss.bean.User;
import com.bsol.hss.dao.BookDao;
import com.bsol.hss.dao.OrderDao;
import com.bsol.hss.dao.UserDao;
import com.bsol.hss.dao.impl.BookDaoImpl;
import com.bsol.hss.dao.impl.OrderDaoImpl;
import com.bsol.hss.dao.impl.UserDaoImpl;

public class BusinessService {
	
	UserDao userDao= new UserDaoImpl();
	BookDao bookDao=new BookDaoImpl();
    OrderDao orderDao=new OrderDaoImpl();
    
 
    /**
     * �û���¼
     * @param username
     * @param password
     * @return
     */
    public boolean userLogin(String username,String password) {
    	User u=userDao.findUserByName(username);
    	if(u!=null) {
    		if(u.getPassword().equals(password)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * �ж��Ƿ��ǹ���Ա
     * @param username
     * @return
     */
    public boolean isManager(String username) {
    	User u=userDao.findUserByName(username);
    		if(u!=null) {
    			if(u.getManagement()==1) {
    				return true;
    			}
    		}
    	return false;
    }
    
    /**
     * �û�ע��
     * @param user
     * @return
     */
    public boolean userRegister(User user) {
    	return userDao.addUser(user);
    }
    
    /**
     * ����鼮
     * @param book
     * @return
     */
    public boolean addBook(Book book) {
    	return bookDao.addBook(book);
    }
    
    /**
     * ͨ�����ֲ����鼮
     * @param bookname
     * @return
     */
    public Book findBookByName(String bookname) {
    	return bookDao.findBookByName(bookname);
    }
    
    /**
     * ���������鼮
     * @return
     */
    public List<Book> findAllBooks(){
    	return bookDao.findAllBooks();
    }
    
    /**
     * ��Ӷ���
     * @param order
     * @return
     */
    public boolean addOrder(Order order) {
    	return orderDao.addOrder(order);
    }
    
    /**
     * �������ж���
     * @return
     */
    public List<TrueOrder> findAllOrders(){
    	return orderDao.findAllOrders();
    }
    /**
     * ͨ���û����������û�
     * @param username
     * @return
     */
    public User findUserByName(String username) {
    	return userDao.findUserByName(username);
    }
    /**
     * �����鼮���
     * @param bookid
     * @return
     */
    public boolean updateBookStock(int bookid) {
    	Book book=bookDao.findBookById(bookid);
    	return bookDao.updateStockById(book.getStock()-1, bookid);
    }
    
    /**
     * �õ�ҳ����Ϣ(manager)
     * @param startindex  ��ʼ����
     * @param endindex    ������
     * @return
     */
    public Page getPageDates(int startindex,int endindex) {
    	Page page=new Page();
    	page.setList(bookDao.getPageDates(startindex, endindex));
    	return page;
    }
    
    /**
     * �õ��鼮������
     * @return
     */
    public int getBookCount() {
    	
    	return bookDao.getBookCount();
    }
    
    /**
     * �õ���������
     * @return
     */
    public int getOrderCount() {
    	return orderDao.getOrderCount();
    }
    
    public int getUserOrderCount(int userID) {
    	return orderDao.getUserOrderCount(userID);
    }
    
    /**
     * �õ�������ҳ����Ϣ(manager)
     * @param startindex
     * @param endindex
     * @return
     */
    public Page getOrderPageDates(int startindex,int endindex) {
    	Page page=new Page();
    	page.setList(orderDao.getPageDates(startindex, endindex));
    	return page;
    }
    
    /**
     * ͨ���û�ID�õ��û�����ҳ����Ϣ
     * @param startindex
     * @param endindex
     * @param userID
     * @return
     */
    public Page getUserOrerPageDates(int startindex,int endindex,int userID) {
    	Page page=new Page();
    	page.setList(orderDao.getUserOrders(startindex, endindex, userID));
    	return page;
    }
    
  
  /**
   * ͨ���û�ID�޸�����  
   * @param userID
   * @param password
   * @return
   */
    public boolean updateUser(int userID,String password) {
    	return userDao.updateUserById(userID, password);
    }

}

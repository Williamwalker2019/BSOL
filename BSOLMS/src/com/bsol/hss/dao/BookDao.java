package com.bsol.hss.dao;

import java.util.List;

import com.bsol.hss.bean.Book;

public interface BookDao {
	
	public boolean addBook(Book book);
	
	public boolean updateStockById(Integer stock,Integer bookid);
	
	public List<Book> findAllBooks();
	
	public Book findBookByName(String bookname);
    
	public Book findBookById(int bookid);
	
	//��ҳ��ѯ
	public List<Book> getPageDates(int startindex,int endindex);
	
	//�����鼮����
	public int getBookCount();
}

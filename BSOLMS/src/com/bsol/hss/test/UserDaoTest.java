package com.bsol.hss.test;

import org.junit.jupiter.api.Test;

import com.bsol.hss.bean.Book;
import com.bsol.hss.dao.BookDao;
import com.bsol.hss.dao.impl.BookDaoImpl;
import com.bsol.hss.service.BusinessService;

public class UserDaoTest {
	
	@Test 
	void testAddBook() {
		Book book=new Book();
		BusinessService service =new BusinessService();
		
		book.setBookname("������̵���");
		book.setAuthor("�ź���");
		book.setInformation("�����");
		book.setPrice(39.5);
		book.setPublishing_house("�廪��ѧ������");
		book.setStock(208);
		
		boolean b=service.addBook(book);
		if(b) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
    @Test
    void testUpdateUser() {
    	BusinessService service =new BusinessService();
    	boolean b=service.updateUser(11, "11");
    	if(b) {
    		System.out.println("true");
    	}else {
    		System.out.println("false");
    	}
    }
}

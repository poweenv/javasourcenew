package service;

import domain.BookDTO;
import persistence.BookDAO;

public class BookUpdateService {
	
	public boolean updateBook(int code, int price){
		BookDAO dao = new BookDAO();
		return dao.update(code,price);
	}
}

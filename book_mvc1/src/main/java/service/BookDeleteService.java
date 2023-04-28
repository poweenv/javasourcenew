package service;

import persistence.BookDAO;

public class BookDeleteService {
	
	
	public boolean remove(int code) {
		
		return new BookDAO().delete(code);
	}
}

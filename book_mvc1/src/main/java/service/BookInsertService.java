package service;

import java.util.List;

import domain.BookDTO;
import persistence.BookDAO;

public class BookInsertService {
		
	
	 // 호출하고 그 결과를 리턴
	public boolean insertBook(BookDTO insertDto) {
		BookDAO dao = new BookDAO();
		return dao.insert(insertDto);
		
		
	}
}

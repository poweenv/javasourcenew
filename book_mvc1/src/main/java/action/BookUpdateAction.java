package action;

import javax.servlet.http.HttpServletRequest;

import service.BookUpdateService;

public class BookUpdateAction implements BookAction {

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		
		int code = Integer.parseInt(request.getParameter("code"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookUpdateService service = new BookUpdateService();
		boolean updateFlag=service.updateBook(code,price);

		
		//ActionForward
		String path="";
		if(updateFlag) {
			path = "list.do";
		}
		
		return new BookActionForward(true,path);
	}

}

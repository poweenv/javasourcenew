package action;

import javax.servlet.http.HttpServletRequest;

import service.BookDeleteService;

public class BookDeleteAction implements BookAction {

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		BookDeleteService service = new BookDeleteService();
		boolean deleteFlag = service.remove(code);
		
		String path ="";
		if(deleteFlag) {
			path="list.do";
		}
		
		
		return new BookActionForward(true,path);
	}

}

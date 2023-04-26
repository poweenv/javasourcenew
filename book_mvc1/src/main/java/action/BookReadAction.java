package action;

import javax.servlet.http.HttpServletRequest;

import domain.BookDTO;
import service.BookReadService;

public class BookReadAction implements BookAction {

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		//service 를 통해 데이터베이스 작업
		BookReadService service = new BookReadService();
		BookDTO dto =  service.read(code);
		//ActionForward
		request.setAttribute("dto", dto);
		
		return new BookActionForward(false,"read.jsp");
	}

}

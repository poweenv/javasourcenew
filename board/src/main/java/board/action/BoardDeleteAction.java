package board.action;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.service.BoardDeleteService;
import board.service.BoardReadService;
import board.service.BoardUpdateService;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// post
		int bno = Integer.parseInt(request.getParameter("bno"));
		String password = request.getParameter("password");
		
		BoardDeleteService service = new BoardDeleteService();		
		String path = "";
		if(service.remove(bno,password)) {
			path = "list.do";
		}else {
			path = "modify.do?bno="+bno;
		}		
		
		return new ActionForward(true, path);
	}
}

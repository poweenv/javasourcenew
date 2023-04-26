package action;

import javax.servlet.http.HttpServletRequest;

import service.InsertService;

public class DeleteAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception{
		System.out.println("code "+request.getParameter("code"));

		InsertService service = new InsertService();
		boolean result =service.insertArticle();
		
		if(result) {
			
		}
		return new ActionForward(result, "list.jsp"); 

	}
}

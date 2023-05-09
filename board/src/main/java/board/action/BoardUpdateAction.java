package board.action;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.domain.PageDTO;
import board.service.BoardUpdateService;
import board.service.BoardWriteService;
import board.util.BoardUploadUtils;

public class BoardUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		BoardUploadUtils utils = new BoardUploadUtils();
		Map<String, String> formData = utils.uploadFile(request);
		
		//formData 값들을 BoardDTO 객체 생성 후 담기
		//file 이 입력된 경우와 입력이 안된 경우
		BoardDTO dto = new BoardDTO();	
		dto.setBno(Integer.parseInt(formData.get("bno")));
		dto.setTitle(formData.get("title"));
		dto.setContent(formData.get("content"));
		dto.setPassword(formData.get("password"));
		if(formData.containsKey("attach")) {
			dto.setAttach(formData.get("attach"));
		}		
		String criteria = formData.get("criteria"); 
		String keyword = URLEncoder.encode(formData.get("keyword"), "utf-8"); 
		String page = formData.get("page"); 
		String amount = formData.get("amount"); 
				
		//서비스 작업
		BoardUpdateService service = new BoardUpdateService();		
		
		String path = "";
		if(service.update(dto)) {
			path = "read.do?bno="+dto.getBno()+"&criteria="+criteria+"&keyword="+keyword+"&page="+page+"&amount="+amount;
		}else {
			path = "modify.do?bno="+dto.getBno()+"&criteria="+criteria+"&keyword="+keyword+"&page="+page+"&amount="+amount;
		}		
		
		return new ActionForward(true, path);
	}
	
}
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.ChangeDTO;
import domain.MemberDTO;
import service.MemberChangeService;

public class MemberChangeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		
		// post
		ChangeDTO dto = new ChangeDTO();
		dto.setUserid(request.getParameter("userid"));
		dto.setCurrentPassword(request.getParameter("current-password"));
		dto.setNewPassword(request.getParameter("new-password"));
		dto.setConfirmPassword(request.getParameter("confirm-password"));
		
		MemberChangeService loginService=new MemberChangeService();
		MemberDTO info=loginService.login(dto.getUserid(),dto.getCurrentPassword());
		// userid와 현재 비밀번호를 가지고 일치하는 회원이 있는지 확인
		String path="";
		if(info!=null) {
			MemberChangeService changeService = new MemberChangeService();
			if(changeService.ChangePwd(dto)) {
				
				HttpSession session = request.getSession();
				session.invalidate();
				path= "login.jsp";
			}
		}else {
			path="changePwd.jsp";
		}

		// 일치한다면 비번 변경 서비스 호출
		// 일치하지 않다면 비번 변경 페이지로 되돌아가기
		
		
		return new ActionForward(true,path);
	}

}

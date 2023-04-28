package service;

import domain.ChangeDTO;
import domain.MemberDTO;
import persistence.MemberDAO;

public class MemberChangeService {

	public boolean ChangePwd(ChangeDTO dto) {
		//호출하는 역할
		return new MemberDAO().update(dto);
	}
	public MemberDTO login(String userid, String currentPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}

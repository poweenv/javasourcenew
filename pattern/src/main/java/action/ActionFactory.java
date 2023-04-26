package action;

public class ActionFactory {
	
	
	/*
	 * 	디자인 패턴 : 개발 방식 정의	
	 * 
	 * 	싱글톤 패턴
	 * 	객체 생성하는 메소드가 여러번 호출되도 단 하나의 생성자가
	 *  생성하는 객체가 리턴
	 * */
	
	private static ActionFactory actionFactory;

	//생성자
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		if(actionFactory == null) {
			actionFactory = new ActionFactory();
		}
		return actionFactory;
	}
	
	// Action 리턴 메소드
	Action action;
	public Action action(String cmd) {
	// 어디서 요청이 왔는지에 따라 액션 생성
	if (cmd.equals("/insert.do")) {
		action = new InsertAction();

	} else if (cmd.equals("/list.do")) {

	} else if (cmd.equals("/update.do")) {

	} else if (cmd.equals("/delete.do")) {
		action = new DeleteAction();
	
	}
	return action;
	}
}

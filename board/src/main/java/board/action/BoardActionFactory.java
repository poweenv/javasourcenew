package board.action;

public class BoardActionFactory {
	
	private static BoardActionFactory baf;	
	private BoardActionFactory() {}
	
	public static BoardActionFactory getInstance() {
		if(baf == null) {
			baf = new BoardActionFactory();
		}
		return baf;
	}
	
	public Action action(String cmd) {
		Action action = null;
		
		if(cmd.equals("/write.do")) {
			action = new BoardWriteAction();
		}else if(cmd.equals("/list.do")) {
			action = new BoardListAction();
		}else if(cmd.equals("/read.do")) {
			action = new BoardReadAction();
		}else if(cmd.equals("/cntUpdate.do")) {
			action = new BoardCntAction();
		}else if(cmd.equals("/modify.do")) {
			action = new BoardModifyAction();
		}else if(cmd.equals("/delete.do")) {
			action = new BoardDeleteAction();
		}else if(cmd.equals("/replyView.do")) {
			action = new BoardReplyViewAction();
		}else if(cmd.equals("/reply.do")) {
			action = new BoardReplyAction();
		}
		
//		else if(cmd.equals("/search.do")) {
//			action = new BoardSearchAction();
//		}
		
		
		return action;
	}
}
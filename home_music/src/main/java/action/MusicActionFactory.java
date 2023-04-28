package action;

public class MusicActionFactory {
	
	private static MusicActionFactory maf;
	private MusicActionFactory() {}
	
	public static MusicActionFactory getInstance() {
		if(maf==null) {
			maf = new MusicActionFactory();
		}
		return maf;
	}
	public MusicAction action(String cmd) {
		MusicAction action =null;
		
		if(cmd.equals(".list.do")) {
			action=new MusicListAction
		}
	}
}

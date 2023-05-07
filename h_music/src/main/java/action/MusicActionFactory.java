package action;

public class MusicActionFactory {
	private static MusicActionFactory maf;
	
	private MusicActionFactory() {}
	
	public static  MusicActionFactory getInstance() {
		if(maf==null) {
			maf= new MusicActionFactory();
		}
		
		return null;
	}
	
	public Action action(String cmd) {
		Action action = null;
		
		if(cmd.equals("")) {
			action= new MusicWriteAction();
		}
		return action;
	}
}

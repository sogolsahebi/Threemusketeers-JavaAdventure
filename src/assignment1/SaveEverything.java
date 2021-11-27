package assignment1;

public class SaveEverything extends SaveBuilder{

	public SaveEverything(Board board) {
		
		super(board);
		this.doSaveHint();
		this.doSaveAudience();
		this.doSaveBoard();
		
	}
	
}

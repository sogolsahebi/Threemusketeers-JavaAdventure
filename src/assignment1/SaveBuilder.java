package assignment1;

public class SaveBuilder {

	private Hint hint1, hint2;
//	private Audience audience;  //Uncomment when Audience is implemented
	private Board board;
	private boolean saveHint = false;
//	private boolean saveAudience = false;  //Uncomment when Audience is implemented
	private boolean saveBoard = false;
	
	public SaveBuilder(Board board) {
		
		this.board = board;
		
	}
	
    /**
     * Create the save object
     */
	public SaveBuilder(Board board, Hint hint1, Hint hint2) {
		
		this.board = board;
		this.hint1 = hint1;
		this.hint2 = hint2;
		
	}
	
	public void doSaveHint() {
		
		saveHint = true;
		
	}
	
//	public void doSaveAudience() {
//		
//		saveAudience = true;  //Uncomment when Audience is implemented
//		
//	}
	
	public void doSaveBoard() {
		
		saveBoard = true;
		
	}
	
    /**
     * Create the save object
     */
	public Save getSave() {
		
		Save save = new Save();
		save.saveHint(saveHint);
//		save.saveAudience(saveAudience);  //Uncomment when Audience is implemented
		save.saveBoard(saveBoard);
		save.setHint(hint1, hint2);
		save.setBoard(board);
		
		return save;
		
	}
	
}

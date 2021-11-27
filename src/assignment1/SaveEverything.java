package assignment1;

public class SaveEverything extends SaveBuilder{

    /**
     * Create a save object that saves board, hint, and audience
     */
	public SaveEverything(Board board, Hint hint1, Hint hint2) {
		
		super(board, hint1, hint2);
		this.doSaveHint();
//		this.doSaveAudience();  //Uncomment this when Audience is implemented
		this.doSaveBoard();
		
	}
	
}

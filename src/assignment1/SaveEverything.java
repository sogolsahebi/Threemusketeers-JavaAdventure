package assignment1;

public class SaveEverything extends SaveBuilder{

    /**
     * Create a save object that saves board, hint, and audience
     */
	public SaveEverything(Board board, Hint hint1, Hint hint2, Audience audience) {
		
		super(board, hint1, hint2, audience);
		this.doSaveHint();
		this.doSaveAudience();
		this.doSaveBoard();
		
	}
	
}

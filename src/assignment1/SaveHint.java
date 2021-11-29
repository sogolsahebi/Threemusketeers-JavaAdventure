package assignment1;

public class SaveHint extends SaveBuilder{

    /**
     * Create a save object that saves board and hint
     */
	public SaveHint(Board board, Hint hint1, Hint hint2) {
		
		super(board, hint1, hint2);
		this.doSaveHint();
		this.doSaveBoard();
		
	}
	
}

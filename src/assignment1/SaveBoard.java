package assignment1;

public class SaveBoard extends SaveBuilder{

    /**
     * Create save object that saves board only
     * @param board The board of the game
     */
	public SaveBoard(Board board) {
			
		super(board);
		this.doSaveBoard();
			
	}

}

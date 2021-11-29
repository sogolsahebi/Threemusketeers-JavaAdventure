package assignment1;

public class SaveAudience extends SaveBuilder{

    /**
     * Create save object that saves board and audience
     * @param board The board of the game
     */
	public SaveAudience(Board board) {
		
		super(board);
//		this.doSaveAudience();  //Uncomment when Audience is implemented
		this.doSaveBoard();
		
	}
	
}

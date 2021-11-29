package assignment1;

public class Save {

	private boolean sHint, sAudience, sBoard;
	private Hint hint1, hint2;
	private Board board;
	private Audience audience;

	public Save() {

		this.sHint = false;
		this.sAudience = false;
		this.sBoard = false;
		
	}

	public void saveHint(boolean sHint) {
		
		this.sHint = sHint;
		
	}
	
	public void saveAudience(boolean sAudience) {
		
		this.sAudience = sAudience;
		
	}
	
	public void saveBoard(boolean sBoard) {
		
		this.sBoard = sBoard;
		
	}
	
	public void setHint(Hint hint1, Hint hint2) {
		
		this.hint1 = hint1;
		this.hint2 = hint2;
		
	}
	
	public void setAudience(Audience audience) {
		
		this.audience = audience;
		
	}
  
	public void setBoard(Board board) {
		
		this.board = board;
		
	}
	
    /**
     * Save the features this save object has
     */
	public void save() {
		
		if (sHint) {
			//Save both random and greedy hints
			hint1.saveHint();
			hint2.saveHint();
			
		}
		if (saveAudience) {			// sAudience change it to that instead
			
			audience.saveScore();
			
		}
		if (sBoard) {
			
			board.saveBoard();
			
		}
		
	}
	
}

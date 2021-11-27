package assignment1;

public class Save {

	private boolean hint, audience, board;

	public Save() {

		this.hint = false;
		this.audience = false;
		this.board = false;
		
	}

	public void saveHint(boolean hint) {
		
		this.hint = hint;
		
	}
	
	public boolean getSaveHint() {
		
		return hint;
		
	}
	
	public void saveAudience(boolean audience) {
		
		this.audience = audience;
		
	}
	
	public boolean getSaveAudience() {
		
		return audience;
		
	}
	
	public void saveBoard(boolean board) {
		
		this.board = board;
		
	}
	
	public boolean getSaveBoard() {
		
		return board;
		
	}
	
}

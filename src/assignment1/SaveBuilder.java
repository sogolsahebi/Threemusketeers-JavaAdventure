package assignment1;

public class SaveBuilder {

	private Hint hint1, hint2;
	private Audience audience;
	private Board board;
	private boolean saveHint = false;
	private boolean saveAudience = false;
	private boolean saveBoard = false;
	
    /**
     * Constructor to create save object to save the board only
     * @param board the board of the game
     */
	public SaveBuilder(Board board) {
		
		this.board = board;
		
	}
	
    /**
     * Constructor to create save object to save hints with the board
     * @param board the board of the game, hint1 level one hint, hint2 level two hint
     */
	public SaveBuilder(Board board, Hint hint1, Hint hint2) {
		
		this.board = board;
		this.hint1 = hint1;
		this.hint2 = hint2;
		
	}
	
    /**
     * Constructor to create save object to save the audience with the board
     * @param board the board of the game, audience the audience of the game
     */
	public SaveBuilder(Board board, Audience audience) {
		
		this.board = board;
		this.audience = audience;
		
	}
	
    /**
     * Constructor to create save object to save hints and the audience with the board
     * @param board the board of the game, hint1 level one hint, hint2 level two hint, audience the audience of the game
     */
	public SaveBuilder(Board board, Hint hint1, Hint hint2, Audience audience) {
		
		this.board = board;
		this.hint1 = hint1;
		this.hint2 = hint2;
		this.audience = audience;
		
	}

	public void doSaveHint() {
		
		saveHint = true;
		
	}
	
	public void doSaveAudience() {
		
		saveAudience = true;
		
	}
	
	public void doSaveBoard() {
		
		saveBoard = true;
		
	}
	
    /**
     * Create the save object
     */
	public Save getSave() {
		
		Save save = new Save();
		save.saveHint(saveHint);
		save.saveAudience(saveAudience);
		save.saveBoard(saveBoard);
		save.setHint(hint1, hint2);
		save.setAudience(audience);
		save.setBoard(board);
		
		return save;
		
	}
	
}

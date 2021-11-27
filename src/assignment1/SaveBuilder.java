package assignment1;

public class SaveBuilder {

//	private Hint hint;  //Uncomment when Hint is implemented
//	private Audience audience;  //Uncomment when Audience is implemented
	private Board board;
	private boolean saveHint = false;
	private boolean saveAudience = false;
	private boolean saveBoard = false;
	
	public SaveBuilder(Board board) {
		
		this.board = board;
		
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
	
	public Save getSave() {
		
		Save save = new Save();
		save.saveHint(saveHint);
		save.saveAudience(saveAudience);
		save.saveBoard(saveBoard);
		
		return save;
		
	}
	
	public void save() {
		
//		if (saveHint) {
//			
//			hint.saveHint();  //Uncomment when Hint is implemented
//			
//		}
//		if (saveAudience) {
//			
//			audience.saveAudience();  //Uncomment when Audience is implemented
//			
//		}
		System.out.println(2);
		if (saveBoard) {
			System.out.println(1);
			board.saveBoard();
			
		}
		
	}
	
}

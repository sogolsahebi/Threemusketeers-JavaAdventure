package assignment1;

public class RandomHint extends Hint{

    /**
     * Create a new random hint
     * @param board The board of the game
     */
	public RandomHint(Board board) {
		
		super(board, 0, "random");
		
	}
	
    /**
     * load a random hint
     * @param board The board of the game, filePath The file path to load hint from
     */
	public RandomHint(Board board, String filePath) {
		
		super(board, 0, "random", filePath);
		
	}
	
}

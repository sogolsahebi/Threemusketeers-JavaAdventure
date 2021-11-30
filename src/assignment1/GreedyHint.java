package assignment1;

public class GreedyHint extends Hint{

    /**
     * Create a new greedy hint
     * @param board The board of the game
     */
	public GreedyHint(Board board) {
		
		super(board, 1, "greedy");
		
	}
	
    /**
     * load a greedy hint
     * @param board The board of the game, filePath The file path to load hint from
     */
	public GreedyHint(Board board, String filePath) {
		
		super(board, 1, "greedy", filePath);
		
	}
	
}

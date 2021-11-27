package assignment1;

public class HintFactory {

    /**
     * Create new hints
     */
	public Hint createHint(Board board, int lvl) {
		
		if (lvl == 0) {
			
			return new RandomHint(board);
			
		}
		if (lvl == 1) {
			
			return new GreedyHint(board);
			
		}
		
		return null;
		
	}
	
    /**
     * Load hints
     */
	public Hint loadHint(Board board, int lvl, String filePath) {
		
		if (lvl == 0) {
			
			return new RandomHint(board, filePath);
			
		}
		if (lvl == 1) {
			
			return new GreedyHint(board, filePath);
			
		}
		
		return null;
		
	}
	
}

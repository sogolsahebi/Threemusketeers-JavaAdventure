package assignment1;

import java.util.List;

public class SpecialMove implements IMoveStrategy {
	
	private final int[][] directions = {{2,0}, {0,2}, {-2,0}, {0,-2}};

    /**
     * Get all the possible moves that can be made this turn.
     * @return List of moves that can be made this turn
     */
    public List<Move> getPossibleMoves(Board board) {
        return board.getPossibleMoves(directions);
    }
    
    public void playAudio(String path) {
    	Audio.playAudio(path);
    }
}

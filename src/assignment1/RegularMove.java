package assignment1;

import java.util.List;

public class RegularMove implements IMoveStrategy{
	
    private final int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

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

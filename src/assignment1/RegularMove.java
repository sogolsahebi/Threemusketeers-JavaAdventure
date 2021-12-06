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
    
    public void playAudio(int emotionalScore) {
    	String path;
    	int time;
    	if ((0 <= emotionalScore) && (emotionalScore < 5)) {
    		path = "sound/you_murderer.wav";
    		time = 2000;
        } else if ((5 <= emotionalScore) && (emotionalScore < 10)){
        	path = "sound/5_kills_clip.wav";
        	time = 4500;
        } else {
        	path = "sound/power_level_is_over_9000.wav";
        	time  = 4000;
        }

    	Audio.playAudio(path, time);
    }
}

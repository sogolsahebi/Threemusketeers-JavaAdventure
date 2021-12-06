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
    
    public void playAudio(int emotionalScore) {
    	String path;
    	int time;
    	if ((0 <= emotionalScore) && (emotionalScore < 5)) {
    		path = "sound/you_murderer_voice_2.wav";
    		time = 3000;
        } else if ((5 <= emotionalScore) && (emotionalScore < 10)){
        	path = "sound/somebody_stop_him_2.wav";
        	time = 3500;
        } else {
        	path = "sound/you_killed_10_people.wav";
        	time  = 4000;
        }

    	Audio.playAudio(path, time);
    }
}

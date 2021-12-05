package assignment1;

import java.util.List;

public interface IMoveStrategy {

	public List<Move> getPossibleMoves(Board board);
	public void playAudio(String path);
}

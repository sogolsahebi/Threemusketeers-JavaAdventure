package assignment1;

import java.util.List;

public interface IMoveStrategy {
	public Boolean isValidMove(Board board, Move move);
	public List<Move> getPossibleMoves(Board board);
	public List<Cell> getPossibleDestinations(Board board, Cell fromCell);
	public List<Cell> getPossibleCells(Board board);
}

package assignment1;

import java.util.List;

public interface IMoveStrategy {
	
	public enum MoveType{
		REGULAR("REGULAR"),
        SPECIAL("SPECIAL");
		
		private final String type;
        MoveType(final String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }
	}
	
	public Boolean isValidMove(Board board, Move move);
	public List<Move> getPossibleMoves(Board board);
	public List<Cell> getPossibleDestinations(Board board, Cell fromCell);
	public List<Cell> getPossibleCells(Board board);
}

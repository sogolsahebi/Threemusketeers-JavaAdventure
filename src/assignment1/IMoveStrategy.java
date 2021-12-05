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
	
	public List<Move> getPossibleMoves(Board board);
}

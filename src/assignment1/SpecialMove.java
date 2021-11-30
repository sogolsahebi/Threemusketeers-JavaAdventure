package assignment1;

import java.util.ArrayList;
import java.util.List;

public class SpecialMove implements IMoveStrategy {

	public Boolean isValidMove(Board board, Move move) {
        Cell fromCell = move.fromCell;
        Coordinate fromCoordinate = fromCell.getCoordinate();
        Coordinate toCoordinate = move.toCell.getCoordinate();

        if (!board.isNextTo(fromCoordinate, toCoordinate, 2)) return false;
        if (!board.onBoard(toCoordinate)) return false;

        return fromCell.getPiece().canMoveOnto(move.toCell);
    }
	
	public List<Cell> getPossibleCells(Board board) {
        List<Cell> allCellsThisTurn = board.getTurn() == Piece.Type.MUSKETEER ? board.getMusketeerCells() : board.getGuardCells();
        List<Cell> possibleCells = new ArrayList<>();
        for (Cell cell : allCellsThisTurn) {
            if (!getPossibleDestinations(board, cell).isEmpty())
                possibleCells.add(cell);
        }
        return possibleCells;
    }

    /**
     * Get all the possible cell destinations that is possible to move to from the fromCell.
     * @param fromCell The cell that has the piece that is going to be moved
     * @return List of cells that are possible to get to
     */
    public List<Cell> getPossibleDestinations(Board board, Cell fromCell) {
        List<Cell> destinations = new ArrayList<>();
        int[][] possibleMoves = {{-2,0}, {0,2}, {2,0}, {0,-2}};

        for (int[] move: possibleMoves) {
            Coordinate oldCoordinate = fromCell.getCoordinate();
            int row = move[0] + oldCoordinate.row;
            int col = move[1] + oldCoordinate.col;
            Coordinate newCoordinate = new Coordinate(row, col);
            if (!board.onBoard(newCoordinate)) continue;

            Cell toCell = board.getCell(newCoordinate);
            if (this.isValidMove(board, new Move(fromCell, toCell)))
                destinations.add(toCell);
        }
        return destinations;
    }

    /**
     * Get all the possible moves that can be made this turn.
     * @return List of moves that can be made this turn
     */
    public List<Move> getPossibleMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        List<Cell> possibleCells = this.getPossibleCells(board);
        for (Cell fromCell: possibleCells) {
            List<Cell> possibleDestinations = this.getPossibleDestinations(board, fromCell);
            for (Cell toCell : possibleDestinations) {
                moves.add(new Move(fromCell, toCell));
            }
        }
        return moves;
    }
}

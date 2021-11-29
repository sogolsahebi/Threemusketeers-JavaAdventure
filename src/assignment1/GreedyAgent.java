// RE UPDATED class! Should work for A3
package assignment1;

import java.util.List;

public class GreedyAgent extends Agent {
    Board boardCopy;
    BoardEvaluatorImpl boardEvaluator;
    int depth = 9;

    public GreedyAgent(Board board) {
        super(board);
        this.boardEvaluator = new BoardEvaluatorImpl();
    }

    /**
     * Gets a valid move that the GreedyAgent can do.
     * Uses MiniMax strategy with Alpha Beta pruning
     * @return a valid Move that the GreedyAgent can perform on the Board
     */
    @Override
    public Move getMove(IMoveStrategy.MoveType moveType) {
        boardCopy = new Board(board);
        double bestScore = boardCopy.getTurn().equals(Piece.Type.MUSKETEER) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        Move chosenMove = null;

        List<Move> possibleMoves = boardCopy.getMoveStrategy(moveType).getPossibleMoves(board);
        System.out.println("Moves:" + possibleMoves);
//        System.out.println("Moves:" + possibleMoves);
        for (Move move: possibleMoves) {
        	
            Move moveCopy = new Move(move);
            Piece.Type turn = boardCopy.getTurn();
            boardCopy.move(move);

            double score = this.minimax(depth - 1, Integer.MIN_VALUE, Integer.MAX_VALUE, moveType);

//            System.out.printf("Move: %s Score: %.2f\n", move, score);
            if (turn.equals(Piece.Type.MUSKETEER) && score > bestScore) {
            	
                bestScore = score;
                chosenMove = new Move(moveCopy);
                
            }
            else if (turn.equals(Piece.Type.GUARD) && score < bestScore) {
            	
                bestScore = score;
                chosenMove = new Move(moveCopy);
                
            }

            boardCopy.undoMove(moveCopy);
            
        }

        assert chosenMove != null;
//        System.out.printf("[%s (Greedy Agent)] Moving piece %s to %s. Best Score: %.2f\n",
//                board.getTurn().getType(), chosenMove.fromCell.getCoordinate(), chosenMove.toCell.getCoordinate(),
//                bestScore);
        return new Move(
                board.getCell(chosenMove.fromCell.getCoordinate()),
                board.getCell(chosenMove.toCell.getCoordinate()));
    }

    /**
     * Runs minimax with alpha beta pruning to find the optimal moves
     * Uses heuristics implemented by a BoardEvaluator
     *
     * @param depth a counter to stop the algorithm from going deeper than the given depth
     * @param alpha value used for alpha beta pruning
     * @param beta  value used for alpha beta pruning
     * @return Score of the board after the optimal move
     */
    private double minimax(int depth, double alpha, double beta, IMoveStrategy.MoveType moveType) {
    	
        if (depth == 0 || boardCopy.isGameOver()) {
        	
            return boardEvaluator.evaluateBoard(boardCopy);
            
        }

        double bestScore = boardCopy.getTurn().equals(Piece.Type.MUSKETEER) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        List<Move> possibleMoves = boardCopy.getMoveStrategy(moveType).getPossibleMoves(board);
        for (Move move: possibleMoves) {
        	
            Move moveCopy = new Move(move);
            Piece.Type turn = boardCopy.getTurn();
            boardCopy.move(move);

            double score = this.minimax(depth - 1, alpha, beta, moveType);

            if (turn.equals(Piece.Type.MUSKETEER)) {
            	
                bestScore = Math.max(bestScore, score);
                alpha = Math.max(alpha, bestScore);
                
            }
            else {
            	
                bestScore = Math.min(bestScore, score);
                beta = Math.min(beta, bestScore);
                
            }

            boardCopy.undoMove(moveCopy);

            if (beta <= alpha) {
                break;
            }
            
        }

        return boardEvaluator.evaluateBoard(boardCopy);
        
    }
    
}

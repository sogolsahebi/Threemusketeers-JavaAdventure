// RE UPDATED class! Should work for A3
package assignment1;

import java.util.List;
import java.util.Random;

public class RandomAgent extends Agent {

    public RandomAgent(Board board) {
        super(board);
    }

    /**
     * Gets a valid random move the RandomAgent can do.
     * @return a valid Move that the RandomAgent can perform on the Board
     */
    @Override
    public Move getMove(IMoveStrategy.MoveType moveType) {
        List<Cell> possibleCells = board.getMoveStrategy(moveType).getPossibleCells(board);
        Cell fromCell = possibleCells.get(new Random().nextInt(possibleCells.size()));

        List<Cell> possibleDestinations = board.getMoveStrategy(moveType).getPossibleDestinations(board, fromCell);
        Cell toCell = possibleDestinations.get(new Random().nextInt(possibleDestinations.size()));

        System.out.printf("[%s (Random Agent)] Moving piece %s to %s.\n",
                board.getTurn().getType(), fromCell.getCoordinate(), toCell.getCoordinate());
        return new Move(fromCell, toCell);
    }
}


//
//import java.util.List;
//import java.util.Random;
//public class RandomAgent extends Agent {
//
//    public RandomAgent(Board board) {
//        super(board);
//    }
//
//    /**
//     * Gets a valid random move the RandomAgent can do.
//     * @return a valid Move that the RandomAgent can perform on the Board
//     */
//    @Override
//    public Move getMove() { // TODO
//    	
//    	// need a list of all possible moves (use helpers that are given!)
//    	
//    	// generate random numbers using java.util.random or some other random tool!
//    	// then: probably want to randomize from 1 - possible moves (<25)
//    	// ie: 6 may appear randomly, then use the 6th possible moe!
//    	
//    	
//    	
//    	// import java.util.Random
//    	
//    	// use random on 0 - total number of possible cells that CAN move (guard cells / muskateer)
//    	// ie: guard.getPossibleDestinations...
//    	// ie: musketeer.getPossibleDestinations....
//    	
//    	Random rand = new Random();
//    	
//    //	rand.nextInt(5);
//    	
//    	
//    	List<Move> get_all_possible_moves = this.board.getPossibleMoves();
//    	
//    	int the_random_int = rand.nextInt(get_all_possible_moves.size());
//    	
//        return get_all_possible_moves.get(0);
//    }
//}

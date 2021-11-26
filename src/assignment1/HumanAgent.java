package assignment1;

import assignment1.Exceptions.InvalidMoveException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import assignment1.Exceptions.InvalidMoveException;

public class HumanAgent extends Agent {

    public HumanAgent(Board board) {
        super(board);
    }

    /**
     * Asks the human for a move with from and to coordinates and makes sure its valid.
     * Create a Move object with the chosen fromCell and toCell
     * @return the valid human inputted Move
     */
    @Override
    public Move getMove() { // TODO

    	System.out.println("Please enter a valid move by entering a digit representing the validMove from allPossibleMoves: ");

    	List<Move> all_possible_moves = this.board.getPossibleMoves();
    	
    	int index = 0;
    	
    	int the_index_for_move = 0;
    	for(Move move: all_possible_moves) {
    		
    		
    		if(the_index_for_move < all_possible_moves.size()) {
    			
    			System.out.print(the_index_for_move);
    		}
    		
    		System.out.print(" ");
    		
    		System.out.println(move);
    		

    		
    		the_index_for_move++;
    	}
    	
		
	    System.out.println("Enter a valid string int / integer representing the index of the move found in allPossibleMoves above: ");
	
	    
	    String user_string = "";
	        
	    boolean booly = false;
	    
    	while (booly == false) {
    		
    		// index < all_possible_moves.size()
    		
    		Scanner reader = new Scanner(System.in);  // Reading from System.in
    	    user_string = reader.nextLine(); // Scans the next token of the input as an int.
    	    
    	    try {
    	        int d = Integer.parseInt(user_string);
    	    } catch (NumberFormatException nfe) {
    	    	
    	    	System.out.println("Invalid move please enter an integer value that is valids");
    	    	
    	    	continue;
    	    }
    	    
    	    if (user_string.length() > 0) {
    	    	
    	    	if(Integer.parseInt(user_string) >= 0 && Integer.parseInt(user_string) < all_possible_moves.size()) {
        	    	
        	    	booly = true;
        	    }
    	    	else {
    	    		
    	    		System.out.println("Enter a valid string int / integer representing the index of the move found in allPossibleMoves above: ");

    	    	}
    	    }
    	    
    	    else {
    	    	
    	    	System.out.println("Enter a valid string int / integer representing the index of the move found in allPossibleMoves above: ");

    	    	
    	    }
    	    
    	}
    	
    	return all_possible_moves.get(Integer.parseInt(user_string));

    	
    	
    	
    }
}

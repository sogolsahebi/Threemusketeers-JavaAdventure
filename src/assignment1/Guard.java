// RE UPDATED class! Should work for A3
package assignment1;

public class Guard extends Piece {

    public Guard() {
        super("O", Type.GUARD);
    }

    /**
     * Returns true if the Guard can move onto the given cell.
     * @param cell Cell to check if the Guard can move onto
     * @return True, if Guard can move onto given cell, false otherwise
     */
	  public boolean canMoveOnto(Cell cell) {
		  
		  return !cell.hasPiece();
	  
	  }
    
//    @Override
//    public boolean canMoveOnto(Cell cell) { // TODO
//    	
//    	
//    	// Assuming cell is a guard!
//    	
//    	// Guard can only POTENTIALLY move up, down, left, right!
//    	// Only if those cells are empty (type is NULL I think, check Piece.Type for more info)
//    	
//    	
//    	// Only need to check the to_cell NOT up, dwon, left, right since this is the point of the function.
//    	
//    	
//    	Cell to_cell = cell;
//    	
//    	// we're assuming the given to_cell is a valid to_cell ie: up, down, left, or right (its okay to do so, as I check for it in my
//    	// ^ functions which can call canMoveOnto().
//    	
//    	if (to_cell.getPiece() == null) {			// "Piece is null if there is no piece." Perfect, thats exactly what we need!
//    		
//    		return true;
//    				
//    	}
//    	
//    	
//    	
//    	// remember: guard is a PIECE!
//    	//
//        return false;
//    }
}
//
//import javafx.scene.image.Image;
//
//public class Guard extends Piece {
//
//    public Guard() {
//        super("O", Type.GUARD, new Image("file:images/guard.png", 80, 80, true, true));
//    }
//
//    /**
//     * Returns true if the Guard can move onto the given cell.
//     * @param cell Cell to check if the Guard can move onto
//     * @return True, if Guard can move onto given cell, false otherwise
//     */
//    @Override
//    public boolean canMoveOnto(Cell cell) {
//        return !cell.hasPiece();
//    }
//}
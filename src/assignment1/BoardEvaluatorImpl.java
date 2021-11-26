package assignment1;

import java.util.ArrayList;
import java.util.List;
//
//public class BoardEvaluatorImpl implements BoardEvaluator {
//
//    /**
//     * Calculates a score for the given Board
//     * A higher score means the Musketeer is winning
//     * A lower score means the Guard is winning
//     * Add heuristics to generate a score given a Board
//     * @param board Board to calculate the score of
//     * @return int Score of the given Board
//     */
//    @Override
//    public int evaluateBoard(Board board) { // TODO
//    	
//    	
//    	List<Cell> musketeer_cells = board.getMusketeerCells();
//    	
//    	// LETS DO BETTER IDEA! count total number of musketeer paths and return that score!
//    	
//    	int total_musketeer_paths = 0;
//    	
//    	
//    	for(int index = 0; index < musketeer_cells.size(); index ++) {
//    		
//    		
//    		int all_possible_destinations = board.getPossibleDestinations(musketeer_cells.get(index)).size();
//    		
//    		total_musketeer_paths += all_possible_destinations;
//    	}
//    	
//    	
//    	
//    	return total_musketeer_paths;
//    	
//    	
//      //  return 0;
//        
//        
//        // DUMB IDEA:
//        // count total number of empty spaces, that == score, if higher ==> more empty spaces ==> more dead guards ==> muskateer winning
//        // less empty spaces ==> MORE guards ==> guards winning!
//        
//        
//        // ***************************** USE THIS IDEA *************************
//        // BETTER IDEA:
//        // Count total knight paths, more paths ==> more that knights are winning, less paths ==> less that knights are winnig.
//        
//        // ^^^ so with better idea: a move from guard that further restricts knight movement is ASWESOME or equal.s
//        // And a move from knight that LESS restricts movement is AWESOME: or equal.
//        
//        
//        // ************ NOTE ***********: greedy agent is GIVEN to us, and utilizes our heuristics in BoardEvaluation! Make it good!
//        
//        
//        
//        
//        
//        // WHY IS BETTER IDEA COOL? well, dumb idea definitely works, but it makes no distinction between the moves, ie: kngiht can kill
//        // ANY guards (and actually HAS to regardless), so no specific guard matters
//        // AND: guard's turn can never NOT move a guard, so it just moves any guard (since either movement doesnt kill a guard, any move is
//        // considered 'good')
//        // I KNOW FOR A FACT: this is bad/ wrong, as I MYSELF use my own brain AI to restrict knight movement as guard, or increase knight
//        // movement as knight (and specifically: reduce the 'connections' horizontal or veritcle as knight!
//    
//        
//        
//        // ANOTHER IDEA: get heuristic for a given board.
//        // or getHeuristic for a given MOVE ???
//    }
//}


import java.util.List;

public class BoardEvaluatorImpl implements BoardEvaluator {

    /**
     * Calculates a score for the given Board
     * A higher score means the Musketeer is winning
     * A lower score means the Guard is winning
     * Add heuristics to generate a score given a Board
     * @param board Board to calculate the score of
     * @return double Score of the given Board
     */
    @Override
    public double evaluateBoard(Board board) {
    	
    	// my idea: get all possible musketeer movements! max = 4 * 3 = 12. less moves = better for guards generally! not perfect tho
    	
//    	List<Cell> musk_cells = board.getMusketeerCells();
//    	
//    	int sum_possible_musk_moves = 0;
//    	
//    	for(int i = 0; i < musk_cells.size(); i++) {
//    		
//    		
//    		
//    		sum_possible_musk_moves += board.getPossibleDestinations(musk_cells.get(i)).size();
//    		
//    	}
//    	
//    	return sum_possible_musk_moves;
    	
    	//THEIR CODE BELOW:
        double score = 0;
        score += getRowColScore(board);
        score += getNumMusketeersPossibleMovesScore(board);
        score += getMusketeerDistanceScore(board);
        score += getGuardDistanceFromMusketeers(board);
        return score;
    }

    private double getRowColScore(Board board) {
        List<Cell> musketeerCells = board.getMusketeerCells();
        long numRows = musketeerCells.stream().map(cell -> cell.getCoordinate().row).distinct().count();
        long numCols = musketeerCells.stream().map(cell -> cell.getCoordinate().col).distinct().count();

        if (numRows == 1 || numCols == 1) return Integer.MIN_VALUE; // Game over. Guard wins.
        if (numRows == 2 || numCols == 2) return -15; // 2 Musketeers in same row or col.
        return 15; // All musketeers in different cols/rows.
    }

    private double getNumMusketeersPossibleMovesScore(Board board) {
        List<Cell> musketeerCells = board.getMusketeerCells();
        int numMusketeersCanMove = 0;
        for (Cell musketeerCell: musketeerCells) {
            if (board.getPossibleDestinations(musketeerCell).size() > 0) {
                numMusketeersCanMove += 1;
            }
        }
        return numMusketeersCanMove * -3;
    }

    private double getMusketeerDistanceScore(Board board) {
        List<Cell> musketeerCells = board.getMusketeerCells();
        Cell c1 = musketeerCells.get(0);
        Cell c2 = musketeerCells.get(1);
        Cell c3 = musketeerCells.get(2);

        int score = Math.abs(c1.getCoordinate().row - c2.getCoordinate().row)
                + Math.abs(c2.getCoordinate().row - c3.getCoordinate().row);
        score += Math.abs(c1.getCoordinate().col - c2.getCoordinate().col)
                + Math.abs(c2.getCoordinate().col - c3.getCoordinate().col);

        return score * 2;
    }

    private double getGuardDistanceFromMusketeers(Board board) {
        int score = 0;
        for (Cell musketeerCell: board.getMusketeerCells()) {
            int musketeerRow = musketeerCell.getCoordinate().row;
            int musketeerCol = musketeerCell.getCoordinate().col;
            for (Cell guardCell : board.getGuardCells()) {
                int guardRow = guardCell.getCoordinate().row;
                int guardCol = guardCell.getCoordinate().col;

                score += Math.abs(musketeerRow - guardRow);
                score += Math.abs(musketeerCol - guardCol);
            }
        }
        return score * 0.1;
    }
}
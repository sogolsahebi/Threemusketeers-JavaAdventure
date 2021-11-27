package assignment1;
//Hey this is A3's assignment1

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreeMusketeers {

    private final Board board;
    private Agent musketeerAgent, guardAgent;
    private final Scanner scanner = new Scanner(System.in);
    private final List<Move> moves = new ArrayList<>();
    private HintFactory hintFactory = new HintFactory();
    private Hint hint1, hint2;

    // All possible game modes
    public enum GameMode {
        Human("Human vs Human"),
        HumanRandom("Human vs Computer (Random)"),
        HumanGreedy("Human vs Computer (Greedy)");

        private final String gameMode;
        GameMode(final String gameMode) {
            this.gameMode = gameMode;
        }
    }

    /**
     * Default constructor to load Starter board
     */
    public ThreeMusketeers() {
        this.board = new Board();
    }

    /**
     * Constructor to load custom board
     * @param boardFilePath filepath of custom board
     */
    public ThreeMusketeers(String boardFilePath) {
        this.board = new Board(boardFilePath);
        this.hint1 = hintFactory.createHint(this.board, 0);
        this.hint2 = hintFactory.createHint(this.board, 1);
    }
    
    public ThreeMusketeers(String boardFilePath, String randomHintFilePath, String greedyHintFilePath) {
        this.board = new Board(boardFilePath);
        this.hint1 = hintFactory.loadHint(this.board, 0, randomHintFilePath);
        this.hint2 = hintFactory.loadHint(this.board, 1, greedyHintFilePath);
    }

    /**
     * Play game with human input mode selector
     */
    public void play(){
        System.out.println("Welcome! \n");
        final GameMode mode = getModeInput();
        System.out.println("Playing " + mode.gameMode);
        play(mode);
    }

    /**
     * Play game without human input mode selector
     * @param mode the GameMode to run
     */
    public void play(GameMode mode){
        selectMode(mode);
        runGame();
    }
    
    /**
     * Select to start a new game or load a saved game
     */
    public void newOrLoad() {
    	
    	switch(getStartOption()) {
    	
    		case "N":
    			play();
    			break;
    		case "L":
    			load();
    			break;
    	
    	}
    	
    }
    
    /**
     * Get the user input to load the board
     */
    public void load() {
    	
    	System.out.println("Enter the year when you save the board(four digits): ");
    	String year = scanner.next();
    	System.out.println("Enter the month when you save the board(two digits): ");
    	String month = scanner.next();
    	System.out.println("Enter the day when you save the board(two digits): ");
    	String day = scanner.next();
    	System.out.println("Enter the hour when you save the board(two digits): ");
    	String hour = scanner.next();
    	System.out.println("Enter the minute when you save the board(two digits): ");
    	String minute = scanner.next();
    	System.out.println("Enter the second when you save the board(two digits): ");
    	String second = scanner.next();
    	String time = year + "." + month + "." + day + "." + hour + "." + minute + "." + second;
    	String boardFilePath = "Boards/" + time + ".txt";
    	String randomHintFilePath = "Hint/random" + time + ".txt";
    	String greedyHintFilePath = "Hint/greedy" + time + ".txt";
    	
    	ThreeMusketeers game = new ThreeMusketeers(boardFilePath, randomHintFilePath, greedyHintFilePath);
    	game.play();
	
    }

    /**
     * Mode selector sets the correct agents based on the given GameMode
     * @param mode the selected GameMode
     */
    private void selectMode(GameMode mode) {
        switch (mode) {
            case Human -> {
                musketeerAgent = new HumanAgent(board);
                guardAgent = new HumanAgent(board);
            }
            case HumanRandom -> {
                String side = getSideInput();
                
                // The following statement may look weird, but it's what is known as a ternary statement.
                // Essentially, it sets musketeerAgent equal to a new HumanAgent if the value M is entered,
                // Otherwise, it sets musketeerAgent equal to a new RandomAgent
                musketeerAgent = side.equals("M") ? new HumanAgent(board) : new RandomAgent(board);
                
                guardAgent = side.equals("G") ? new HumanAgent(board) : new RandomAgent(board);
            }
            case HumanGreedy -> {
                String side = getSideInput();
                musketeerAgent = side.equals("M") ? new HumanAgent(board) : new GreedyAgent(board);
                guardAgent = side.equals("G") ? new HumanAgent(board) : new GreedyAgent(board);
            }
        }
    }

    /**
     * Runs the game, handling human input for move actions
     * Handles moves for different agents based on current turn 
     */
    private void runGame() {
        while(!board.isGameOver()) {
            System.out.println("\n" + board);

            final Agent currentAgent;
            if (board.getTurn() == Piece.Type.MUSKETEER)
                currentAgent = musketeerAgent;
            else
                currentAgent = guardAgent;

            if (currentAgent instanceof HumanAgent) // Human move
                switch (getInputOption()) {
                    case "M":
                        move(currentAgent);
                        break;
                    case "U":
                        if (moves.size() == 0) {
                            System.out.println("No moves to undo.");
                            continue;
                        }
                        else if (moves.size() == 1 || isHumansPlaying()) {
                            undoMove();
                        }
                        else {
                            undoMove();
                            undoMove();
                        }
                        break;
                    case "S":
                        saveOptions();
                        break;
                    case "H":
                    	hintOptions();
                    	break;
                }
            else { // Computer move
                System.out.printf("[%s] Calculating move...\n", currentAgent.getClass().getSimpleName());
                move(currentAgent);
            }
        }

        System.out.println(board);
        System.out.printf("\n%s won!%n", board.getWinner().getType());
    }
    
    private void saveOptions() {
    	
    	switch(getSaveOption()) {
    	
    		case "H":
    			SaveBuilder h = new SaveHint(board, hint1, hint2);
    			Save hs = h.getSave();
    			hs.save();
    			break;
    		case "A":
    			SaveBuilder a = new SaveAudience(board);
    			Save as = a.getSave();
    			as.save();
    			break;
    		case "B":
    			SaveBuilder b = new SaveBoard(board);
    			Save bs = b.getSave();
    			bs.save();
    			break;
    		case "E":
    			SaveBuilder e = new SaveEverything(board, hint1, hint2);
    			Save es = e.getSave();
    			es.save();
    			break;
    	
    	}
    	
    }
    
    private void hintOptions() {
    	
    	switch(getHintOption()) {
    	
		case "O":
			Move hintMove1 = hint1.getHint();
			if (hintMove1 != null) {
				
				System.out.println("The hint is: " + hintMove1);
				
			}
			break;
		case "T":
			Move hintMove2 = hint2.getHint();
			if (hintMove2 != null) {
				
				System.out.println("The hint is: " + hintMove2);
				
			}
			break;
	
    	}
    	
    }
    
//    private void newOrLoad() {
//    	
//    	switch(getHintOption()) {
//    	
//		case "O":
//			Move hintMove1 = hint1.getHint();
//			if (hintMove1 != null) {
//				
//				System.out.println("The hint is: " + hintMove1);
//				
//			}
//			break;
//		case "T":
//			Move hintMove2 = hint2.getHint();
//			if (hintMove2 != null) {
//				
//				System.out.println("The hint is: " + hintMove2);
//				
//			}
//			break;
//	
//    	}
//    	
//    }

    /**
     * Gets a move from the given agent, adds a copy of the move using the copy constructor to the moves stack, and
     * does the move on the board.
     * @param agent Agent to get the move from.
     */
    
    protected Move move(final Agent agent) {
        final Move move = agent.getMove();
        this.move(move);
        return move;
    }

    /**
     * Do the given move on the board and add a copy to the moves list.
     */
 
    protected void move(Move move) {
        moves.add(new Move(move));
        board.move(move);
    }

    /**
     * Removes a move from the top of the moves stack and undoes the move on the board.
     */
    public void undoMove() {
        if (moves.size() == 0) {
            System.out.println("No moves to undo.");
            return;
        }
        if (moves.size() == 1 || isHumansPlaying() || gameOverUndoCondition()) {
            board.undoMove(moves.remove(moves.size() - 1));
        } else {
            board.undoMove(moves.remove(moves.size() - 1));
            board.undoMove(moves.remove(moves.size() - 1));
        }
        System.out.println("Undid the previous move.");
    }
    
    private boolean gameOverUndoCondition() {
        Piece.Type fromPieceType = moves.get(moves.size() - 1).fromCell.getPiece().getType();
        return board.isGameOver()
                && ((fromPieceType.equals(Piece.Type.MUSKETEER) && musketeerAgent instanceof HumanAgent)
                || (fromPieceType.equals(Piece.Type.GUARD) && guardAgent instanceof HumanAgent));
    }

    
    /**
     * Get human input for move action
     * @return the selected move action, 'M': move, 'U': undo, and 'S': save
     */
    private String getInputOption() {
        System.out.printf("[%s] Enter 'M' to move, 'U' to undo, 'S' to save, and 'H' for hint: ", board.getTurn().getType());
        while (!scanner.hasNext("[MUSHmush]")) {
            System.out.print("Invalid option. Enter 'M', 'U', 'S', or 'H': ");
            scanner.next();
        }
        return scanner.next().toUpperCase();
    }
    
    private String getSaveOption() {
        System.out.printf("[%s] Enter 'H' to save hint with the boarde, 'A' to save audience with the board, "
        		+ "'B' to save the board alone, or 'E' to save everything: ", board.getTurn().getType());
        while (!scanner.hasNext("[HABEhabe]")) {
            System.out.print("Invalid option. Enter 'H', 'A', 'B', or 'E': ");
            scanner.next();
        }
        return scanner.next().toUpperCase();
    }
    
    private String getHintOption() {
    	
    	System.out.printf("[%s] Enter 'O' to get level one hint, or 'T' to get level two hint: ", board.getTurn().getType());
        while (!scanner.hasNext("[OTot]")) {
            System.out.print("Invalid option. Enter 'O', or 'T': ");
            scanner.next();
        }
        return scanner.next().toUpperCase();
    	
    }
    
    private String getStartOption() {
    	
    	System.out.printf("Enter 'N' to start a new game, or 'L' to load a saved game: ", board.getTurn().getType());
        while (!scanner.hasNext("[NLnl]")) {
            System.out.print("Invalid option. Enter 'N', or 'L': ");
            scanner.next();
        }
        return scanner.next().toUpperCase();
    	
    }

    /**
     * Returns whether both sides are human players
     * @return True if both sides are Human, False if one of the sides is a computer
     */
    private boolean isHumansPlaying() {
        return musketeerAgent instanceof HumanAgent && guardAgent instanceof HumanAgent;
    }

    /**
     * Get human input for side selection
     * @return the selected Human side for Human vs Computer games,  'M': Musketeer, G': Guard
     */
    private String getSideInput() {
        System.out.print("Enter 'M' to be a Musketeer or 'G' to be a Guard: ");
        while (!scanner.hasNext("[MGmg]")) {
            System.out.println("Invalid option. Enter 'M' or 'G': ");
            scanner.next();
        }
        return scanner.next().toUpperCase();
    }

    /**
     * Get human input for selecting the game mode
     * @return the chosen GameMode
     */
    private GameMode getModeInput() {
        System.out.println("""
                    0: Human vs Human
                    1: Human vs Computer (Random)
                    2: Human vs Computer (Greedy)""");
        System.out.print("Choose a game mode to play i.e. enter a number: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid option. Enter 0, 1, or 2: ");
            scanner.next();
        }
        final int mode = scanner.nextInt();
        if (mode < 0 || mode > 2) {
            System.out.println("Invalid option.");
            return getModeInput();
        }
        return GameMode.values()[mode];
    }

    public static void main(String[] args) {    	
        String boardFileName = "Boards/Starter.txt";
        ThreeMusketeers game = new ThreeMusketeers(boardFileName);
        game.newOrLoad();
    }
}
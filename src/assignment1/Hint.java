package assignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Hint {

	private Agent agent;
	private Board board;
	private int lvl;
	private Move move;
	private String hintNum;
	private String hintName;
	
    /**
     * Create new hints
     * @param board The board of the game, lvl The level of the hint, hintName The name of the hint
     */
	public Hint(Board board, int lvl, String hintName) {
		
		this.board = board;
		this.lvl = lvl;
		this.hintNum = "1";
		this.hintName = hintName;
		
	}
	
    /**
     * Load hints
     * @param board The board of the game, lvl The level of the hint,
     *        hintName The name of the hint, hintFilePath The file path to load hint from
     */
	public Hint(Board board, int lvl, String hintName, String hintFilePath) {
		
		this.board = board;
		this.lvl = lvl;
		this.hintName = hintName;
		this.loadHint(hintFilePath);
		
	}
	
    /**
     * Gets the hint move
     * @return a move if there is still hint left, null other wise
     */
	public Move getHint() {
		
		if (lvl == 0) {
			
			if (hintNum == "1") {
				
				agent = new RandomAgent(board);
				
			}
			else {
				
				System.out.println("Ooops! You ran out of level one hint.");
				
				return null;
				
			}
			
		}
		else if (lvl == 1) {
			
			
			if (hintNum == "1") {
				
				agent = new GreedyAgent(board);
				
			}
			else {
				
				System.out.println("Ooops! You ran out of level two hint.");
				
				return null;
				
			}
			
		}
		hintNum = "0";
		move = agent.getMove(new RegularMove());
		
		return move;
		
	}
    /**
     * Save the hints to local
     */
	public void saveHint() {
		
		String filePath = String.format("hint/" + hintName + "%s.txt",
                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
        File file = new File(filePath);
        try {
        	
            file.createNewFile();
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));;
            writer.write(hintNum + "\n");
            writer.close();
            System.out.printf("Saved hint to %s.\n", filePath);
            
        } catch (IOException e) {
        	
            e.printStackTrace();
            System.out.printf("Failed to save hint to %s.\n", filePath);
            
        }
        
    }
	
    /**
     * Load the hints from local file path
     * @param filePath The file path to load hint from
     */
	public void loadHint(String filePath) {
		
        File file = new File(filePath);
        Scanner scanner = null;
        try {
        	
            scanner = new Scanner(file);
            hintNum = scanner.nextLine();
            scanner.close();
            System.out.printf("Loaded hint from %s.\n", filePath);
            
        } catch (FileNotFoundException e) {
        	
            System.out.println("No saved hints with this board");  
            
        }
		
	}
	
}

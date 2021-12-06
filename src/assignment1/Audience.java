// TIME CLASS??

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

// NOTE: 

// NOTES FOR AUDIENCE CLASS: (methods, variables, inheritence)

// How it will be used: 
// - The audience class will utilize the Observer Pattern.
// - The audience is the observer (class Audience), and it is observing Game Observable (class)
// - Audience communicates with the Game Observable class (ThreeMusketeers.java) using the .react()
// method
// - ...

public class Audience implements theObserver{

	
	// Fields (variables the instances of Audience utilize
	
	
	// NEED emotional_score below for the observer pattern.
	private int emotional_score = 0;		// this is the emotional score of the members of the audience
	
	private String name = "";				
	
	private String message = "";		
	
	private String reaction = "...";		// starts off blank, ..., to indicate no reaction just yet.
	
	// private String[] reactions;
	
		
//	
//	"Bob says f you!"
//	
//	"Random Audience Member says I hate you!"
	
	//////
	// IDEA: guard audience and musketeer audience??
	//////
	
	
	// Primary constructor with nothing passed in:
	
	public Audience() {
		
		this.name = "An audience member";				// default name is 'an audience member', = random member
				
		this.message = "Nice move!";		// default message is just "nice"
		
		
		// this.reactions = new String[5];		// default amount = 5 reactions, can add more if you please
											// ie: ["nice", "I hate you", "you killed my brother joe!", "terrible move!", "bad!"]
		
	}
	
	// Secondary constructor with name and message passed in
	
	public Audience(String name, String message) {

		this.name = name;	// sets the name to the given name
				
		this.message = message;		// sets the message to the given message
		
		
		
		
		
	//	this.reactions = new String[5];			// This will likely be changed when called upon, ie: Audience member1 = new Audience("john", "I HATE you!")
												// ^ 												member1.reactions = {"f you!", "kill them all!', 
		
	}
	
	
	public Audience(String name, String message, String filePath) {

		this.name = name;	// sets the name to the given name
				
		this.message = message;		// sets the message to the given message
		
		
		this.loadScore(filePath);
		
		
	//	this.reactions = new String[5];			// This will likely be changed when called upon, ie: Audience member1 = new Audience("john", "I HATE you!")
												// ^ 												member1.reactions = {"f you!", "kill them all!', 
		
	}
	
	
	// THIS REACTION: depends on emotional_score.
	// ^ prints out a reaction.
	public int react() {
		
		String the_string = this.name + " says: " + this.message;
		
		             
		if(this.emotional_score < 5) {
			
			this.reaction = the_string + "... This is boring, not enough blood shed.";
			
			
		}
		else if(this.emotional_score >= 5 && this.emotional_score < 10) {
			
			this.reaction = the_string + "... Much blood has been shed: 5 lives.";
		}
		else {
			
			
			this.reaction = the_string + "... Way too much blood has been shed: more than 10 lives!. Brace yourselves!.";
		}
		
		
		
		System.out.println(this.reaction);
		return emotional_score;
		
		
	}
	
	
	// THIS METHOD BELOW IS: probably not nessesary...
	public String getReaction() {
		//NOTE: if this.react() has not been called on the audience member, this makes the reaction blank, MAKES SENSE!
		
		// until a reaction has occured ie: printed, this.reaction should not update...
		
		return this.reaction;
	}
	
	public void saveScore() {
		String filePath = String.format("reactions/%s.txt",
		new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		File file = new File(filePath);
		
		
	    try {
		    	
		    	
	      file.createNewFile();
	      Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
	      writer.write(this.emotional_score + "\n");
		  
		      
		      
		      writer.close();
		      System.out.printf("Saved reaction to %s.\n", filePath);
		  } catch (IOException e) {
		      e.printStackTrace();
		      System.out.printf("Failed to save reaction to %s.\n", filePath);
		  }
		
		
	}
	
	//
	// USE THE SCORE INSTEAD OF REACTION.
	
	// ***** WARNING **** USE: 

	private void loadScore(String filePath) {
		
		// precond file path is valid, if its not, catch catches it.
		
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            
            this.emotional_score = Integer.parseInt(scanner.nextLine());		// saves the reaction using scanner.nextLine()
            
            
            scanner.close();
            System.out.printf("Loaded reaction(s) from %s.\n", filePath);
        } catch (FileNotFoundException e) {
            System.out.println("No saved reaction(s) with this board");
            
            
            //System.exit(1);
        }
        
        
        
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		this.emotional_score += 1;				// every round ==> 1 guard killed => 1 more anger point / emotional point for each audience member.
	}
	


}

package assignment1;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class MediaPlayer {
	
	void play(String musicLocation){
		 
		 
	 try {
	 File musicPath = new File(musicLocation);
	 if(musicPath.exists()) {
		 AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
		 Clip clip = AudioSystem.getClip();
		 clip.open(audioInput);
		 clip.start();
		 clip.loop(Clip.LOOP_CONTINUOUSLY);
		 
//		 clip.playcontinously
//		 
//		 
//		 
		 
//		long start = System.currentTimeMillis();
//		// some time passes
//		long end = System.currentTimeMillis();
//		long elapsedTime = end - start;
		 
		
	

		long original_time = System.currentTimeMillis();
		
		
		boolean time_up = false;
		
		while(!time_up) {
			
			long current_time = System.currentTimeMillis();
			
			long elapsedTime = current_time - original_time;
		
			long five_seconds = 5000;
			
			if (elapsedTime >   five_seconds) {
				time_up = true;
						
						
				clip.stop();
				
			}
				
			
		}
			


				
				
		 
		 
		 
		 //clip.loop(Clip.LOOP_CONTINUOUSLY);

		 
		 
		 //		 JOptionPane.showMessageDialog(null , "Hit ok to pause");
//		 long clipTimePosition = clip.getMicrosecondPosition();
//		 clip.stop();
//		 
//		 JOptionPane.showMessageDialog(null , "Hit ok to resume");
//		 clip.setMicrosecondPosition(clipTimePosition);
//		 clip.start();
//		  
//		 JOptionPane.showMessageDialog(null , "Press Ok to stop play");
		 
	
		 
	 }
	 else {
		 System.out.print("cant find file");
	 }
	 }
	 catch(Exception ex) {
		 ex.printStackTrace();
	 }
	
	
	
	}
}

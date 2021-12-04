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
		 JOptionPane.showMessageDialog(null , "Hit ok to pause");
		 long clipTimePosition = clip.getMicrosecondPosition();
		 clip.stop();
		 
		 JOptionPane.showMessageDialog(null , "Hit ok to resume");
		 clip.setMicrosecondPosition(clipTimePosition);
		 clip.start();
		  
		 JOptionPane.showMessageDialog(null , "Press Ok to stop play");
		 
	
		 
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

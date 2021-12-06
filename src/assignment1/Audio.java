package assignment1;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio extends Thread{
	private String path = new String();
	private int time;
	
	public Audio(String path, int time) {
		this.path = path;
		this.time = time;
	}

	public static void playAudio(String path, int time) {
		Audio audio = new Audio(path, time);
		audio.start();
	}
	
	public void run() {
		try {
			File musicPath = new File(path);
			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				long original_time = System.currentTimeMillis();
				boolean time_up = false;
				while(!time_up) {
					long current_time = System.currentTimeMillis();
					long elapsedTime = current_time - original_time;
					long five_seconds = time;
					if (elapsedTime >   five_seconds) {
						time_up = true;
						clip.stop();	
					}	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

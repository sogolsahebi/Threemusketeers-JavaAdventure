package assignment1;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Container;
import java.io.File;

	

public class MediaPLayer {
	JFrame window;
	Container con;
	JPanel buttonPanel;
	JButton soundButton;
	String clickSound;
	ButtonHandler bHandler = new ButtonHandler();
	SoundEffect se = new SoundEffect();
	
	
	
	public MediaPLayer() {
		window = new JFrame();
		window.setSize(8 , 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();		
		window.setVisible(true);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(300, 300,200,100);
		buttonPanel.setBackground(Color.black);
		con.add(buttonPanel);
		
		soundButton = new JButton("sound Effect");
		soundButton.setFocusPainted(false);
		soundButton.addActionListener(bHandler);
		buttonPanel.add(soundButton);
		
		clickSound = "/assignment3-the-three-plus-one-musketeers/sound/audioTrack1.wav";
		
		
	}
	public class SoundEffect{
		Clip clip;
		
		public void setFile(String soundFileName) {
			try {
				File file = new File(soundFileName);
				AudioInputStream sound = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(sound);
			}
			catch(Exception e) {
				
			}
		}
	public void play() {
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	public class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			se.setFile(clickSound);
			se.play();
			
		}
		
	}
}

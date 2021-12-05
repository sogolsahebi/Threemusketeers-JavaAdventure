package assignment1;

public class Audio extends Thread{
	private MediaPlayer mediaPlayer = new MediaPlayer();
	private String path = new String();
	
	public Audio(String path) {
		this.path = path;
	}

	public static void playAudio(String path) {
		Audio audio = new Audio(path);
		audio.start();
	}
	
	public void run() {
		long originalTime = System.currentTimeMillis();
		boolean timesUp = false;
		
		mediaPlayer.play(path);
		while (!timesUp) {
			long elapsedTime = System.currentTimeMillis() - originalTime;
			
			if (elapsedTime > 5000) {
				mediaPlayer.play
			}
		}
		
		Thread.sleep(5000);
		
		return;
	}
}

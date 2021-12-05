package assignment1;


public class AduioAdapter implements MoveInterface{
	
	MediaPlayer mediaPlayer = new MediaPlayer();
	
	public AduioAdapter(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}
	
	@Override
    public String toString(){ 
		return  "choose the sound effect(optional)" ;
	}
	public void playaudio(String filepath){
		
		mediaPlayer.play(filepath);
			
		
	}
}

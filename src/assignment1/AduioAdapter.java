package assignment1;


public class AduioAdapter implements MoveInterface{
	
	MediaPLayer mediaPlayer = new MediaPLayer();
	Move move;
	
	public AduioAdapter(MediaPLayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}
	
	@Override
    public String toString(){ 
		return  "choose the sound effect(optional)" ;
	}
	
	public MediaPLayer playaudio(){
		return this.mediaPlayer;
			
	}
}

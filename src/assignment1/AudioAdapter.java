package assignment1;

import java.util.ArrayList;
import java.util.List;

public class AudioAdapter implements IMoveStrategy{
	
	MediaPlayer mediaPlayer = new MediaPlayer();
	
	public AudioAdapter(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}
	
	@Override
    public String toString(){ 
		return  "choose the sound effect(optional)" ;
	}
	
	public List<Move> getPossibleMoves(Board board) {
		List<Move> moves = new ArrayList<>();
		return moves;
	}
	
	public void playAudio(String path){	
		mediaPlayer.play(path);
	}
}

package assignment1;

public interface theObserver {
	
	// theObserver is the same as Observer interface, and Audience will implement it. It just has update I believe
	//
	public void update();		// since each turn implies 1 guard killed, our update needs not pass in paramaeters, just += 1 to emotional score.
								// ^ this is because emotional score is a 1 : 1 correspondent with guards killed (which corresponds to rounds played)

}

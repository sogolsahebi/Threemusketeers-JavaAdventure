// RE UPDATED class! Should work for A3


// NEED to make ThreeMusketeers Implement gameObserverable interface, where we addd, remove and notify observers.
package assignment1;

//
// This is our GameObservable interface, which is supposed to be implemented by our observable class 'ThreeMusketeers.java'

public interface GameObservable {
	
	
	
	// WAIT: what is an observer
	public void registerObserver(Audience member);		// all observers are audience members = audience objects. Can use that instead I believe.
	
	public void unregisterObserver(Audience member);
	
	public void notifyObservers();						// called 'observers' as we can notify more than 1 observer at a time - this is the whole idea of the observer pattern.


	
	
	
	// ADD this below ???:
	// public void getObserverReaction(); 
}

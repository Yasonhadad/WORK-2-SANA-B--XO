package XO;

public class UserPlayer extends Player {

	private Game game; // Reference to the game this player is part of

	public UserPlayer(PlayerType type, Game game) {
		super(type); // Call the constructor of the superclass (Player) with the player type
		this.game = game; // Initialize the game reference
	}

	@Override
	public void run() {
		// This method is called when the player's thread is started
		game.play(this); // Start playing the game. 'this' refers to this UserPlayer instance
	}

}

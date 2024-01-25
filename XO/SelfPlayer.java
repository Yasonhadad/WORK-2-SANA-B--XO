package XO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelfPlayer extends Player {
    
    private Game game; // Reference to the game this player is part of

    public SelfPlayer(PlayerType type, Game game) {
        super(type); // Call the constructor of the superclass (Player) with the player type
        this.game = game; // Initialize the game reference
    }

    @Override
    public void run() {
        // This method is called when the player's thread is started
        game.play(this); // Start playing the game. 'this' refers to this SelfPlayer instance
    }
}

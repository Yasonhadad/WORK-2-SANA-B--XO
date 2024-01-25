package XO;

public abstract class Player extends Thread {
    protected PlayerType type; // Player type (X or O)
    protected Game game; // Reference to the game this player is part of

    public Player(PlayerType type) {
        this.type = type; // Initialize the player with a specific type (X or O)
    }

    // Abstract method run. This needs to be implemented in concrete subclasses.
    // This method will define the player's behavior when their thread is started.
    @Override
    public abstract void run();
}

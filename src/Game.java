import java.io.IOException;


public interface Game {
	public void incrementScore();
	public void incrementTime();
	public void createGameObjects() throws IOException;
}

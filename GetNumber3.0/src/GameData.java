import utils.NumberUtils;

public class GameData {

	private Integer maxNumberOfGuesses;
	private Integer numberToGuess;
	private Player[] players;
	
	public GameData(Integer maxNumberOfGuesses, Player[] players) {
		this.maxNumberOfGuesses = maxNumberOfGuesses;
		numberToGuess = NumberUtils.generateRandomNumber(maxNumberOfGuesses);
		this.players = players;
	}


	public Integer getMaxNumberOfGuesses() {
		return maxNumberOfGuesses;
	}


	public void setMaxNumberOfGuesses(Integer maxNumberOfGuesses) {
		this.maxNumberOfGuesses = maxNumberOfGuesses;
	}


	public Integer getNumberToGuess() {
		return numberToGuess;
	}


	public Player[] getPlayers() {
		return players;
	}

	
}

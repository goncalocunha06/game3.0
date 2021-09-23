import java.util.Scanner;

import utils.NumberUtils;

public class Main {

	public static void main(String[] args) {

		System.out.println("Wanna play a little game? \n I will pick a number and the first to get it right wins !!");
		Scanner scanner = new Scanner(System.in);
		GameData gameData = gameConfig(scanner);

		play(scanner, gameData);

	}

	public static void play(Scanner scanner, GameData gameData) {
		Player[] listOfPlayers = gameData.getPlayers();
		Integer gameGoal = gameData.getNumberToGuess();
		Integer[] listOfGuesses = new Integer[0];
		Integer guess = -1; // TODO

		while (guess != gameGoal) {
			for (int i = 0; i < listOfPlayers.length; i++) {
				System.out.println("What number am i thinking " + listOfPlayers[i].getName() + "?");
				String guessStr = scanner.nextLine();

				
				if (!NumberUtils.isNumeric(guessStr) || (Integer.valueOf(guessStr) < 0
						|| Integer.valueOf(guessStr) >= gameData.getMaxNumberOfGuesses())) {
					//Quando está fora do intervalo admitido
					System.out.println("Your number is not valid! PAY ATTENCION MF");

				} else if (isGuessInList(listOfGuesses, Integer.valueOf(guessStr))) {
					//Quando já foi escolhido
					System.out.println("Pay attencion, that number was already picked");
				} else {

					guess = Integer.valueOf(guessStr);
					if (guess == gameGoal) {
						System.out.println("The winner is " + listOfPlayers[i].getName());
						break;
					} else {
						listOfGuesses = addGuess(listOfGuesses, guess);
					}
				}
			}
		}
	}

	public static GameData gameConfig(Scanner scanner) {

		System.out.println("The number should be between 0 and ..?");

		String gameMaxStr = scanner.nextLine();

		while (!NumberUtils.isNumeric(gameMaxStr) || Integer.valueOf(gameMaxStr) <= 0) {
			System.err.println("That's not a valid number. Please try again:");
			gameMaxStr = scanner.nextLine();
		}

		Integer gameMax = Integer.valueOf(gameMaxStr);

		System.out.println("How many players??");

		String numberOfPlayersStr = scanner.nextLine();

		while (!NumberUtils.isNumeric(numberOfPlayersStr) || Integer.valueOf(numberOfPlayersStr) <= 0) {
			System.err.println("That's not a valid number. Please try again:");
			numberOfPlayersStr = scanner.nextLine();
		}

		Integer numberOfPlayers = Integer.valueOf(numberOfPlayersStr);

		Player[] players = new Player[numberOfPlayers];

		for (int i = 0; i < players.length; i++) {
			players[i] = insertPlayer(scanner);
			players[i].setNumber(i);
		}

		return new GameData(gameMax, players);

	}

	public static Player insertPlayer(Scanner scanner) {

		System.out.println("What is your name?");

		String playerName = scanner.nextLine();
		Player player = new Player(playerName);

		return player;

	}

	public static Integer[] addGuess(Integer[] listOfGuesses, Integer guess) {

		int n = listOfGuesses.length;
		Integer[] newListOfGuesses = new Integer[n + 1];
		for (int i = 0; i < listOfGuesses.length; i++) {
			newListOfGuesses[i] = listOfGuesses[i];
		}
		newListOfGuesses[n] = guess;

		return newListOfGuesses;
	}

	public static Boolean isGuessInList(Integer[] listOfGuesses, Integer guess) {
		for (int i = 0; i < listOfGuesses.length; i++) {
			if (listOfGuesses[i] == guess) {
				return true;
			}
		}
		return false;
	}

}

import java.util.Scanner;

public class TicTacToeApp {

	public static void main(String[] args) {
		// variables
		boolean gameIsOver = false;
		char playAgain = 'y';
		int playerXRow, playerXCol, playerORow, playerOCol;

		TicTacToeClass game1 = new TicTacToeClass();	// create TicTacToe game
		System.out.println("Welcome to Tic-Tac-Toe Player X and Player O! Player X will go first.");
		Scanner scan = new Scanner(System.in);	// open scanner
				
		do {	// playAgain loop
			while(gameIsOver==false) {	// play the game while game is not over
				// X turn
				System.out.println();
				game1.displayBoard();
				System.out.print("\n'X', choose your location (row, column): ");
				playerXRow = scan.nextInt();
				playerXCol = scan.nextInt();
				game1.playMove('X', playerXRow, playerXCol);
						
				if(game1.isWinner('X') == true) {
					System.out.println();
					game1.displayBoard();
					System.out.println("\nCongratulations Player X, you won!");
					break;
				} else if(game1.isCat() == true) {
					System.out.println();
					game1.displayBoard();
					System.out.println("\nIt's a tie!");
					break;
				}	
				// O turn
				System.out.println();
				game1.displayBoard();
				System.out.print("\n'O', choose your location (row, column): ");
				playerORow = scan.nextInt();
				playerOCol = scan.nextInt();
				game1.playMove('O', playerORow, playerOCol);
						
				if(game1.isWinner('O') == true) {
					System.out.println();
					game1.displayBoard();
					System.out.println("\nCongratulations Player O, you won!");
					gameIsOver = true;
				}
				// X is always the first player, O will never have a chance to be the last move before a tie
			}
			gameIsOver = false;	// reset value so the game can be played again if applicable
			game1.clearBoard(); // reset board so the game can be played again if applicable
			game1.resetTurns(); // reset turns so the game can be played again if applicable
			System.out.print("\nWould you like to play again? (y/n): ");	// ask if the user wants to play again
			playAgain = scan.next().charAt(0);
		} while(playAgain=='y');
		System.out.println("\nThanks for playing!");
		scan.close();
	}
	
}
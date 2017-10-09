import java.util.Scanner;
import java.io.Console;
/**
 * Game
 */
public class Game 
{
    private Player currentTurn;
    private Player opponent;
    private int turnCounter;
    private Player player1;
    private Player player2;
    private int boardSize;
    public Game (int boardSize) 
    {
        this.boardSize = boardSize;
    }
    
    public void play()
    {
        Scanner in = new Scanner(System.in);
        Console c = System.console();
        System.out.println("Starting to play game!");
        System.out.print("Enter Player 1 name: ");
        String input = in.next();
        player1 = new Player(input, boardSize);
        System.out.println("Hi " + player1 + "!");
        player1.placeShips(2);
        System.out.print("Enter Player 2 name: ");
        input = in.next();
        player2 = new Player(input, boardSize);
        System.out.println("Hi " + player2 + "!");
        player2.placeShips(2);

        for (int i = 0; i < 10; i++)
        {
            if (currentTurn == player2)
            {
                currentTurn = player1;
                opponent = player2;
            }
            else
            {
                currentTurn = player2;
                opponent = player1;
            }
            System.out.println(currentTurn + " it is your turn! Here is your board");
            System.out.println(currentTurn.getBoard());
            System.out.println("Here is your opponent's board");
            System.out.println(opponent.getBoard().toStringOpponent());
            System.out.print("Enter coordinates to hit: ");
            int xcoord = in.nextInt();
            int ycoord = in.nextInt();
            Ship hitShip = opponent.getBoard().hit(xcoord, ycoord);
            if (hitShip != null)
            {
                if (hitShip.getHitCount() >= hitShip.getLength())
                {
                    System.out.println(currentTurn + ", you sunk " + opponent + "'s " + hitShip.getName() + "! :)");
                }
                else
                {
                    System.out.println(currentTurn + ", you hit " + opponent + "'s " + hitShip.getName() + "!");
                }
            }
            else
            {
                System.out.println(currentTurn + ", you missed! :(");
            }
            c.readLine();
            hitShip = null;
            System.out.println(opponent.getBoard().toStringOpponent());
        }

    }
}
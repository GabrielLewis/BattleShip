import java.util.Scanner;

/**
 * Player
 */
public class Player 
{
    private boolean myTurn;
    private Board board;
    private String name;

    public Player (String name, int boardSize) 
    {
        this.name = name;
        board = new Board(boardSize);
        myTurn = false;
    }

    /**
     * 
     */
    public String toString()
    {
        return name;
    }

    /**
     * 
     */
    public Board getBoard()
    {
        return board;
    }

    public void placeShips(int numShips)
    {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < numShips; i++)
        {
            System.out.print("Place your battleship: ");
            int xcoord = in.nextInt();
            int ycoord = in.nextInt();
            String orientation = in.next();
            Ship ship = new Ship(xcoord, ycoord, 5, orientation.charAt(0));
            board.placeShip(ship);
            System.out.println(board);
        }
    }
}
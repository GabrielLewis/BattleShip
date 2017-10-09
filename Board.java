import java.util.ArrayList;

/**
 * Board
 */
public class Board 
{
    private int size;
    private ArrayList<Ship> ships;
    private Cell[][] grid;
    public Board (int boardSize) 
    {
        size = boardSize;
        grid = new Cell[size][size];
        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                grid[row][col] = new Cell(row + 1, col + 1);
            }
        }
        ships = new ArrayList<>();
    }
    public String toStringOpponent()
    {
        final int SINGLEDIGIT = 9;
        String toReturn = "   ";
        for (int col = 0; col < size; col++)
        {
            if ( col + 1 > SINGLEDIGIT)
            {
                toReturn = toReturn + (col + 1) + " ";
            }
            else
            {
                toReturn = toReturn + " " + (col + 1) + " ";
            }
            
        }
        toReturn = toReturn + "\n";
        for (int row = 0; row < size; row++)
        {
            if ( row + 1 > SINGLEDIGIT)
            {
                toReturn = toReturn + (row + 1) + " ";
            }
            else
            {
                toReturn = toReturn + " " + (row + 1) + " ";
            }
            for (int col = 0; col < size; col++)
            {
                toReturn = toReturn + grid[row][col].toStringOpponent();
            }
            toReturn = toReturn + "\n";
        }
        return toReturn;
    }
    
    public String toString()
    {
        final int SINGLEDIGIT = 9;
        String toReturn = "   ";
        for (int col = 0; col < size; col++)
        {
            if ( col + 1 > SINGLEDIGIT)
            {
                toReturn = toReturn + (col + 1) + " ";
            }
            else
            {
                toReturn = toReturn + " " + (col + 1) + " ";
            }
            
        }
        toReturn = toReturn + "\n";
        for (int row = 0; row < size; row++)
        {
            if ( row + 1 > SINGLEDIGIT)
            {
                toReturn = toReturn + (row + 1) + " ";
            }
            else
            {
                toReturn = toReturn + " " + (row + 1) + " ";
            }
            for (int col = 0; col < size; col++)
            {
                toReturn = toReturn + grid[row][col];
            }
            toReturn = toReturn + "\n";
        }
        return toReturn;
    }
    
    public void placeShip(Ship ship)
    {
        ships.add(ship);
        if (ship.isHorizontal())
        {
            for (int i = 0; i < ship.getLength(); i++)
            {
                grid[ship.getYcoord() - 1][ship.getXcoord() + i - 1].setOccupied(ship);
            }
        }
        else
        {
            for (int i = 0; i < ship.getLength(); i++)
            {
                grid[ship.getYcoord() + i - 1][ship.getXcoord() - 1].setOccupied(ship);
            }
        }
    }
    public Ship hit(int xcoord, int ycoord)
    {
        grid[ycoord - 1][xcoord - 1].hit();
        if(grid[ycoord - 1][xcoord - 1].hasShip())
        {
            return grid[ycoord - 1][xcoord - 1].getShip();
        }
        return null;
    }
}
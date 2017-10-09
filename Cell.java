/**
 * Cell
 */
public class Cell 
{
    private boolean hasShip;
    private Ship ship;
    private boolean isHit;
    private int xcoord;
    private int ycoord;

    public Cell ( int ycoord, int xcoord) 
    {
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        hasShip = false;
        isHit = false;
    }
    public String toStringOpponent()
    {
        char character;
        if (isHit)
        {
            character = hasShip ? 'X' : 'O';
        }
        else
        {
            character = '-';
        }
        return " " + character + " " ;
    }

    public String toString()
    {
        char character;
        if (isHit)
        {
            character = hasShip ? 'X' : 'O';
        }
        else
        {
            character = hasShip ? '+' : '-';
        }
        return " " + character + " " ;
    }

    public void hit()
    {
        isHit = true;
        if (hasShip)
        {
            ship.addHit(this);
        }
    }

    public Ship getShip()
    {
        return ship;
    }

    public boolean hasShip()
    {
        return hasShip;
    }

    public void setOccupied(Ship ship)
    {
        this.ship = ship;
        hasShip = true;
    }

}
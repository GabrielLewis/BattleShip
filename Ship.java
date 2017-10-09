import java.util.ArrayList;

/**
 * Ship
 */
public class Ship 
{
    public static final int SMALL_SIZE = 2;
    public static final int MEDIUM_SIZE = 3;
    public static final int LARGE_SIZE = 4;
    public static final int XLARGE_SIZE = 5;

    private int xcoord;
    private int ycoord;
    private int length;
    private boolean orientationHoriz;
    private ArrayList<Cell> hits;
    private int hitCount;
    private String name;

    /**
     * 
     */
    public Ship (int xcoord, int ycoord, int length, char orientation) 
    {
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.length = length;
        orientationHoriz = orientation == 'H';
        hits = new ArrayList<>();
        hitCount = 0;
        if (length == SMALL_SIZE)
        {
            name = "Patrol Boat";
        }
        else if (length == MEDIUM_SIZE)
        {
            name = "Submarine";
        }
        else if (length == LARGE_SIZE)
        {
            name = "Battleship";
        }
        else if (length == XLARGE_SIZE)
        {
            name = "Aircraft Carrier";
        }
    }

    /**
     * 
     */
    public boolean isHorizontal()
    {
        return orientationHoriz;
    }

	/**
	 * @return the length
	 */
    public int getLength() 
    {
		return length;
	}

	/**
	 * @return the ycoord
	 */
    public int getYcoord() 
    {
		return ycoord;
	}

	/**
	 * @return the xcoord
	 */
    public int getXcoord() 
    {
		return xcoord;
    }
    
    public String getName()
    {
        return name;
    }

    public void addHit(Cell cell)
    {
        hits.add(cell);
        hitCount++;
    }

    public int getHitCount()
    {
        return hitCount;
    }
}
/**
 * BattleShip
 * This is the main program. It starts a game with a ceartain size board.
 */
public class BattleShip 
{
    public static void main(String[] args) 
    {
        Game game = new Game(10);
        game.play();
    }
}
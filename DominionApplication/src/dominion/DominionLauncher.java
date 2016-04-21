package dominion;


import persistence.DominionDAO;

public class DominionLauncher
{

    public static void main (String[] args)
    {
        DominionGame game = new DominionGame();
        game.run();
    }
}

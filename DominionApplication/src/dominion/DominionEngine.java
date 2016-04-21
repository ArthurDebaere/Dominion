package dominion;

import java.util.ArrayList;
import java.util.List;
import persistence.DominionDAO;


public class DominionEngine {
    private DominionDAO dominionDAO;
    
    Player[] players = new Player[2];
    private int currentPlayer;
    
    public DominionEngine(){
        dominionDAO = DominionDAO.getInstance();
        currentPlayer = players[0].getId();
    }
    
    public void setPlayer(int playerId,String name)
    {
        players[playerId] = new Player(name);
    }
    public int getCurrentPlayer(){
        return currentPlayer;
    }
    public boolean gameFinished(){
        return false;
    }
    
    public int getNrOfPlayers(){
        return players.length;
    }
    public void changeCurrentPlayer(){
        currentPlayer = (currentPlayer + 1)%getNrOfPlayers();
    }
}
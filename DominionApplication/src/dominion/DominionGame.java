/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominion;

import persistence.DominionDAO;


public class DominionGame {
        
    private DominionEngine engine;
    private int nrOfPlayers;
    private DominionDAO dao = DominionDAO.getInstance();
    
    public DominionGame(){
        engine = new DominionEngine();
        nrOfPlayers = engine.getNrOfPlayers();
    }

    public DominionGame(String players) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void run(){
        System.out.println("Welcome to the gamezzz");
        
        engine.setPlayer(0,"arthy");
        engine.setPlayer(1,"koen");
        
        gameLoop();
        
        /*Deck testdeck = new Deck();
        testdeck.setDeck(startDeck());
        System.out.println("Startdeck: "+testdeck);*/
        
        /*String [] players = this.players.split(",");
        for(String p: players){
            engine.setPlayer(p);
        }
        engine.initGameCards();*/

        //handleActionForPlayer("play","diamond", p);

        //gameLoop();     
    }
    public Deck startDeck(){
        Deck startDeck = new Deck();
        for(int i = 0; i < 4; i++){
            startDeck.add(dao.getCard("estate"));
        }
        for(int i = 0; i < 8; i++){
            startDeck.add(dao.getCard("copper"));
        }
        return startDeck;
    }
    private void gameLoop() {
        System.out.println("testGameLoop");
        while(!engine.gameFinished())
        {
            // stap 1: toon de situatie : wie is er aan de beurt?
            System.out.println("current player: "+engine.getCurrentPlayer());
            // welke kaarten heb je in je hand ?
            
            // wat ligt er op tafel?
            // welke zetten zijn nu mogelijk?
            // hoeveel geld heb je?
            //showCurrentSituation();

            //int action = askPlayerAction();				// 1 = draw card ; 2 = ... ; ....

            //handlePlayerAction(action);		// gaat werken met gameEngine
        }
    }/*
    
    public void handleActionForPlayer(String action, String cardName, Player player){
        switch(action){
            case "draw":
                player.drawCard(1);
                break;
            case "discard":
                
                player.discardCard(cardName);
                break;
            case "play":
                player.playCard(cardName);
                //If(turnIsOver){
                    player.discardCard(cardName);
                //}
                break;
            case "buy":
                player.buyCard(cardName,player.getSupply());
                break;
        }
    }

    public void setCustomCards(String cards) {
        String [] aCards = cards.split(","); 
        for(int i = 0 ; i < aCards.length; i++){
            engine.setCustomCard(aCards[i]);
        }
        
    }
   */
}

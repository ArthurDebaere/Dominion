package dominion;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;


public class Player
{
    private String name;
    private int id;
    
    private int buys;
    private int actions;
    private int money;

    private Deck playerHand;
    
    public int getMoney() {
        return money;
    }
    
    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }
    
    public Player(String name)
    {
        this.name = name;
        this.money = 0;
        this.actions = 0;
        this.buys = 0;
    }
    
    public void addActions(int amount)
    {
    	this.actions += amount;
    }
    public int getActions()
    {
    	return this.actions;
    }
    
    public void addBuys(int amount)
    {
    	this.buys += amount;
    }
    public int getBuys()
    {
    	return this.buys;
    }
    
    public void addCoins(int amount)
    {
    	this.money += amount;
    }
    public int getCoins()
    {
    	return this.money;
    }

    private void updateMoney(Card card) {
        if(card.getCardName().equals("copper")){
            addCoins(1);
        } else if(card.getCardName().equals("silver")){
            addCoins(2);
        } else if(card.getCardName().equals("gold")){
            addCoins(3);
        } 
    }

}

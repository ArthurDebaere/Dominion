package dominion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck
{
    private List<Card> deck;

    public Deck(){
        deck = new ArrayList<>();
    }

    public void add(Card card){
        deck.add(card);
    }

    public Card findCard(String name){
        Card found = null;
        for(Card c : deck){
            if(c.getCardName().equals(name)){
                found=c;
            }
        }
        return found;
    }

    public void setDeck(Deck d){
        this.deck = d.getDeck();
    }
    
    public List<Card> getDeck(){
        return this.deck;
    }

    public void shuffle(List<Card> cards){
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

    @Override
    public String toString() {
        String cards = "";
        for(Card card : deck){
            cards += card.getCardName()+", ";
        }
        return cards;
    }
}
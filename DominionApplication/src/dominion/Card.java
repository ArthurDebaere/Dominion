package dominion;


public  class Card
{
    private String name;
    private int cost;
    private int value;
    private String type;
    

    public Card(String name, int cost, int value, String type)
    {
        this.name = name;     
        this.cost = cost;     
        this.value = value;
        this.type = type;
    }
    
    public String getCardName(){
        return name;
    }

    public int getCardCost(){
        return cost;
    }

    @Override
    public String toString() {
        return type + "card " + name;
    }
    
    
}

package persistence;
import dominion.Card;
import dominion.Deck;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DominionDAO {
    private Connection connection;
    private static DominionDAO dominionDAO = new DominionDAO();

    private DominionDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String dbName = "dominion";
            String user = "userGroup7";
            String pass = "howest";
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, user, pass); // java = dbnaam usr: java pw: java
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static DominionDAO getInstance(){
        return dominionDAO;
    }

    
    public Deck getActionCards(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cards WHERE cardType='action'");
            ResultSet resultSet = preparedStatement.executeQuery();
            Deck cards = new Deck();

            while (resultSet.next()){
                String cardName = resultSet.getString("cardName");
                int cost = resultSet.getInt("cardCost");
                int value = resultSet.getInt("cardValue");
                String type = resultSet.getString("cardType");
                Card card  = new Card(cardName,cost,value,type);
                cards.add(card);
            }
            return cards;

        }catch (SQLException e){
            return null;
        }
    }
    
    public Deck getAllCards(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cards ");
            ResultSet resultSet = preparedStatement.executeQuery();
            Deck cards= new Deck();

            while (resultSet.next()){
                String cardName = resultSet.getString("cardName");
                int cost = resultSet.getInt("cardCost");
                int value = resultSet.getInt("cardValue");
                String type = resultSet.getString("cardType");
                Card card  = new Card(cardName,cost,value,type);
                cards.add(card);
            }
            return cards;

        }catch (SQLException e){
            return null;
        }
    }
    public Card getCard(String cardName){
        
        Deck cards = getAllCards();
        
        return cards.findCard(cardName);
    }
    
    public String getPasswordOf(String username){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT playerPassword FROM players WHERE playerName=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            String foundPassword = "";
            while(resultSet.next()){
                foundPassword = resultSet.getString("playerPassword");
            }
            return foundPassword;
            

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        
    }
    
    public void registerPlayer(String username, String password, String email){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO players(playerName,playerPassword,playerEmail) VALUES (?,?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}


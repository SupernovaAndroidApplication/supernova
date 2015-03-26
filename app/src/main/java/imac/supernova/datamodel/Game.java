package imac.supernova.datamodel;

import imac.supernova.datamodel.ship.Bomber;
import imac.supernova.datamodel.ship.Cruiser;
import imac.supernova.datamodel.ship.Ship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clara on 05/02/2015.
 */
public class Game implements Serializable{

    ArrayList<Player> players;
    int lap;
    int currentPlayer;

    public Game() {
        players = new ArrayList<Player>();
        lap = 0;
        currentPlayer = 0;
    }

    /**
     * Add a player to the ArrayList
     * @param player the new player to add
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Change the current player and compute the current lap
     */
    public void nextPlayer(){
        currentPlayer = lap % players.size();
        ++lap;
        // TODO rafraichir affichage
    }

    /**
     * This method will determine which kind of Object is attacked to call the proper function.
     * @param object object which is selected to be attacked by the current player.
     * @param shipSelected the ship of the current player that will attack
     */
    public void attack(Object object, Ship shipSelected){
        if(object instanceof Ship){
            System.out.println("attaque d'un vaisseau");
            Ship enemy = (Ship) object;
            shipSelected.attackShip(enemy);
        }
        else if(object instanceof Asteroid){
            System.out.println("attaque d'un asteroid");
            Asteroid asteroid = (Asteroid) object;
            shipSelected.attackAsteroid(asteroid);
        }
        else if(object instanceof AlienWreckage){
            System.out.println("attaque d'une epave alien");
            AlienWreckage alienWreckage = (AlienWreckage) object;
            shipSelected.attackAlienWreckage(alienWreckage);
        }
    }

    /**
     *  Gets the fleet of the current player
     * @return The list of all Ship of the current player
     */
    public List<Ship> getFleetOfCurrentPlayer(){
        return players.get(currentPlayer).getFleet();
    }

    /**
     * Gets all the players
     * @return gets the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getNbPlayers()
    {
        return players.size();
    }

    public Player getPlayer(int index){
        return players.get(index);
    }

}

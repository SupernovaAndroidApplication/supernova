package imac.supernova.datamodel;

import imac.supernova.datamodel.ship.Bomber;
import imac.supernova.datamodel.ship.Cruiser;
import imac.supernova.datamodel.ship.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clara on 05/02/2015.
 */
public class Game {

    Sun sun;
    ArrayList<Player> players;
    int lap;
    int currentPlayer;
    ExplorationCards explorationCards;

    public Game() {
        sun = new Sun(10);
        players = new ArrayList<Player>();
        lap = 0;
        currentPlayer = 0;
        explorationCards = new ExplorationCards();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

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
            shipSelected.attackShip(enemy, sun);
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
            explorationCards.drawACard();
        }
        else if(object instanceof Sun){
            System.out.println("Attaque de la Supernova");
            Sun sun = (Sun) object;
            shipSelected.attackSupernova(sun);
        }
    }



    public List<Ship> getFleetOfCurrentPlayer(){
        return players.get(currentPlayer).getFleet();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(int index){
        return players.get(index);
    }

}

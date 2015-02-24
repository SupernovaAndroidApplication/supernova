package imac.supernova.datamodel;

import java.util.ArrayList;

/**
 * Created by Clara on 05/02/2015.
 */
public class Game {

    ArrayList<Player> players;

    public Game() {
        players = new ArrayList<Player>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

}

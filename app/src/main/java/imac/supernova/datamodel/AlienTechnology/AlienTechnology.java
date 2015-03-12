package imac.supernova.datamodel.AlienTechnology;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import imac.supernova.datamodel.Game;
import imac.supernova.datamodel.Player;
import imac.supernova.datamodel.ship.Ship;

/**
 * Created by Clara on 05/03/2015.
 */
public class AlienTechnology {

    public String name = "";
    public String description = "";
    public Player owner;

    public AlienTechnology(){
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }



    /*public static AlienTechnology getRandomAlienTechnology(){
        AlienTechnology value = values()[(int) (Math.random() * values().length)];
        //AlienTechnology alienTechnology = AlienTechnology.AlienRegenerator;
        return value;
    }*/

}

package imac.supernova.datamodel.AlienTechnology;

import imac.supernova.datamodel.Player;
import imac.supernova.datamodel.ship.Ship;

/**
 * Created by Clara on 08/03/2015.
 */
public class Teleportation extends AlienTechnology {

    public Teleportation(){
        super();
        this.name = "Téléportation";

    }
    public void useAlienTechnology(Ship ship){
        System.out.println("Téléportation use on " + ship.toString());
        owner.getAlienCards().remove(this);

    }
}

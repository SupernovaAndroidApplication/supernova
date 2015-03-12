package imac.supernova.datamodel.AlienTechnology;

import imac.supernova.datamodel.Player;
import imac.supernova.datamodel.ship.Ship;

/**
 * Created by Clara on 08/03/2015.
 */
public class AlienRegenerator extends  AlienTechnology {
    public AlienRegenerator(){
        super();
        this.name = "Régénérateur alien";
    }
    public void useAlienTechnology(Ship ship){
        System.out.println("Regénérateur alien use !");
        ship.setHealth(ship.getMaxHealth());
        owner.getAlienCards().remove(this);

    }
}

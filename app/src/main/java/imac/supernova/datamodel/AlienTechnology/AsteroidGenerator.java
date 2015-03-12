package imac.supernova.datamodel.AlienTechnology;

import imac.supernova.datamodel.ExplorationCards;
import imac.supernova.datamodel.Player;

/**
 * Created by Clara on 08/03/2015.
 */
public class AsteroidGenerator extends AlienTechnology {
    public AsteroidGenerator(){
        super();
        this.name = "Générateur d'asteroides";
    }
    public void useAlienTechnology(ExplorationCards explorationCards){
        System.out.println("Générateur d'asteroides use !");
        owner.getAlienCards().remove(this);

    }
}

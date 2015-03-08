package imac.supernova.datamodel.AlienTechnology;

import imac.supernova.datamodel.Game;
import imac.supernova.datamodel.Player;
import imac.supernova.datamodel.ship.Ship;

/**
 * Created by Clara on 08/03/2015.
 */
public class AlienWeapon extends AlienTechnology {
    public AlienWeapon(Player owner){
        super(owner);
        this.name = "Arme Alien";
        this.description = "Utilisée et défaussée lors d’un combat, elle augmente d’une unité supplémentaire la puissance de feu d’un vaisseau de son choix. Valable pour tous les vaisseaux, croiseur y compris. ";
    }

    public void useAlienTechnology(Ship ship){
        System.out.println("AlienWeapon use " + ship.toString());
        ship.setDamage(ship.getDamage()+1);
        owner.getAlienCards().remove(this);
    }
}

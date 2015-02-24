package imac.supernova.datamodel.ship;

import imac.supernova.datamodel.Player;

/**
 * Created by Clara on 05/02/2015.
 */
public class Fighter extends Ship {

    public Fighter(Player owner){
        super(owner);
        setMaxHealth(2);
        setHealth(getMaxHealth());
        setMaxMove(5);
        setDamage(1);
        setRange(1);
    }
}

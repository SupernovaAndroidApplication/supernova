package imac.supernova.datamodel.ship;

import imac.supernova.datamodel.Player;

/**
 * Created by Clara on 05/02/2015.
 */
public class Cruiser extends Ship {

    public Cruiser(Player owner){
        super(owner);
        setMaxHealth(6); // 1 = 50 and 6 = 300
        setHealth(getMaxHealth());
        setMaxMove(5);
        setDamage(1);
        setRange(1);
    }
}

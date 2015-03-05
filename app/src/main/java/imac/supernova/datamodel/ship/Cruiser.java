package imac.supernova.datamodel.ship;

import imac.supernova.datamodel.Player;

/**
 * Created by Clara on 05/02/2015.
 */
public class Cruiser extends Ship {

    public Cruiser(Player owner){
        super(owner);
        //setMaxHealth(2);
        setMaxHealth(100); // 1 = 50 and 5 = 250
        setHealth(getMaxHealth());
        setMaxMove(5);
        setDamage(1);
        setRange(1);
    }
}

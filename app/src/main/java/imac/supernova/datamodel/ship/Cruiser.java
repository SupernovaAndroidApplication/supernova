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
        setMaxDamage(1); // 1 = 150 and 2 = 300
        setDamage(getMaxDamage());
        setMaxMove(2); // 1 = 60 and 2 = 120
        setMove(getMaxMove());
        setRange(1);
    }
}

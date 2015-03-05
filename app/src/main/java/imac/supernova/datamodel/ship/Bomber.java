package imac.supernova.datamodel.ship;

import imac.supernova.datamodel.Player;

/**
 * Created by Clara on 05/02/2015.
 */
public class Bomber extends Ship {

    public Bomber(Player owner){
        super(owner);
        setMaxHealth(3); // 1 = 50 and 3 = 300
        setHealth(getMaxHealth());
        setMaxMove(3);
        setDamage(2);
        setRange(1);
    }
}

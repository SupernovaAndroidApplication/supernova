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
        setMaxDamage(2); // 1 = 150 and 2 = 300
        setDamage(getMaxDamage());
        setMaxMove(3); // 1 = 60 and 3 = 180
        setMove(getMaxMove());
        setRange(1);
    }
}

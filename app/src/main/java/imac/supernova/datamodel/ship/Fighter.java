package imac.supernova.datamodel.ship;

import imac.supernova.datamodel.Player;

/**
 * Created by Clara on 05/02/2015.
 */
public class Fighter extends Ship {

    public Fighter(Player owner){
        super(owner);
        setMaxHealth(2); // 1 = 100 and 2 = 150
        setHealth(getMaxHealth());
        setMaxDamage(1); // 1 = 150 and 2 = 300
        setDamage(getMaxDamage());
        setMaxMove(5); // 1 = 60 and 5 = 300
        setMove(getMaxMove());
        setRange(1);
    }
}

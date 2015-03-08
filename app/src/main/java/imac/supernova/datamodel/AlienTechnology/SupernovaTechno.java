package imac.supernova.datamodel.AlienTechnology;

import imac.supernova.datamodel.Player;
import imac.supernova.datamodel.Sun;

/**
 * Created by Clara on 08/03/2015.
 */
public class SupernovaTechno extends AlienTechnology {

    public SupernovaTechno(Player owner){
        super(owner);
        this.name = "Supernova";
    }
    public void useAlienTechnology(Sun sun){
        System.out.println("Supernova !");
        sun.setSupernova(true);
        owner.getAlienCards().remove(this);

    }
}

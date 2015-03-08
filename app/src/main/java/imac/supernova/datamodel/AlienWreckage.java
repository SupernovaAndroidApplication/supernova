package imac.supernova.datamodel;

import imac.supernova.datamodel.AlienTechnology.AlienTechnology;

/**
 * Created by Angecroft on 24/02/2015.
 */
public class AlienWreckage extends SpaceObject {

    public AlienTechnology alienTechnology;

    public AlienWreckage(String coordinates, AlienTechnology alienTechnology) {
        super(coordinates);
        this.alienTechnology = alienTechnology;
    }
    public String toString(){
        return this.getClass().getName() + "Coord : " + this.coordinates + "Type : " + this.alienTechnology.getName();
    }
}

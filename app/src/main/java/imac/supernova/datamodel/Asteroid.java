package imac.supernova.datamodel;

import imac.supernova.datamodel.SpaceObject;

/**
 * Created by Angecroft on 19/02/2015.
 */
public class Asteroid extends SpaceObject {

    public Asteroid(String coordinates) {
        super(coordinates);
    }

    public String toString(){
        return this.getClass().getName() + "Coord : " + this.coordinates;
    }
}

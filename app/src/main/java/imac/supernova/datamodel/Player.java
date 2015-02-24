package imac.supernova.datamodel;

import imac.supernova.datamodel.ship.Fighter;
import imac.supernova.datamodel.ship.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clara on 02/02/2015.
 */
public class Player {

    String name;
    Race race;
    ArrayList<Ship> fleet;

    public Player(String name, Race race) {
        System.out.println("Création d'un joueur");
        name = new String();
        this.fleet = new ArrayList<Ship>();
        this.name = name;
        this.race = race;
        for(int i=0;i<6;i++) {
            Fighter f = new Fighter(this);
            this.fleet.add(f);
            System.out.println(f.toString());
        }
    }

    public String printFleet() {
        String s = new String();
        s += "Flotte "+ this.race.toString().toLowerCase() +" de " + this.name + " : \n";
        for (Ship element : this.fleet) {
            s += element.toString();
            s+= "\n";
        }
        return s;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Ship> getFleet() {
        return this.fleet;
    }

    public Race getRace() {
        return race;
    }

}

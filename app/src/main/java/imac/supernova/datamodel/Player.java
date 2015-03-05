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
    ArrayList<Ship> fleet;
    Race race;
    int credit;

    public Player(String i_name, Race i_race){
        System.out.println("Création d'un joueur");
        name = new String();
        fleet = new ArrayList<Ship>();
        name = i_name;
        race = i_race;
        for(int i=0;i<6;i++){
            Fighter f = new Fighter(this);
            this.fleet.add(f);
            System.out.println(f.toString());

        }

    }

    public String printFleet(){
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

    public List<Ship> getFleet(){
        return this.fleet;
    }

    public Race getRace() {
        return race;
    }

    public int getCredit() {
        return credit;
    }

    public void earnCredit(){
        credit += 1;
        System.out.println("Crédit: "+credit);
    }

    public void spendCredit(){
        credit -= 1;
        System.out.println("Crédit: "+credit);
    }

}

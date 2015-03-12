package imac.supernova.datamodel;

import android.support.v4.util.ArrayMap;

import java.util.Random;

import imac.supernova.datamodel.AlienTechnology.AlienRegenerator;
import imac.supernova.datamodel.AlienTechnology.AlienTechnology;
import imac.supernova.datamodel.AlienTechnology.AlienWeapon;
import imac.supernova.datamodel.AlienTechnology.AsteroidGenerator;
import imac.supernova.datamodel.AlienTechnology.SupernovaTechno;
import imac.supernova.datamodel.AlienTechnology.Teleportation;

/**
 * Created by Angecroft on 19/02/2015.
 */
public class ExplorationCards {


    public enum Case{
        A (8,15),
        B (7,15),
        C (6,15),
        D (5,15),
        E (4,15),
        F (3,15),
        G (2,15),
        H (1,15),
        I (1,14),
        J (1,13),
        K (1,12),
        L (1,11),
        M (1,10),
        N (1,9),
        O (1,8);

        int intervalMax;
        int intervalMin;

        Case(int intervalMin, int intervalMax) {
            this.intervalMin = intervalMin;
            this.intervalMax = intervalMax;
        }

        public static String getRandomCase(){

            String result = "";
            Random r = new Random();
            Case value = values()[(int) (Math.random() * values().length)];
            result += value;

            int randomNum  = r.nextInt(value.intervalMax-value.intervalMin) + value.intervalMin;
            result += randomNum;


            return result;
        }

    }

    ArrayMap<String, SpaceObject> remainingSpaceObjects;  /** all SpaceObject with their corresponding coordinates */
    ArrayMap<String, SpaceObject> inGameSpaceObjects;

    public ExplorationCards() {
        System.out.println("SPACEOBJECTS : NEW EXPLORATIONS CARDS");

        //Remplissage de la pioche spaceobjects du jeu
        remainingSpaceObjects = new ArrayMap<String, SpaceObject>();

            //Cartes Alien
            addSpaceObject(new AlienWreckage("",new AlienWeapon()));
            addSpaceObject(new AlienWreckage("",new AlienRegenerator()));
            addSpaceObject(new AlienWreckage("",new AsteroidGenerator()));
            addSpaceObject(new AlienWreckage("",new SupernovaTechno()));
            addSpaceObject(new AlienWreckage("",new Teleportation()));


        //Astéroïdes
            for(int j = 0;j<6;j++){
                addSpaceObject(new Asteroid(""));
            }

        //Tirage aléatoire des spaceobjects
        inGameSpaceObjects = new ArrayMap<String, SpaceObject>();

         for(int i =0;i<6;i++){

           Random r = new Random();
            int Low = 0;
            int High = remainingSpaceObjects.size();
            int R = r.nextInt(High-Low) + Low;

                 inGameSpaceObjects.put(remainingSpaceObjects.keyAt(i), remainingSpaceObjects.valueAt(i));

        }
    }

    public void addSpaceObject(SpaceObject so){
        String  randomCase = "E1";
        System.out.println("SPACEOBJECTS : next space object");
        System.out.println("SPACEOBJECTS current random case : " + randomCase);

        if(remainingSpaceObjects.get(randomCase) == null) {
            so.setCoordinates(randomCase);
            remainingSpaceObjects.put(randomCase, so);
        }
        else {
            while(remainingSpaceObjects.get(randomCase) != null){
                randomCase = Case.getRandomCase();
                System.out.println("SPACEOBJECTS : new random case " + randomCase);
            }
            so.setCoordinates(randomCase);
            if(remainingSpaceObjects.put(randomCase, so)==null) {
                System.out.println("SPACEOBJECTS : add a new space object success");
            }
        }
    }

    /** Draw a card among those remaining */
    public void drawACard(){
        if(remainingSpaceObjects.size() > 0){
            Random rand = new Random();
            int index = rand.nextInt(remainingSpaceObjects.size() - 0 + 1);
            String coordinates = remainingSpaceObjects.keyAt(index);
            inGameSpaceObjects.put(coordinates, remainingSpaceObjects.removeAt(index));
        }
    }

    public ArrayMap<String, SpaceObject> getInGameSpaceObjects() {
        return inGameSpaceObjects;
    }

    public ArrayMap<String, SpaceObject> getRemainingSpaceObjects() {
        return remainingSpaceObjects;
    }

    public String inGameSpaceObjectsToString(){
        String st ="";
        for(int i=0;i<inGameSpaceObjects.size();i++){
            st += inGameSpaceObjects.valueAt(i).toString();
            st += "/n";
        }

        return st;
    }

    public String remainingGameObjectsToString(){
        String st ="";
        for(int i=0;i<remainingSpaceObjects.size();i++){
            st += remainingSpaceObjects.valueAt(i).toString();
            st += "/n";
        }

        return st;
    }

    public void spaceObjectDestroyed(String coordinates){
        inGameSpaceObjects.remove(coordinates);
    }
}

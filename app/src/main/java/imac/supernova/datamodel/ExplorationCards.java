package imac.supernova.datamodel;

import android.support.v4.util.ArrayMap;

import java.util.Random;

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
        String randomCase;

        //Remplissage de la pioche spaceobjects du jeu
        remainingSpaceObjects = new ArrayMap<String, SpaceObject>();

            //Cartes Alien

        ///PROBLEME AVEC LA FONCTION PUT DE ARRAYMAP. CETTE PARTIE DU CODE PLANTE L'APPLI

        /*    for (AlienTechnology n : AlienTechnology.values()) {
                randomCase = Case.getRandomCase();
                while(remainingSpaceObjects.put(randomCase, new AlienWreckage(randomCase, n))!= null){
                    randomCase = Case.getRandomCase();
                    remainingSpaceObjects.put(randomCase, new AlienWreckage(randomCase, n));
                }
            }

            //Astéroïdes
            for(int i = 0;i<6;i++){
                randomCase = Case.getRandomCase();
                while(remainingSpaceObjects.put(randomCase, new Asteroid(randomCase))!=null){
                    randomCase = Case.getRandomCase();
                    remainingSpaceObjects.put(randomCase, new Asteroid(randomCase));
                }
            }*/

        //Tirage aléatoire des spaceobjects
        inGameSpaceObjects = new ArrayMap<String, SpaceObject>();

         /*for(int i =0;i<6;i++){

           Random r = new Random();
            int Low = 0;
            int High = remainingSpaceObjects.size();
            int R = r.nextInt(High-Low) + Low;

                 inGameSpaceObjects.put(remainingSpaceObjects.keyAt(i), remainingSpaceObjects.valueAt(i));

        }*/
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

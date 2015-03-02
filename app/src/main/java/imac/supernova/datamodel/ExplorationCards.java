package imac.supernova.datamodel;

import android.support.v4.util.ArrayMap;

import java.util.Random;

/**
 * Created by Angecroft on 19/02/2015.
 */
public class ExplorationCards {
    ArrayMap<String, SpaceObject> remainingSpaceObjects;  /** all SpaceObject with their corresponding coordinates */
    ArrayMap<String, SpaceObject> inGameSpaceObjects;

    public ExplorationCards() {
        remainingSpaceObjects = new ArrayMap<String, SpaceObject>();
        // TODO lire un fichier pour tout remplir ou tout remplir a la main

        inGameSpaceObjects = new ArrayMap<String, SpaceObject>();
        // TODO remplir 6 case et les supprimer de remainingSpaceObjects
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

    public void spaceObjectDestroyed(String coordinates){
        inGameSpaceObjects.remove(coordinates);
    }
}

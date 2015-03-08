package imac.supernova.datamodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Clara on 05/03/2015.
 */
public enum AlienTechnology {
    Teleportation ("Téléportation", "Permet de téléporter instantanément n’importe quel vaisseau de la flotte, à n’importe quel endroit du plateau"),
    AlienWeapon ("Arme Alien","Utilisée et défaussée lors d’un combat, elle augmente d’une unité supplémentaire la puissance de feu d’un vaisseau de son choix. Valable pour tous les vaisseaux, croiseur y compris. "),
    AlienRegenerator ("Regénérateur Alien","Utilisé sur n’importe quel vaisseau de son choix, il régénère instantanément toutes les unités d’énergie du vaisseau."),
    AsteroidGenerator ("Générateur d’astéroïdes",""),
    TimeExpander("Extenseur temporel","Donne au joueur un certain nombre d’actions supplémentaires pendant le tour où la carte est jouée."),
    DoubleBlow("Coup double","Permet d'attaquer une 2nde fois pendant son tour. L'action d'utiliser la carte permet d'attaquer sans que l'attaque compte comme une nouvelle action"),
    Dodge ("Esquive","Peut être jouée en dehors de son tour de jeu, lorsqu'un de ses vaisseaux est attaqué. L'effet de l'attaque est alors annulé."),
    Riposte ("Riposte ","Peut être jouée en dehors de son tour de jeu, lorsqu'un de ses vaisseaux est attaqué. Le vaisseau qui attaque perd la moitié (arrondie au supérieur) de ses points d'attaque en unité d'énergie."),
    Supernova ("Supernova", "Piochée, cette carte doit être révélée aux autres joueurs, et l’on applique alors les règles de la supernova");

    private String name = "";
    private String description = "";

    AlienTechnology(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    /*public static AlienTechnology getRandomAlienTechnology(){
        AlienTechnology value = values()[(int) (Math.random() * values().length)];
        //AlienTechnology alienTechnology = AlienTechnology.AlienRegenerator;
        return value;
    }*/

    public void useAlienTechnology (){
        if(this.equals(Teleportation)){
            System.out.println("Action Téléportation !");

        }
        if(this.equals(AlienWeapon)){
            System.out.println("Action Alien Weapon !");
        }
        if(this.equals(AlienRegenerator)){
            System.out.println("Action Alien Regenerator !");
        }
        if(this.equals(AsteroidGenerator)){
            System.out.println("Action Asteroid Regenerator !");
        }
        if(this.equals(TimeExpander)){
            System.out.println("Action TimeExpander !");
        }
        if(this.equals(DoubleBlow)){
            System.out.println("Action DoubleBlow !");
        }
        if(this.equals(Dodge)){
            System.out.println("Action Dodge !");
        }
        if(this.equals(Riposte)){
            System.out.println("Action Riposte !");
        }
        if(this.equals(Supernova)){
            System.out.println("Action Supernova !");
        }
    }
}

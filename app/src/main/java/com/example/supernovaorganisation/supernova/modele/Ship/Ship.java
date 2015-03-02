package com.example.supernovaorganisation.supernova.modele.Ship;

import com.example.supernovaorganisation.supernova.modele.AlienWreckage;
import com.example.supernovaorganisation.supernova.modele.Asteroid;
import com.example.supernovaorganisation.supernova.modele.Player;
import com.example.supernovaorganisation.supernova.modele.Race;

/**
 * Created by Clara on 05/02/2015.
 */
public class Ship {
    Player owner;
    int health;
    int maxHealth;
    int maxMove;
    int damage;
    int range;
    boolean hasWeapon;
    boolean hasShield;

    public Ship(Player i_owner){
        System.out.println("Création d'un vaisseau");
        this.owner = i_owner;
        this.hasWeapon = false;
        this.hasShield = false;
    }

    public void regenerateHealth(){
        this.health = this.maxHealth;
    }

    public void buyWeapon(){
        if(this.getOwner().getCredit() > 0){
            this.getOwner().spendCredit();
            installWeapon();
        }
    }

    public void installWeapon(){
        if(!this.hasWeapon){
            this.hasWeapon = true;
            this.damage +=1;
            System.out.println("Arme installée sur le " + this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName());

        }
        else{
            System.out.println("Vous avez déjà installé une arme ! ");
        }
    }

    public void buyShield(){
        if(this.getOwner().getCredit() > 0){
            this.getOwner().spendCredit();
            installShield();
        }
    }

    public void installShield(){
        if(!this.hasShield){
            this.hasShield = true;
            this.health += 1;
            System.out.println("Bouclier installé sur le " + this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName());
        }
        else{
            System.out.println("Vous avez déjà installé un bouclier ! ");
        }
    }

    public void attackShip(Ship enemy){

        System.out.println("Attaque lancée du "+ this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName()
        +" sur le "+enemy.getClass().getSimpleName().toString() +" "+ enemy.getOwner().getRace().toString() + " de " +enemy.getOwner().getName());

        if(enemy.hasShield){
            enemy.hasShield = false;
            System.out.println("Bouclier détruit sur le "+enemy.getClass().getSimpleName().toString() +" "+ enemy.getOwner().getRace().toString() + " de " +enemy.getOwner().getName());
        }
        enemy.setHealth(enemy.getHealth() - this.damage);
        if(enemy.health <= 0){
            enemy.death();
        }
    }

    public void attackAsteroid(Asteroid asteroid){
        System.out.println("Attaque lancée du "+ this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName()
                +" sur le "+asteroid.getClass().getSimpleName().toString());

        // TODO appeler carte exploration pour remplir une nouvelle case
        this.owner.earnCredit();
    }

    public void attackAlienWreckage(AlienWreckage wreckage){
        System.out.println("Attaque lancée du "+ this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName()
                +" sur le "+wreckage.getClass().getSimpleName().toString());

        // TODO donner une carte alien au joueur
        // TODO appeler carte exploration pour remplir une nouvelle case
    }

    public void death(){
        this.getOwner().getFleet().remove(this);
        System.out.println("Vaisseau détruit : " +this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName());
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getRange() {
        return range;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Owner : " +this.getOwner().getName()
                +" Type : "+this.getClass().getSimpleName().toString()
                +" Health : " + this.health
                + " MaxHealth : " + this.maxHealth
                + "  MaxMove : " + this.maxMove
                + "  Damage : " + this.damage
                +" Weapon : " + this.hasWeapon
                + " Shield : " + this.hasShield;
    }
}
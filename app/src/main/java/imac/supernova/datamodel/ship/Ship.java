package imac.supernova.datamodel.ship;

import imac.supernova.datamodel.AlienWreckage;
import imac.supernova.datamodel.Asteroid;
import imac.supernova.datamodel.Race;

import imac.supernova.datamodel.Player;

/**
 * Created by Clara on 05/02/2015.
 */
public class Ship {

    int id;
    Player owner;
    int health;
    int maxHealth;
    int damage;
    int maxDamage;
    int move;
    int maxMove;
    int range;
    boolean hasWeapon;
    boolean hasShield;

    /**
     * Ship constructor
     * @param owner
     */
    public Ship(Player owner) {
        System.out.println("Création d'un vaisseau");
        this.owner = owner;
        this.hasWeapon = false;
        this.hasShield = false;
    }

    public Ship() {}

    /**
     * Getters and setters
     */
    // Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Damage
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    // Max Damage
    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    // Health
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Max Health
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    // Move
    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    // Max Move
    public int getMaxMove() {
        return maxMove;
    }

    public void setMaxMove(int maxMove) {
        this.maxMove = maxMove;
    }

    // Range
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    // Owner
    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    // Weapon
    public boolean getHasWeapon() {
        return hasWeapon;
    }

    public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }

    // Shield
    public boolean getHasShield() {
        return hasShield;
    }

    public void setHasShield(boolean hasShield) {
        this.hasShield = hasShield;
    }

    /** Actions */
    // Buy shield
    public void buyShield(){
        //if(this.getOwner().getCredit() > 0){
            this.getOwner().spendCredit();
            installShield();
        //}
    }

    public void buyWeapon(){
        //if(this.getOwner().getCredit() > 0){
            this.getOwner().spendCredit();
            installWeapon();
        //}
    }

    /**
     * Install a weapon
     */
    public void installWeapon() {
        if(!this.hasWeapon){
            this.hasWeapon = true;
            this.damage +=1;
            System.out.println("Arme installée sur le " + this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName());
        }
        else {
            System.out.println("Vous avez déjà installé une arme ! ");
        }
    }

    /**
     * Install a shield
     */
    public void installShield() {
        if(!this.hasShield) {
            this.hasShield = true;
            this.health += 1;
            System.out.println("Bouclier installé sur le " + this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName());
        }
        else {
            System.out.println("Vous avez déjà installé un bouclier ! ");
        }
    }

    // Attack ship
    public void attackShip(Ship enemy) {
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

    // Attack asteroid
    public void attackAsteroid(Asteroid asteroid){
        System.out.println("Attaque lancée du "+ this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName()
                +" sur le "+asteroid.getClass().getSimpleName().toString());

        // TODO appeler carte exploration pour remplir une nouvelle case
        this.owner.earnCredit();
    }

    // Attack alien wreckage
    public void attackAlienWreckage(AlienWreckage wreckage){
        System.out.println("Attaque lancée du "+ this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName()
                +" sur le "+wreckage.getClass().getSimpleName().toString());

        // TODO donner une carte alien au joueur
        // TODO appeler carte exploration pour remplir une nouvelle case
    }

    /**
     * toString()
     * @return String
     */
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

    /**
     * Regenerate the health
     */
    public void regenerateHealth() {
        this.health = this.maxHealth;
    }

    /**
     * Attack an enemy ship
     * @param enemy
     */
    public void attack(Ship enemy) {
        System.out.println("Attaque lancée du "+ this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName()
        +" sur le "+enemy.getClass().getSimpleName().toString() +" "+ enemy.getOwner().getRace().toString() + " de " +enemy.getOwner().getName());

        if(enemy.hasShield) {
            enemy.hasShield = false;
            System.out.println("Bouclier détruit sur le "+enemy.getClass().getSimpleName().toString() +" "+ enemy.getOwner().getRace().toString() + " de " +enemy.getOwner().getName());
        }
        enemy.setHealth(enemy.getHealth() - this.damage);
        if(enemy.health <= 0) {
            enemy.death();
        }
    }

    /**
     * Remove a dead ship from the player's fleet
     */
    public void death() {
        this.getOwner().getFleet().remove(this);
        System.out.println("Vaisseau détruit : " +this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName());
    }
}

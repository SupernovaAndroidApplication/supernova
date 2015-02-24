package imac.supernova.datamodel.ship;

import imac.supernova.datamodel.Player;

/**
 * Created by Clara on 05/02/2015.
 */
public class Ship {

    private int id;
    private Player owner;
    private int health;
    private int maxHealth;
    private int maxMove;
    private int damage;
    private int range;
    private boolean hasWeapon;
    private boolean hasShield;

    public Ship(Player owner){
        System.out.println("Création d'un vaisseau");
        this.owner = owner;
        this.hasWeapon = false;
        this.hasShield = false;
    }

    public void regenerateHealth(){
        this.health = this.maxHealth;
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

    public void attack(Ship enemy){

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

    public void death(){
        this.getOwner().getFleet().remove(this);
        System.out.println("Vaisseau détruit : " +this.getClass().getSimpleName().toString() +" "+ this.getOwner().getRace().toString() + " de " +this.getOwner().getName());
    }

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

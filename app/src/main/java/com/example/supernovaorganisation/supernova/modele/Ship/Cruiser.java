package com.example.supernovaorganisation.supernova.modele.Ship;

import com.example.supernovaorganisation.supernova.modele.Player;

/**
 * Created by Clara on 05/02/2015.
 */
public class Cruiser extends Ship{
    public Cruiser(Player owner){
        super(owner);
        maxHealth = 2;
        health = maxHealth;
        maxMove = 5;
        damage = 1;
        range = 1;
    }
}

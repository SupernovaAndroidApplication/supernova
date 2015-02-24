package com.example.supernovaorganisation.supernova.modele.Ship;

import com.example.supernovaorganisation.supernova.modele.Player;

/**
 * Created by Clara on 05/02/2015.
 */
public class Bomber extends Ship {
    public Bomber(Player owner){
        super(owner);
        maxHealth = 3;
        health = maxHealth;
        maxMove = 3;
        damage = 2;
        range = 1;
    }
}

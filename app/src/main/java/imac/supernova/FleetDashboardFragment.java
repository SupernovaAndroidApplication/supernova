package imac.supernova;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

import imac.supernova.datamodel.Game;
import imac.supernova.datamodel.ship.Ship;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link //FleetDashboardFragment.//OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FleetDashboardFragment#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class FleetDashboardFragment extends Fragment implements View.OnClickListener {

    private View v;

    private TextView ship_name;
    private TextView max_health_bar;
    private TextView health_bar;
    private TextView health_units;
    private TextView max_damage_bar;
    private TextView damage_bar;
    private TextView damage_units;
    private TextView max_move_bar;
    private TextView move_bar;
    private TextView move_units;

    private RelativeLayout.LayoutParams params_health;
    private RelativeLayout.LayoutParams params_max_health;
    private RelativeLayout.LayoutParams params_damage;
    private RelativeLayout.LayoutParams params_max_damage;
    private RelativeLayout.LayoutParams params_move;
    private RelativeLayout.LayoutParams params_max_move;

    private Button button_buy_shield;
    private Button button_buy_weapon;

    private Button button_attack_enemy;
    private Button button_attack_asteroid;

    public Game currentGame;
    public List<Ship> playerFleet;


    public FleetDashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fleet_dashboard, container, false);
        // Get textview to insert data
        ship_name = (TextView) v.findViewById(R.id.ship_name);
        max_health_bar = (TextView) v.findViewById(R.id.max_health_bar);
        health_bar = (TextView) v.findViewById(R.id.health_bar);
        health_units = (TextView) v.findViewById(R.id.health_units);
        max_damage_bar = (TextView) v.findViewById(R.id.max_damage_bar);
        damage_bar = (TextView) v.findViewById(R.id.damage_bar);
        damage_units = (TextView) v.findViewById(R.id.damage_units);
        max_move_bar = (TextView) v.findViewById(R.id.max_move_bar);
        move_bar = (TextView) v.findViewById(R.id.move_bar);
        move_units = (TextView) v.findViewById(R.id.move_units);

        // Button #1
        Button button_cruiser = (Button) v.findViewById(R.id.button_cruiser);
        button_cruiser.setOnClickListener(this);

        // Button #2
        Button button_bomber_1 = (Button) v.findViewById(R.id.button_bomber_1);
        button_bomber_1.setOnClickListener(this);
        // Button #3
        Button button_bomber_2 = (Button) v.findViewById(R.id.button_bomber_2);
        button_bomber_2.setOnClickListener(this);

        // Button #4
        Button button_fighter_1 = (Button) v.findViewById(R.id.button_fighter_1);
        button_fighter_1.setOnClickListener(this);
        // Button #5
        Button button_fighter_2 = (Button) v.findViewById(R.id.button_fighter_2);
        button_fighter_2.setOnClickListener(this);
        // Button #6
        Button button_fighter_3 = (Button) v.findViewById(R.id.button_fighter_3);
        button_fighter_3.setOnClickListener(this);

        // Button buy a shield
        button_buy_shield = (Button) v.findViewById(R.id.button_buy_shield);
        button_buy_shield.setOnClickListener(this);
        // Button buy a weapon
        button_buy_weapon = (Button) v.findViewById(R.id.button_buy_weapon);
        button_buy_weapon.setOnClickListener(this);

        // Button attack an enemy
        button_attack_enemy = (Button) v.findViewById(R.id.button_attack_enemy);
        button_attack_enemy.setOnClickListener(this);
        // Button attack an asteroid
        button_attack_asteroid = (Button) v.findViewById(R.id.button_attack_asteroid);
        button_attack_asteroid.setOnClickListener(this);

        // Get the current game and the current player's fleet
        currentGame = ((MainActivity) getActivity()).game;
        playerFleet = currentGame.getFleetOfCurrentPlayer();
        // Init the display on first ship
        ship_name.setText(playerFleet.get(0).getClass().getSimpleName().toString());
        updateAllFeaturesDisplay(0);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /* Navigation */
            case R.id.button_cruiser:
                ship_name.setText(playerFleet.get(0).getClass().getSimpleName().toString());
                updateAllFeaturesDisplay(0);
                break;
            case R.id.button_bomber_1:
                ship_name.setText(playerFleet.get(1).getClass().getSimpleName().toString() + " #1");
                updateAllFeaturesDisplay(1);
                break;
            case R.id.button_bomber_2:
                ship_name.setText(playerFleet.get(2).getClass().getSimpleName().toString() + " #2");
                updateAllFeaturesDisplay(2);
                break;
            case R.id.button_fighter_1:
                ship_name.setText(playerFleet.get(3).getClass().getSimpleName().toString() + " #1");
                updateAllFeaturesDisplay(3);
                break;
            case R.id.button_fighter_2:
                ship_name.setText(playerFleet.get(4).getClass().getSimpleName().toString() + " #2");
                updateAllFeaturesDisplay(4);
                break;
            case R.id.button_fighter_3:
                ship_name.setText(playerFleet.get(5).getClass().getSimpleName().toString() + " #3");
                updateAllFeaturesDisplay(5);
                break;

            /* Buy buttons */
            case R.id.button_buy_shield:
                playerFleet.get((Integer) v.getTag()).buyShield();
                updateHealthDisplay((Integer) v.getTag());
                button_buy_shield.setVisibility(View.INVISIBLE);
                break;
            case R.id.button_buy_weapon:
                playerFleet.get((Integer) v.getTag()).buyWeapon();
                updateDamageDisplay((Integer) v.getTag());
                button_buy_weapon.setVisibility(View.INVISIBLE);
                break;

            /* Attack buttons */
            case R.id.button_attack_enemy:
                /*Fragment fragment = new EnemyFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();*/
                break;
            case R.id.button_attack_asteroid:
                break;

            default:
                break;
        }
    }

    /**
     * Update the display of ship's data on click on buttons
     */
    // Health
    public void updateHealthDisplay(int id) {
        params_max_health = new RelativeLayout.LayoutParams(convertToDP(playerFleet.get(id).getMaxHealth()*50), RelativeLayout.LayoutParams.MATCH_PARENT);
        max_health_bar.setLayoutParams(params_max_health);
        if(playerFleet.get(id).getHealth() < playerFleet.get(id).getMaxHealth()) {
            params_health = new RelativeLayout.LayoutParams(convertToDP(playerFleet.get(id).getHealth()*50), RelativeLayout.LayoutParams.MATCH_PARENT);
            health_bar.setLayoutParams(params_health);
        }
        else {
            health_bar.setLayoutParams(params_max_health);
        }
        health_units.setText(playerFleet.get(id).getHealth()+"/"+playerFleet.get(id).getMaxHealth());
    }

    // Damage
    public void updateDamageDisplay(int id) {
        params_max_damage = new RelativeLayout.LayoutParams(convertToDP(playerFleet.get(id).getMaxDamage()*150), RelativeLayout.LayoutParams.MATCH_PARENT);
        max_damage_bar.setLayoutParams(params_max_damage);
        if(playerFleet.get(id).getDamage() <= playerFleet.get(id).getMaxDamage()) {
            params_damage = new RelativeLayout.LayoutParams(convertToDP(playerFleet.get(id).getDamage()*150), RelativeLayout.LayoutParams.MATCH_PARENT);
            damage_bar.setLayoutParams(params_damage);
        }
        else if(playerFleet.get(id).getDamage() > playerFleet.get(id).getMaxDamage()) {
            damage_bar.setLayoutParams(params_max_damage);
        }
        damage_units.setText(playerFleet.get(id).getDamage()+"/"+playerFleet.get(id).getMaxDamage());
    }

    // Move
    public void updateMoveDisplay(int id) {
        params_max_move = new RelativeLayout.LayoutParams(convertToDP(playerFleet.get(id).getMaxMove()*60), RelativeLayout.LayoutParams.MATCH_PARENT);
        max_move_bar.setLayoutParams(params_max_move);
        if(playerFleet.get(id).getMove() <= playerFleet.get(id).getMaxMove()) {
            params_move = new RelativeLayout.LayoutParams(convertToDP(playerFleet.get(id).getMaxMove()*60), RelativeLayout.LayoutParams.MATCH_PARENT);
            move_bar.setLayoutParams(params_move);
        }
        else if(playerFleet.get(id).getMove() > playerFleet.get(id).getMaxMove()) {
            move_bar.setLayoutParams(params_max_move);
        }
        move_units.setText(playerFleet.get(id).getMove()+"/"+playerFleet.get(id).getMaxMove());
    }

    // All
    public void updateAllFeaturesDisplay(int id) {
        updateHealthDisplay(id);
        updateDamageDisplay(id);
        updateMoveDisplay(id);

        // Button buy id & visibility
        if(playerFleet.get(id).getHasShield()) {
            button_buy_shield.setVisibility(View.INVISIBLE);
        }
        else {
            button_buy_shield.setVisibility(View.VISIBLE);
            button_buy_shield.setTag(id);
        }

        if(playerFleet.get(id).getHasWeapon()) {
            button_buy_weapon.setVisibility(View.INVISIBLE);
        }
        else {
            button_buy_weapon.setVisibility(View.VISIBLE);
            button_buy_weapon.setTag(id);
        }
    }

    /**
     * Convert pixels to dp
     */
    public int convertToDP(int pixels) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (pixels * scale + 0.5f);
    }

}

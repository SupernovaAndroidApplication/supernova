package imac.supernova;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
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
    private TextView health_bar;
    private TextView health_units;
    private TextView damage_bar;
    private TextView damage_units;
    private TextView move_bar;
    private TextView move_units;

    private RelativeLayout.LayoutParams params_health;
    private RelativeLayout.LayoutParams params_damage;
    private RelativeLayout.LayoutParams params_move;

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
        health_bar = (TextView) v.findViewById(R.id.health_bar);
        health_units = (TextView) v.findViewById(R.id.health_units);
        damage_bar = (TextView) v.findViewById(R.id.damage_bar);
        damage_units = (TextView) v.findViewById(R.id.damage_units);
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

        // Get the current game and the current player's fleet
        currentGame = ((MainActivity) getActivity()).game;
        playerFleet = currentGame.getFleetOfCurrentPlayer();
        // Init the display on first ship
        ship_name.setText(playerFleet.get(0).getClass().getSimpleName().toString());
        updateFeaturesDisplay(0);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_cruiser:
                ship_name.setText(playerFleet.get(0).getClass().getSimpleName().toString());
                updateFeaturesDisplay(0);
                break;
            case R.id.button_bomber_1:
                ship_name.setText(playerFleet.get(1).getClass().getSimpleName().toString() + " #1");
                updateFeaturesDisplay(1);
                break;
            case R.id.button_bomber_2:
                ship_name.setText(playerFleet.get(2).getClass().getSimpleName().toString() + " #2");
                updateFeaturesDisplay(2);
                break;
            case R.id.button_fighter_1:
                ship_name.setText(playerFleet.get(3).getClass().getSimpleName().toString() + " #1");
                updateFeaturesDisplay(3);
                break;
            case R.id.button_fighter_2:
                ship_name.setText(playerFleet.get(4).getClass().getSimpleName().toString() + " #2");
                updateFeaturesDisplay(4);
                break;
            case R.id.button_fighter_3:
                ship_name.setText(playerFleet.get(5).getClass().getSimpleName().toString() + " #3");
                updateFeaturesDisplay(5);
                break;
            default:
                break;
        }
    }

    /**
     * Update the display of ship's data on click on buttons
     */
    public void updateFeaturesDisplay(int id) {
        // Health
        params_health = new RelativeLayout.LayoutParams(convertToDP(playerFleet.get(id).getHealth()*50), RelativeLayout.LayoutParams.MATCH_PARENT);
        health_bar.setLayoutParams(params_health);
        health_units.setText(playerFleet.get(id).getHealth()+"/"+playerFleet.get(id).getMaxHealth());
        // Damage
        params_damage = new RelativeLayout.LayoutParams(convertToDP(playerFleet.get(id).getDamage()*150), RelativeLayout.LayoutParams.MATCH_PARENT);
        damage_bar.setLayoutParams(params_damage);
        damage_units.setText(playerFleet.get(id).getDamage()+"/"+playerFleet.get(id).getMaxDamage());
        // Move
        params_move = new RelativeLayout.LayoutParams(convertToDP(playerFleet.get(id).getMaxMove()*60), RelativeLayout.LayoutParams.MATCH_PARENT);
        move_bar.setLayoutParams(params_move);
        move_units.setText(playerFleet.get(id).getMove()+"/"+playerFleet.get(id).getMaxMove());
    }

    /**
     * Convert pixels to dp
     */
    public int convertToDP(int pixels) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (pixels * scale + 0.5f);
    }

}

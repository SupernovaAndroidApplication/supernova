package imac.supernova;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import imac.supernova.datamodel.Game;
import imac.supernova.datamodel.Player;
import imac.supernova.datamodel.ship.Ship;


public class EnemiesListActivity extends ActionBarActivity {

    private View v;

    Game game;
    Ship[] ships;

    private Button button_enemy_1;
    private Button button_enemy_2;
    private Button button_enemy_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemies_list);

        final ListView lv1 = (ListView) findViewById(R.id.listView_player1);
        final ListView lv2 = (ListView) findViewById(R.id.listView_player2);
        final ListView lv3 = (ListView) findViewById(R.id.listView_player3);

        game = (Game) getIntent().getSerializableExtra("Game");
        ArrayList<Player> players = game.getPlayers();

        // Tableau listview
        ListView[] lvArray = new ListView[players.size()-1];
        // Tableau ships (array d'array)
        Ship[][] fleetsArray = new Ship[players.size()-1][6];
        // Tableau adpater
        ArrayAdapterItem[] arrayAdapterItems = new ArrayAdapterItem[players.size()-1];

        for(int i = 0; i < players.size()-1; ++i) {
            // Fleets
            ships = new Ship[6];
            fleetsArray[i] = getFleetArray(game.getPlayer(i).getFleet());
            // Adapters
            arrayAdapterItems[i] = new ArrayAdapterItem(this, R.layout.enemies_list_item, fleetsArray[i]);
        }

        lv1.setAdapter(arrayAdapterItems[0]);
        lv2.setAdapter(arrayAdapterItems[1]);
        lv3.setAdapter(arrayAdapterItems[2]);

        lv1.setVisibility(View.INVISIBLE);
        lv2.setVisibility(View.INVISIBLE);
        lv3.setVisibility(View.INVISIBLE);

        // Button #1
        button_enemy_1 = (Button) findViewById(R.id.button_enemy_1);
        button_enemy_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lv1.setVisibility(View.VISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.INVISIBLE);
            }
        });

        // Button #2
        button_enemy_2 = (Button) findViewById(R.id.button_enemy_2);
        button_enemy_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.VISIBLE);
                lv3.setVisibility(View.INVISIBLE);
            }
        });

        // Button #
        button_enemy_3 = (Button) findViewById(R.id.button_enemy_3);
        button_enemy_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lv1.setVisibility(View.INVISIBLE);
                lv2.setVisibility(View.INVISIBLE);
                lv3.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enemies_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Ship[] getFleetArray(List<Ship> fleet) {
        for(int i = 0; i < fleet.size(); ++i) {
            ships[i] = fleet.get(i);
        }
        return ships;
    }
}

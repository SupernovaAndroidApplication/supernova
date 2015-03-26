package imac.supernova;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EnemiesListActivity extends ActionBarActivity {

    // The data to show
    List<Map<String, String>> enemiesList = new ArrayList<Map<String,String>>();

    private void initList() {
        // We populate the planets
        enemiesList.add(createEnemy("planet", "Mercury"));
        enemiesList.add(createEnemy("planet", "Venus"));
        enemiesList.add(createEnemy("planet", "Mars"));
        enemiesList.add(createEnemy("planet", "Jupiter"));
        enemiesList.add(createEnemy("planet", "Saturn"));
    }

    private HashMap<String, String> createEnemy(String key, String name) {
        HashMap<String, String> enemy = new HashMap<String, String>();
        enemy.put(key, name);

        return enemy;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemies_list);

        initList();

        // We get the ListView component from the layout
        ListView lv1 = (ListView) findViewById(R.id.listView_player1);

        // This is a simple adapter that accepts as parameter
        // Context
        // Data list
        // The row layout that is used during the row creation
        // The keys used to retrieve the data
        // The View id used to show the data. The key number and the view id must match
        SimpleAdapter simpleAdpt1 = new SimpleAdapter(this, enemiesList, R.layout.enemies_list_item, new String[] {"planet"}, new int[] {R.id.textViewItem});

        lv1.setAdapter(simpleAdpt1);

        // We get the ListView component from the layout
        ListView lv2 = (ListView) findViewById(R.id.listView_player2);

        // This is a simple adapter that accepts as parameter
        // Context
        // Data list
        // The row layout that is used during the row creation
        // The keys used to retrieve the data
        // The View id used to show the data. The key number and the view id must match
        SimpleAdapter simpleAdpt2 = new SimpleAdapter(this, enemiesList, R.layout.enemies_list_item, new String[] {"planet"}, new int[] {R.id.textViewItem});

        lv2.setAdapter(simpleAdpt2);

       /* super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemies_list);*/
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
}

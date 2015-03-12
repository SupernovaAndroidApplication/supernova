package imac.supernova;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

import imac.supernova.ARVuforia.FrameMarkers;
import imac.supernova.datamodel.AlienTechnology.AlienTechnology;
import imac.supernova.datamodel.AlienTechnology.AlienWeapon;
import imac.supernova.datamodel.AlienWreckage;
import imac.supernova.datamodel.ExplorationCards;
import imac.supernova.datamodel.Game;
import imac.supernova.datamodel.Player;
import imac.supernova.datamodel.Race;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mNavigationTitles;
    private String[] mNavigationSubtitles;
    ArrayList<NavItem> mNavItems = new ArrayList<>();

    public Game game;
    public Player currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get navigation titles items
        mTitle = mDrawerTitle = getTitle();
        mNavigationTitles = getResources().getStringArray(R.array.titles_array);
        mNavigationSubtitles = getResources().getStringArray(R.array.subtitles_array);

        // Create navigation items
        mNavItems.add(new NavItem(mNavigationTitles[0], mNavigationSubtitles[0], R.drawable.ic_action_person));
        mNavItems.add(new NavItem(mNavigationTitles[1], mNavigationSubtitles[1], R.drawable.ic_action_settings));
        mNavItems.add(new NavItem(mNavigationTitles[2], mNavigationSubtitles[2], R.drawable.ic_action_about));
        mNavItems.add(new NavItem(mNavigationTitles[3], mNavigationSubtitles[3], R.drawable.ic_action_map));

        // Set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        // Set the adapter for the list view and populate the Navigation Drawer with options
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawer_pane);
        mDrawerList = (ListView) findViewById(R.id.nav_list);
        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setAdapter(adapter);

        // Set the list's click listener for ListView in the navigation drawer
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });

        // Enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                   /* host Activity */
                mDrawerLayout,          /* DrawerLayout object */
                R.string.drawer_open,   /* "open drawer" description for accessibility */
                R.string.drawer_close   /* "close drawer" description for accessibility */
        ) {
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }

        // Start a new game
        game = new Game();
        game.addPlayer(new Player("Angéline", Race.TERRAN));
        game.addPlayer(new Player("Clara", Race.NERENIDE));
        game.addPlayer(new Player("Baptiste", Race.BOHREGON));
        game.addPlayer(new Player("Jérôme", Race.YTTRIKT));
        currentPlayer = game.getPlayer(0); // TODO: handle game turn
        System.out.println("COUCOU C'EST CLARA");
        /*AlienTechnology alienweapon = new AlienWeapon(game.getPlayer(0));
        AlienWreckage aw = new AlienWreckage("ccord", alienweapon);

        System.out.println("ALIENTECHNO" + aw.alienTechnology.toString());

        if(aw.alienTechnology instanceof AlienWeapon) {
            AlienWeapon alienWeapon = (AlienWeapon) (aw.alienTechnology);
            alienWeapon.useAlienTechnology(game.getPlayer(0).getFleet().get(0));
        }

*/
        ExplorationCards exc = new ExplorationCards();
        System.out.println("NB REMAINING SPACEOBJECTS" + exc.getRemainingSpaceObjects().size());
        System.out.println("REMAINING SPACEOBJECTS" + exc.remainingGameObjectsToString());

       System.out.println("NB INGAME SPACEOBJECTS" + exc.getInGameSpaceObjects().size());
        System.out.println("INGAME SPACEOBJECTS" + exc.inGameSpaceObjectsToString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     *  Called whenever we call invalidateOptionsMenu()
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        //boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        //menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * Swaps fragments in the main content view
     * (called when a particular item from the navigation drawer is selected)
     */
    private void selectItem(int position) {
        Fragment fragment = null;
        FragmentManager fragmentManager;

        switch (position) {
            case 0:
                fragment = new PlayerCardFragment();
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();
                break;
            case 1:
                fragment = new FleetDashboardFragment();
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();
                break;
            case 2:
                fragment = new AlienTechnologiesFragment();
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();
                break;
            case 3:
                Intent intent = new Intent(this, FrameMarkers.class);
                startActivity(intent);
                break;
            default:
                break;
        }

        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mNavItems.get(position).mTitle);
        mDrawerLayout.closeDrawer(mDrawerPane);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }


    /************************/
    /**** Inner classes ****/
    /**********************/

    /**
     * Navigation items class
     */
    class NavItem {
        String mTitle;
        String mSubtitle;
        int mIcon;

        public NavItem(String title, String subtitle, int icon) {
            mTitle = title;
            mSubtitle = subtitle;
            mIcon = icon;
        }
    }

    /**
     * Drawer list adapter class
     */
    class DrawerListAdapter extends BaseAdapter {
        Context mContext;
        ArrayList<NavItem> mNavItems;

        public DrawerListAdapter(Context context, ArrayList<NavItem> navItems) {
            mContext = context;
            mNavItems = navItems;
        }

        @Override
        public int getCount() {
            return mNavItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mNavItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.drawer_nav_item, null);
            }
            else {
                view = convertView;
            }

            TextView titleView = (TextView) view.findViewById(R.id.title);
            TextView subtitleView = (TextView) view.findViewById(R.id.subtitle);
            ImageView iconView = (ImageView) view.findViewById(R.id.icon);

            titleView.setText( mNavItems.get(position).mTitle );
            subtitleView.setText( mNavItems.get(position).mSubtitle );
            iconView.setImageResource(mNavItems.get(position).mIcon);

            return view;
        }
    }

}

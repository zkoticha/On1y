package on1y.example.org.on1y;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    //TODO: youtube, public static final String API_KEY = "AIzaSyDMgPHTwX532qKErIXFZjrxKsMxJw33lRY"
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    //TODO: delete all this for youtube stuff
    private CharSequence mTitle;
    public int oldPos = 0;
    public final String MAIN_FRAG = "mainfragment";
    public final String SCIENCE_FRAG = "sciencefragment";
    public final Fragment fragment = new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment(), MAIN_FRAG)
                    .commit();
        }


    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();

       // if (oldPos == 0) {


            fragmentManager.beginTransaction().replace(R.id.container, fragment).replace(R.id.container, changeFragment(position + 1))
                .commit();
        //TODO: I don't know why this works and I need to fix this.
       /*     oldPos = position;
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, PlaceholderFragment.changeFragment(position + 1))
                    .commit();
            oldPos = position; */
    }


    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

    public Fragment changeFragment(int sectionNumber) {

        //PlaceholderFragment fragment = new PlaceholderFragment();
        //Bundle args = new Bundle();
        //args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        //fragment.setArguments(args);
        //return fragment;
        if (sectionNumber == 1) {
            return new MainFragment();
        } else if (sectionNumber == 2) {
            return new ScienceFragment();
        } else if (sectionNumber == 3) {
            return new BusinessFragment();
        }
        else if (sectionNumber == 4) {
            return new TechFragment();
        }
        else if (sectionNumber == 5) {
            return new BookFragment();
        }
        else {

            Toast.makeText(MainActivity.this, "sectionnumber should be 1-4", Toast.LENGTH_SHORT).show();
            return new MainFragment();
        }
    }
}



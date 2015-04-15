package com.lastminutedevice.nsfawards.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lastminutedevice.nsfawards.R;
import com.lastminutedevice.nsfawards.fragments.AboutFragment;
import com.lastminutedevice.nsfawards.fragments.SearchFragment;
import com.lastminutedevice.nsfawards.fragments.SummaryFragment;

public class HomeActivity extends ActionBarActivity {
    private ActionBarDrawerToggle drawerToggle;

    private AboutFragment aboutFragment = new AboutFragment();
    private SearchFragment searchFragment = new SearchFragment();
    private SummaryFragment summaryFragment = new SummaryFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Use a Toolbar for the ActionBar
        setSupportActionBar((Toolbar) findViewById(R.id.about_toolbar));

        getSupportActionBar().setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setElevation(10f); // Only has effect on 5.0+.

        // DrawerLayout is support v4 widget.
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        // ActionBarToggle is also a support v4 widget.
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);

        setUpDrawer(findViewById(R.id.navigation_drawer));

        loadFragment(summaryFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("keyword");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                loadFragment(searchFragment);
                searchFragment.runSearch(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                loadFragment(searchFragment);
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                MenuItemCompat.collapseActionView(searchItem);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * Set up the click listeners on the drawer links.
     *
     * @param view the View in which these links may be found
     */
    private void setUpDrawer(View view) {
        view.findViewById(R.id.about_drawer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(aboutFragment);
            }
        });

        view.findViewById(R.id.search_drawer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(searchFragment);
            }
        });

        view.findViewById(R.id.home_drawer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(summaryFragment);
            }
        });
    }

    /**
     * Replace the existing fragment in our fragment_container FrameLayout with the provided one.
     *
     * @param fragment the new Fragment to display
     */
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

        ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawers();
    }
}

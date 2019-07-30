package com.vitapp.technovit19;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment,new home_fragment()).commit();

        }
        else if(id == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment,new about_fragment()).commit();

        }
        else if(id == R.id.nav_schedule) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment,new schedule_fragment()).commit();

        }
        else if(id == R.id.nav_venue) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment,new venue_fragment()).commit();

        }
        else if(id == R.id.nav_gallery) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment,new gallery_fragment()).commit();

        }
        else if(id == R.id.nav_sponsors) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment,new sponsors_fragment()).commit();

        }
        else if(id == R.id.nav_contact) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_fragment,new contacts_fragment()).commit();

        }

        drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

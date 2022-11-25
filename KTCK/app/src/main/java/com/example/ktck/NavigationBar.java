package com.example.ktck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class NavigationBar extends AppCompatActivity {
    AccountFragment accountFragment = new AccountFragment();
    ListFragment listFragment = new ListFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,listFragment).commit();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_account:
                        Toast.makeText(NavigationBar.this, "Profile", Toast.LENGTH_SHORT).show();
                    case R.id.action_list:
                        Toast.makeText(NavigationBar.this, "List", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_account:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,accountFragment).commit();
                        return true;
                    case R.id.action_list:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,listFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}
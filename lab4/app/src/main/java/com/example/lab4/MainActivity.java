package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.lab4.fragment.HomeFragment;
import com.example.lab4.fragment.InfoFragment;
import com.example.lab4.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView mnBottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("main");
        actionBar.setDisplayHomeAsUpEnabled(true); //nut back
    }

    //nut back hoat dong
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home)
        {
            finish();
            return true;
        }
        return true;
    }

    private void addEvents() {
        mnBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //load Fragment
                //Khi chọn một item menu trên Navigation thì sẽ load Fragment
                Fragment fmNew;
                if(item.getItemId() == R.id.mnHome){
                    fmNew=new HomeFragment();
                    loadFragment(fmNew);
                    getSupportActionBar().setTitle(item.getTitle());
                    return true;
                }

                if(item.getItemId() == R.id.mnInfo){
                    fmNew=new InfoFragment();
                    loadFragment(fmNew);
                    getSupportActionBar().setTitle(item.getTitle());
                    return true;
                }

                if(item.getItemId() == R.id.mnSetting){
                    fmNew=new SettingFragment();
                    loadFragment(fmNew);
                    getSupportActionBar().setTitle(item.getTitle());
                    return true;
                }
                return true;
            }
        });
    }

    void loadFragment(Fragment fmNew)
    {
        FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_fragment, fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }

    private void addControls() {
        mnBottom=findViewById(R.id.navMenu);
    }
}
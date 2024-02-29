package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fragment.fragment.HomeFragment;
import com.example.fragment.fragment.InfoFragment;
import com.example.fragment.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("main");
    }
void loadFragment(Fragment fmNew){
    FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
    fmTran.replace(R.id.main_Frame,fmNew);
    fmTran.addToBackStack(null);
    fmTran.commit();

}
    private void addEvents() {
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //load Fragment
                //Khi chọn một item menu trên Navigation thì sẽ load Fragment
                Fragment fmNew;
                if(item.getItemId() == R.id.bottomHome){
                    fmNew=new HomeFragment();
                    loadFragment(fmNew);
                    getSupportActionBar().setTitle(item.getTitle());
                    return true;
                }

                if(item.getItemId() == R.id.bottomInfo){
                    fmNew=new InfoFragment();
                    loadFragment(fmNew);
                    getSupportActionBar().setTitle(item.getTitle());
                    return true;
                }

                if(item.getItemId() == R.id.bottomSetting){
                    fmNew=new SettingFragment();
                    loadFragment(fmNew);
                    getSupportActionBar().setTitle(item.getTitle());
                    return true;
                }
                return true;
            }
        });
    }

    private void addControls() {
        bottomNav=findViewById(R.id.bottomNav);
    }


}
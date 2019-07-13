package com.example.parentportal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.parentportal.ViewModels.DairyViewModel;
import com.example.parentportal.ViewModels.StudentProgressViewModel;

public class MainActivity extends AppCompatActivity implements StudentProgressFragment.OnListFragmentInteractionListener, DiaryFragment.OnListFragmentInteractionListener {


    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    FloatingActionButton fabApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabApplication=findViewById(R.id.fabApplications);
        fragmentManager=getSupportFragmentManager();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        intializeFragment();
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fabApplication.show();
                        StudentProgressFragment fragment=new StudentProgressFragment();
                        transaction=fragmentManager.beginTransaction();
                        transaction.replace(R.id.fragment_container, fragment);
                        transaction.commit();
                        return true;
                    case R.id.navigation_diary:
                        fabApplication.hide();
                        DiaryFragment diaryFragment = new DiaryFragment();
                        transaction=fragmentManager.beginTransaction();
                        transaction.replace(R.id.fragment_container, diaryFragment);
                        transaction.commit();
                        return true;
                    case R.id.navigation_notifications:
                        fabApplication.hide();
                        return true;
                }
                return false;
            }
        });
    }

    private void intializeFragment() {
        StudentProgressFragment fragment=new StudentProgressFragment();
        transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.account_menu,menu);
        return true;
    }
    @Override
    public void onListFragmentInteraction(StudentProgressViewModel item) {

    }

    @Override
    public void onListFragmentInteraction(DairyViewModel item) {

    }
}

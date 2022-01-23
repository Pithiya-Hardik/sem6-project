package com.example.chatyou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.chatyou.Adaptesr.FragmentAdaptesr;
import com.example.chatyou.databinding.ActivityMainBinding;
import com.example.chatyou.databinding.ActivitySingInBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();

        binding.viewpager.setAdapter(new FragmentAdaptesr(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewpager);


    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.settings:
                break;


            case R.id.logout:
                auth.signOut();
                Intent i = new Intent(MainActivity.this, sing_in.class);
                startActivity(i);
                break;

        }
        return true;

    }
}
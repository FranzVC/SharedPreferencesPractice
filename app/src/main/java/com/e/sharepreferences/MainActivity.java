package com.e.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements
                                                        InputFragment.OnFragmentInteractionListener,
                                                        ShowDataFragment.OnFragmentInteractionListener{

    InputFragment inputFragment;
    ShowDataFragment showDataFragment;
    SharedPreferences sharedPreferences;
    Bundle bundle ;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        inputFragment = new InputFragment();
        showDataFragment = new ShowDataFragment();
        bundle= new Bundle();

        String name = sharedPreferences.getString("name",null);
        String address = sharedPreferences.getString("address",null);
        String email = sharedPreferences.getString("email",null);
        bundle.putString("name",name);
        bundle.putString("address",address);
        bundle.putString("email",email);
        getSupportFragmentManager().beginTransaction().add(R.id.containerFragment, inputFragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        String email = intent.getStringExtra("email");

        bundle.putString("name",name);
        bundle.putString("address",address);
        bundle.putString("email",email);

    }

    public void onClickRegisterBtn(View v){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerFragment, inputFragment);
        fragmentTransaction.commit();
    }

    public void onClickShowDataBtn(View v){

        //
        showDataFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerFragment, showDataFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        String name = bundle.getString("name");
        String address = bundle.getString("address");
        String email = bundle.getString("email");

        editor.putString("name", name);
        editor.putString("address", address);
        editor.putString("email",email);
        editor.apply();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

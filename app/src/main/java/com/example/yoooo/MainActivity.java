package com.example.yoooo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        TextView authentication = (TextView) findViewById(R.id.authentication);


        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        // admin and admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin") && authentication.getText().toString().equals("admin")) {
                    openanscestorjournal();
                }
                else{
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
    public void openanscestorjournal() {
        Intent intent = new Intent(this, ancestorjournal.class);
        startActivity(intent);
    }

}
package com.example.yoooo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class ancestorjournal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ancestorjournal);

        MaterialButton write = (MaterialButton) findViewById(R.id.write);

        // admin and admin and admin

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(true) {
                    openTheJournalTree();
                }
                else{
                    Toast.makeText(ancestorjournal.this, "Journal Entry Failed", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
    public void openTheJournalTree() {
        Intent intent = new Intent(this, TheJournalTree.class);
        startActivity(intent);
    }
}
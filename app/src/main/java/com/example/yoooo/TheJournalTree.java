package com.example.yoooo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class TheJournalTree extends AppCompatActivity {
    EditText name, location, journal, genepass;
    MaterialButton write;
    FirebaseFirestore db;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_journal_tree);
        db = FirebaseFirestore.getInstance();
        name = findViewById(R.id.name);
        location = findViewById(R.id.location);
        journal = findViewById(R.id.journal);
        genepass = findViewById(R.id.genepass);
        write = findViewById(R.id.send);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String authname = name.getText().toString();
                String authlocation = location.getText().toString();
                String authjournal = journal.getText().toString();
                String authgenepass = genepass.getText().toString();
                Map<String, Object> user = new HashMap<>();
                user.put("Name", authname);
                user.put("Location", authlocation);
                user.put("Start Writing History", authjournal);
                user.put("Enter GeneID", authgenepass);

                db.collection("user")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(TheJournalTree.this, "Successful", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(TheJournalTree.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}
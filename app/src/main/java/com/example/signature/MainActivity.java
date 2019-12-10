package com.example.signature;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.FileOutputStream;

/*
    Nom du composant : SignatureEdit

    Hérite de ImageView

    Propriétés:
        - Color lineColor
        - int lineWidth
        - String lineStyle
        - int borderLineWidth
        - Bitmap signature (lecture seule)

    Méthodes :
        - void clear()
        - Boolean save (String fileName)

    Evénements :
        - Out

 */

public class MainActivity extends AppCompatActivity {

    TagEdit affichage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        affichage = findViewById(R.id.imageView);


    }

    public void clear(View view) {
        setContentView(R.layout.activity_main);
        affichage = findViewById(R.id.imageView);
    }

    public void save(View view) {

        String dossier = Environment.getExternalStorageDirectory().getAbsolutePath();
        Toast.makeText(this,dossier, Toast.LENGTH_LONG).show();
    }
}

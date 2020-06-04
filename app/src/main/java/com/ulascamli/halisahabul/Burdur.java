package com.ulascamli.halisahabul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Burdur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burdur);
        ListView listView=findViewById(R.id.List);
        final ArrayList<String> burdurhalisaha=new ArrayList<>();
        burdurhalisaha.add("Altıpas Halı Saha");
        burdurhalisaha.add("Arena Halı Saha");
        burdurhalisaha.add("Yeşil Çimen Halı Saha");
        burdurhalisaha.add("Burdur Sporpark Halısahaları");

        final ArrayList<String>Adres=new ArrayList<>();
        Adres.add("Emek, Osman Gazi Cd., 15100 Burdur Merkez/Burdur");
        Adres.add("Emek, 57. Sk. No:18, 15100 Burdur Merkez/Burdur");
        Adres.add("Emek, Ali Kemal Erdem Blv. No: 40, 15100 Burdur Merkez/Burdur");
        Adres.add("kışla mah. organize sanayi bölgesi 45.sokak merkez, 15100 Burdur");

        final ArrayList<String>Telefon=new ArrayList<>();
        Telefon.add("0545 258 47 27");
        Telefon.add("0505 051 15 15");
        Telefon.add("0555 195 16 17");
        Telefon.add("0536 609 48 57");

        Bitmap altipas= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.altipas);
        Bitmap arena=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.arena);
        Bitmap yesilcimen=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.yesilcimen);
        Bitmap sporpark=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.burdur1);

        final ArrayList<Bitmap>Resim=new ArrayList<>();
        Resim.add(altipas);
        Resim.add(arena);
        Resim.add(yesilcimen);
        Resim.add(sporpark);


        ArrayAdapter arrayAdapter=new ArrayAdapter(Burdur.this,android.R.layout.simple_list_item_1,burdurhalisaha);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),Detay.class);
                intent.putExtra("name",burdurhalisaha.get(position));
                intent.putExtra("adres",Adres.get(position));
                intent.putExtra("tel",Telefon.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(Resim.get(position));
                startActivity(intent);
            }
        });
    }
}

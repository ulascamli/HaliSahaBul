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

public class Antalya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antalya);
        ListView listView=findViewById(R.id.antList);
        final ArrayList<String> antalyahalisaha=new ArrayList<>();
        antalyahalisaha.add("As Halı Saha");
        antalyahalisaha.add("Sporyum Halı Saha & Cafe");
        antalyahalisaha.add("Anadolu Halı Saha Tesis");
        antalyahalisaha.add("Olimpia Halı Saha");

        final ArrayList<String>Adres=new ArrayList<>();
        Adres.add("Meltem, 3802. Sk. No:2, 07030 Muratpaşa/Antalya");
        Adres.add("Muratpaşa, 575. Sk., 07000 Muratpaşa/Antalya");
        Adres.add("Gebizli Mah. Yunus Emre Cad., 1110 Sok. No:196, 07300 Muratpaşa/Antalya");
        Adres.add("Demokrasi Kavşağı yanı, Aspendos Blv., 07260 Kepez/Antalya");

        final ArrayList<String>Telefon=new ArrayList<>();
        Telefon.add("0242 237 12 56");
        Telefon.add("0242 243 00 42");
        Telefon.add("0542 776 77 07");
        Telefon.add("0242 339 92 04");

        Bitmap as= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.as);
        Bitmap sporyum=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.sporyum);
        Bitmap anadolu=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.anadolu);
        Bitmap olimpia=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.olimpia);

        final ArrayList<Bitmap>Resim=new ArrayList<>();
        Resim.add(as);
        Resim.add(sporyum);
        Resim.add(anadolu);
        Resim.add(olimpia);


        ArrayAdapter arrayAdapter=new ArrayAdapter(Antalya.this,android.R.layout.simple_list_item_1,antalyahalisaha);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),Detay.class);
                intent.putExtra("name",antalyahalisaha.get(position));
                intent.putExtra("adres",Adres.get(position));
                intent.putExtra("tel",Telefon.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(Resim.get(position));
                startActivity(intent);
            }
        });
    }
}

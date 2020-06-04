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

public class isparta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isparta);
        ListView listView=findViewById(R.id.ispList);
        final ArrayList<String> ispartahalisaha=new ArrayList<>();
        ispartahalisaha.add("Fatih Halı Saha");
        ispartahalisaha.add("Arenapark Halisaha");
        ispartahalisaha.add("FAİRPLAY Halı Saha");
        ispartahalisaha.add("Yeşil Krampon Halı Saha");

        final ArrayList<String>Adres=new ArrayList<>();
        Adres.add("Fatih, Kadir Boylu Cd (207. Cd.), 32100 Isparta/Isparta Merkez/Isparta");
        Adres.add("Muzaffer Türkeş, Cennet Cd. No:105, 32200 Isparta Merkez/Isparta");
        Adres.add("Sanayi, özel ısparta altı, 131. Cd. no 8, 32200 Isparta Merkez/Isparta");
        Adres.add("Halıkent, Ayazmana Cd. No:1, 32040 Isparta Merkez/Isparta");

        final ArrayList<String>Telefon=new ArrayList<>();
        Telefon.add("0246 228 28 70");
        Telefon.add("0546 233 97 66");
        Telefon.add("0542 435 35 59");
        Telefon.add("0246 242 29 29");

        Bitmap fatih= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.fatih);
        Bitmap arena=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.isparena);
        Bitmap fair=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.fair);
        Bitmap yesilkrampon=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.yesilkrampon);

        final ArrayList<Bitmap>Resim=new ArrayList<>();
        Resim.add(fatih);
        Resim.add(arena);
        Resim.add(fair);
        Resim.add(yesilkrampon);


        ArrayAdapter arrayAdapter=new ArrayAdapter(isparta.this,android.R.layout.simple_list_item_1,ispartahalisaha);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),Detay.class);
                intent.putExtra("name",ispartahalisaha.get(position));
                intent.putExtra("adres",Adres.get(position));
                intent.putExtra("tel",Telefon.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(Resim.get(position));
                startActivity(intent);
            }
        });
    }
}

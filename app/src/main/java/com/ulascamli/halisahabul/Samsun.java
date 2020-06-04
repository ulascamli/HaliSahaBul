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

public class Samsun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsun);
        ListView listView=findViewById(R.id.samList);
        final ArrayList<String> samsunhalisaha=new ArrayList<>();
        samsunhalisaha.add("Samsun Derecik Halı SAHA");
        samsunhalisaha.add("Banda Aceh Halı Saha");
        samsunhalisaha.add("Şampiyon Spor Tesisleri");
        samsunhalisaha.add("Kurupelit Halı Saha");

        final ArrayList<String>Adres=new ArrayList<>();
        Adres.add("Derecik, 55090 İlkadım/Samsun");
        Adres.add("Cumhuriyet, 44. Sk. No:7, 55200 Atakum/Samsun");
        Adres.add("Reşadiye, Yay Sk. No:18, 55050 Samsun Merkez/Samsun");
        Adres.add("Körfez, atakum bulvarı no:26, 55200 Atakum/Samsun");

        final ArrayList<String>Telefon=new ArrayList<>();
        Telefon.add("0532 663 80 18");
        Telefon.add("0532 111 11 72");
        Telefon.add("0362 440 15 73");
        Telefon.add("0542 398 47 89");

        Bitmap as= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.derecik);
        Bitmap sporyum=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.banda);
        Bitmap anadolu=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.sampiyon);
        Bitmap olimpia=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kuru);

        final ArrayList<Bitmap>Resim=new ArrayList<>();
        Resim.add(as);
        Resim.add(sporyum);
        Resim.add(anadolu);
        Resim.add(olimpia);


        ArrayAdapter arrayAdapter=new ArrayAdapter(Samsun.this,android.R.layout.simple_list_item_1,samsunhalisaha);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),Detay.class);
                intent.putExtra("name",samsunhalisaha.get(position));
                intent.putExtra("adres",Adres.get(position));
                intent.putExtra("tel",Telefon.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(Resim.get(position));
                startActivity(intent);
            }
        });
    }
}

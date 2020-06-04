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

public class istanbul extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istanbul);
        ListView listView=findViewById(R.id.listview);
        final ArrayList<String> istanbulhalisaha=new ArrayList<>();
        istanbulhalisaha.add("Kapalı Halı Saha");
        istanbulhalisaha.add("Vıp Halı Saha");
        istanbulhalisaha.add("Görkem Halı Saha");
        istanbulhalisaha.add("Atakan KURT Üstü Kapalı Halı Saha Tesisleri");

        final ArrayList<String>Adres=new ArrayList<>();
        Adres.add("Bahçelievler Mah, Mehmet Akif Cd. No:14, 34180 Bahçelievler/İstanbul");
        Adres.add("Merkez, Eyüp Sultan Cd. 54/B, 34406 Kâğıthane/İstanbul");
        Adres.add("Mevlanakapı, Tekke Maslağı Sk. No:10, 34104 Fatih/İstanbul");
        Adres.add("Barbaros Mahallesi Lale sokak 2 Adet Üstü Kapalı Atakan KURT Halı Saha Tesisleri, 34746 Ataşehir/İstanbul");

        final ArrayList<String>Telefon=new ArrayList<>();
        Telefon.add("0549 250 05 61");
        Telefon.add("0505 700 67 78");
        Telefon.add("0212 587 39 19");
        Telefon.add("0216 688 55 55");

        Bitmap kapali= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kapali_hali_saha_ist);
        Bitmap vip=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.vip_ist);
        Bitmap gorkem=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.gorkem_ist);
        Bitmap atakan=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kurt_halisaha_ist);

        final ArrayList<Bitmap>Resim=new ArrayList<>();
        Resim.add(kapali);
        Resim.add(vip);
        Resim.add(gorkem);
        Resim.add(atakan);


        ArrayAdapter arrayAdapter=new ArrayAdapter(istanbul.this,android.R.layout.simple_list_item_1,istanbulhalisaha);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),Detay.class);
                intent.putExtra("name",istanbulhalisaha.get(position));
                intent.putExtra("adres",Adres.get(position));
                intent.putExtra("tel",Telefon.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(Resim.get(position));
                startActivity(intent);
            }
        });

    }
}

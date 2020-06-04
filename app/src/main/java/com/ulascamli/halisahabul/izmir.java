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

public class izmir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izmir);
        ListView listView=findViewById(R.id.ListView);

        final ArrayList<String>izmirhalisaha=new ArrayList<>();
        izmirhalisaha.add("Karayolları Yolspor Çetin Erol Hali Saha Tesisleri");
        izmirhalisaha.add("Şahlanlar Sportland Halı Saha Tesisleri");
        izmirhalisaha.add("Altınırmak Halı Saha & Spor Kompleksi");

        final ArrayList<String>Adres=new ArrayList<>();
        Adres.add("Kazımdirik, Sanayi Cd., 35100 Bornova/İzmir");
        Adres.add("Buca Koop., 220/71. Sk. no 7, 35390 Buca/İzmir");
        Adres.add("Yeşilova, 4049/4. Sk. No:2, 35080 Gökdere/Bornova/İzmir");

        final ArrayList<String>Telefon=new ArrayList<>();
        Telefon.add("0545 675 09 03");
        Telefon.add("0232 453 01 53");
        Telefon.add("0232 467 46 12");

        Bitmap karayollari= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.karayollari_halisaha_iz);
        Bitmap sahlan=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.sahlanspor_izm);
        Bitmap altinirmak=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.altinirmak_izmir);


        final ArrayList<Bitmap>Resim=new ArrayList<>();
        Resim.add(karayollari);
        Resim.add(sahlan);
        Resim.add(altinirmak);


        ArrayAdapter arrayAdapter=new ArrayAdapter(izmir.this,android.R.layout.simple_list_item_1,izmirhalisaha);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),Detay.class);
                intent.putExtra("name",izmirhalisaha.get(position));
                intent.putExtra("adres",Adres.get(position));
                intent.putExtra("tel",Telefon.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(Resim.get(position));

                startActivity(intent);
            }
        });
    }
}

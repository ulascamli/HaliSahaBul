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

public class ankara extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ankara);
        ListView listView=findViewById(R.id.listVieww);
        final ArrayList<String> ankarahalisaha=new ArrayList<>();
        ankarahalisaha.add("Bașkent Kapalı Halı Saha");
        ankarahalisaha.add("Mamak Belediyesi Gülveren Halısaha Tesisleri");
        ankarahalisaha.add("ADA Halı Saha");
        ankarahalisaha.add("Enes Halı Saha");

        final ArrayList<String>Adres=new ArrayList<>();
        Adres.add("Bilinmiyor");
        Adres.add("Şafaktepe, Arif Yaldız Cd No:43, 06340 Mamak/Ankara");
        Adres.add("Söğütözü, Eskişehir Yolu 7. KM, Dumlupınar Bul No:128/A, 06510 Çankaya/Ankara");
        Adres.add("Batı Sitesi, Cengiz Aytmatov Cd, 06370 Yenimahalle/Ankara");

        final ArrayList<String>Telefon=new ArrayList<>();
        Telefon.add("0312 481 44 45");
        Telefon.add("0312 320 20 53");
        Telefon.add("0543 232 62 32");
        Telefon.add("0312 256 78 36");

        Bitmap baskent= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.baskent_ank);
        Bitmap gulveren=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.gulveren_ank);
        Bitmap ada=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ada_ank);
        Bitmap enes=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.enes_ank);

        final ArrayList<Bitmap>Resim=new ArrayList<>();
        Resim.add(baskent);
        Resim.add(gulveren);
        Resim.add(ada);
        Resim.add(enes);

        ArrayAdapter arrayAdapter=new ArrayAdapter(ankara.this,android.R.layout.simple_list_item_1,ankarahalisaha);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),Detay.class);
                intent.putExtra("name",ankarahalisaha.get(position));
                intent.putExtra("adres",Adres.get(position));
                intent.putExtra("tel",Telefon.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(Resim.get(position));

                startActivity(intent);
            }
        });

    }
}

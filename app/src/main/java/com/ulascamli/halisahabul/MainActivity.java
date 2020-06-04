package com.ulascamli.halisahabul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.Listview);

        final ArrayList<String> Sehirler = new ArrayList<>();
        Sehirler.add("Izmir");
        Sehirler.add("Ankara");
        Sehirler.add("Istanbul");
        Sehirler.add("Burdur");
        Sehirler.add("Antalya");
        Sehirler.add("Isparta");
        Sehirler.add("Samsun");

        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,Sehirler);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), izmir.class);
                    startActivity(intent);
                }
                if (position==1){
                    Intent intent = new Intent(getApplicationContext(), ankara.class);
                    startActivity(intent);
                }
                if (position==2){
                    Intent intent = new Intent(getApplicationContext(),istanbul.class);
                    startActivity(intent);
                }
                if (position==3){
                    Intent intent = new Intent(getApplicationContext(),Burdur.class);
                    startActivity(intent);
                }
                if (position==4){
                    Intent intent= new Intent(getApplicationContext(),Antalya.class);
                    startActivity(intent);
                }
                if (position==5){
                    Intent intent= new Intent(getApplicationContext(),isparta.class);
                    startActivity(intent);
                }
                if (position==6){
                    Intent intent= new Intent(getApplicationContext(),Samsun.class);
                    startActivity(intent);
                }
            }
        });

    }
}

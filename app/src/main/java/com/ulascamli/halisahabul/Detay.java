package com.ulascamli.halisahabul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        ImageView ımageView=findViewById(R.id.imageView);
        TextView textView=findViewById(R.id.isim);
        TextView textView1=findViewById(R.id.adres);
        TextView textView2=findViewById(R.id.tel);

        Intent intent=getIntent();
        String halisaha=intent.getStringExtra("name");
        textView.setText(halisaha);
        String adres=intent.getStringExtra("adres");
        textView1.setText(adres);
        String tel=intent.getStringExtra("tel");
        textView2.setText(tel);

        Singleton singleton=Singleton.getInstance();
        ımageView.setImageBitmap(singleton.getChosenImage());
    }
}

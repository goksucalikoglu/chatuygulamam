package com.sadchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.sadchat.baslangic.HosgeldinEkraniMainActivity;
import com.sadchat.yetki.TelefonKayitActivity;

public class GirisEkraniActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(GirisEkraniActivity.this, HosgeldinEkraniMainActivity.class));
                finish();

            }
        },3000 );
    }
}
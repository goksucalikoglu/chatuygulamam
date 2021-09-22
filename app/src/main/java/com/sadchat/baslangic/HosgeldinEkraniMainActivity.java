package com.sadchat.baslangic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sadchat.MainActivity;
import com.sadchat.R;
import com.sadchat.yetki.TelefonKayitActivity;

public class HosgeldinEkraniMainActivity extends AppCompatActivity {

    AppCompatButton btnKabul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosgeldin_ekrani_main);

        btnKabul=findViewById(R.id.btn_kabul);

        btnKabul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anaSayfayaGit=new Intent(HosgeldinEkraniMainActivity.this, TelefonKayitActivity.class);
                startActivity(anaSayfayaGit);
            }
        });
    }
}
package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer[] foto = {
                R.drawable.avatar,
                R.drawable.avatar,
                R.drawable.avatar,
                R.drawable.avatar,
                R.drawable.avatar,
        };

        String[] nama = {
                "Muhamad Salman Fatih Raiz",
                "Agung Wildanu Utama",
                "Surya Angga",
                "Setyo Tamtomo",
                "Farchan Putra Indrianto",
        };

        String[] telepon = {
                "085717900748",
                "082113112077",
                "085156854651",
                "087700534071",
                "082110779827",
        };

        ListView lvContact = findViewById(R.id.lvContact);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nama);

        CustomListAdapter adapter = new CustomListAdapter(this, foto, nama, telepon);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, lvContact.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();

//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + lvContact.getItemAtPosition(position).toString()));
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + lvContact.getItemAtPosition(position).toString()));
                
                startActivity(intent);

                return false;
            }
        });
    }
}
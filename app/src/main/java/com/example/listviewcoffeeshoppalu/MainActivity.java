package com.example.listviewcoffeeshoppalu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private KopiAdapter adapter;
    private ArrayList<Kopi> kopis;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new KopiAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

    }
    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem(){
        kopis = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Kopi kopi = new Kopi();
            kopi.setPhoto(dataPhoto.getResourceId(i, -1));
                    kopi.setName(dataName[i]);
                    kopi.setDescription(dataDescription[i]);
                    kopis.add(kopi);
        }
        adapter.setKopis(kopis);
    }

}
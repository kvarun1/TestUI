package com.mbinfo.testui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mbinfo.model.BannercardDatum;
import com.mbinfo.model.CustomAdapter;
import com.mbinfo.model.Example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<BannercardDatum> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recl);
        arrayList = new ArrayList<>();
        loaddata();
    }

    private void loaddata() {
        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "data.json");
        Log.i("data", jsonFileString);

        try {
            JSONObject object = new JSONObject(jsonFileString);
            JSONArray array = object.getJSONArray("Bannercard_data");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String img_name = jsonObject.getString("background_image");
                BannercardDatum model = new BannercardDatum();
              model.setBackgroundImage(img_name);
                arrayList.add(model);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        CustomAdapter adapter = new CustomAdapter(this, arrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        }
    }

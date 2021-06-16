package com.example.myapplicationnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplicationnew.adapter.CustomRecyclerAdapter;
import com.example.myapplicationnew.adapter.ListofItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    List<ListofItems> listofItemsList;
    RequestQueue rq;

    String request_url = "https://fetch-hiring.s3.amazonaws.com/hiring.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rq = Volley.newRequestQueue(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycleViewContainer);
        recyclerView.hasFixedSize();

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        listofItemsList = new ArrayList<>();

        sendRequest();


    }

    public void sendRequest(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    ListofItems listofItems = new ListofItems();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        listofItems.setId(jsonObject.getInt("id"));
                        listofItems.setListId(jsonObject.getInt("listId"));
                        listofItems.setName(jsonObject.getString("name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    listofItemsList.add(listofItems);
                }
                mAdapter = new CustomRecyclerAdapter(MainActivity.this, listofItemsList);
                recyclerView.setAdapter(mAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        rq.add(jsonArrayRequest);
    }
}

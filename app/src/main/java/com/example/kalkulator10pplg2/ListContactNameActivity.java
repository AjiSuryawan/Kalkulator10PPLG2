package com.example.kalkulator10pplg2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListContactNameActivity extends AppCompatActivity implements ContactsAdapter.ContactsAdapterListener{
    RecyclerView rvKontakName;
    ArrayList<EPLTeamModel> listDataEPLTeams;
    private ContactsAdapter adapterListKontak;

    public void getEPLOnline(){
        String url = "https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League";
        AndroidNetworking.get(url)
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
//                        Log.d("success ", "onResponse: "+jsonObject.toString());
                        try {
                            JSONArray jsonArrayEPLTeam = jsonObject.getJSONArray("teams");
                            for (int i = 0; i < jsonArrayEPLTeam.length(); i++) {
                                EPLTeamModel myTeam = new EPLTeamModel();
                                JSONObject jsonTeam = jsonArrayEPLTeam.getJSONObject(i);
                                myTeam.setTeamName(jsonTeam.getString("strTeam"));
                                myTeam.setStadiun(jsonTeam.getString("strStadium"));
                                myTeam.setStrTeamBadge(jsonTeam.getString("strTeamBadge"));
                                listDataEPLTeams.add(myTeam);
                            }
                            rvKontakName = findViewById(R.id.rvkontakname);
                            adapterListKontak = new ContactsAdapter(getApplicationContext(), listDataEPLTeams,ListContactNameActivity.this);
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            rvKontakName.setHasFixedSize(true);
                            rvKontakName.setLayoutManager(mLayoutManager);
                            rvKontakName.setAdapter(adapterListKontak);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("failed ", "onError: "+anError.toString());
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact_name);
        listDataEPLTeams = new ArrayList<>();
        getEPLOnline();


    }

    @Override
    public void onContactSelected(EPLTeamModel contact) {
        // move to another page
        Toast.makeText(this, "selected name "+contact.getTeamName(), Toast.LENGTH_SHORT).show();
    }
}
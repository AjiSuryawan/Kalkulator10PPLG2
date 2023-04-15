package com.example.kalkulator10pplg2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailTeamPage extends AppCompatActivity {
    Intent i;
    EPLTeamModel eplTeamModel;
    TextView tvTeamName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team_page);

        i = getIntent();
        eplTeamModel = (EPLTeamModel) i.getParcelableExtra("myteam");
        System.out.println("my team name : "+eplTeamModel.getTeamName());
        tvTeamName = findViewById(R.id.tvteamname);
        tvTeamName.setText(eplTeamModel.getTeamName());

    }
}
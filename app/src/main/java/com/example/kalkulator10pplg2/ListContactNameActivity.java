package com.example.kalkulator10pplg2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class ListContactNameActivity extends AppCompatActivity {
    RecyclerView rvKontakName;
    ArrayList<ContactModel> listDataKontak;
    private ContactsAdapter adapterListKontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact_name);
        listDataKontak = new ArrayList<>();
        rvKontakName = findViewById(R.id.rvkontakname);

        ContactModel kontakOne = new ContactModel();
        kontakOne.setName("Aji Suryawan");
        kontakOne.setPhone("081xxxxxx");
        listDataKontak.add(kontakOne);

        ContactModel kontakTwo = new ContactModel();
        kontakTwo.setName("Dwi Janto");
        kontakTwo.setPhone("081xxxxxx");
        listDataKontak.add(kontakTwo);


        ContactModel kontakThree = new ContactModel();
        kontakThree.setName("Fahmi Irsyad");
        kontakThree.setPhone("081xxxxxx");
        listDataKontak.add(kontakThree);

        adapterListKontak = new ContactsAdapter(this, listDataKontak);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvKontakName.setHasFixedSize(true);
        rvKontakName.setLayoutManager(mLayoutManager);
        rvKontakName.setAdapter(adapterListKontak);

    }
}
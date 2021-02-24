package com.example.sqllite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormInput extends AppCompatActivity implements View.OnClickListener {
    ActionBar actionBar;
    EditText edtJudul, edtDeskripsi;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Tambah");

        edtJudul = findViewById(R.id.inpjudul);
        edtDeskripsi = findViewById(R.id.inpdeskripsi);
        btnSubmit = findViewById(R.id.btnsubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnsubmit){
            DatabaseHelper db = new DatabaseHelper(this);
            PersonBean currentPerson = new PersonBean();
            currentPerson.setJudul(edtJudul.getText().toString());
            currentPerson.setDeskripsi(edtDeskripsi.getText().toString());
            db.insert(currentPerson);
            edtJudul.setText("");
            edtDeskripsi.setText("");
            edtJudul.setFocusable(true);
            startActivity(new Intent(FormInput.this, MainActivity.class));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
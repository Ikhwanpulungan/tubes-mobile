package com.test.crud3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.crud3.model.Barang;

/**
 * Created by Hafizh Herdi on 10/15/2017.
 */

public class FirebaseDBReadSingleActivity extends AppCompatActivity {

    private Button btSubmit;
    private EditText etNama;
    private EditText etMerk;
    private EditText etTanggal;
    private TextView btnfile;

    private Button btnChooseFile;

    private LinearLayout status;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_create);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etNama = (EditText) findViewById(R.id.et_namabarang);
        etMerk = (EditText) findViewById(R.id.et_merkbarang);
        etTanggal = findViewById(R.id.et_tanggal);
        btSubmit = (Button) findViewById(R.id.bt_submit);
        btnChooseFile = findViewById(R.id.btn_choose_file);
        btnfile = findViewById(R.id.btn_file);
        status = findViewById(R.id.statusLayout);

        etNama.setEnabled(false);
        etMerk.setEnabled(false);
        etTanggal.setEnabled(false);
        status.setVisibility(View.GONE);

        btSubmit.setVisibility(View.GONE);
        btnChooseFile.setVisibility(View.GONE);
        btnfile.setVisibility(View.GONE);

        Barang barang = (Barang) getIntent().getSerializableExtra("data");
        if(barang!=null){
            etNama.setText(barang.getNama());
            etMerk.setText(barang.getMerk());
            etTanggal.setText(barang.getTanggal());
        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FirebaseDBReadSingleActivity.class);
    }
}

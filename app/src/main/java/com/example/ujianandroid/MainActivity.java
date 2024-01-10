package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @@ -18,9 +16,10 @@ protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edNamaDepan = (EditText) findViewById(R.id.edNamaDepan);
        EditText edNamaBelakang = (EditText) findViewById(R.id.edNamaBelakang);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);
        EditText edNamaDepan = findViewById(R.id.edNamaDepan);
        EditText edNamaBelakang = findViewById(R.id.edNamaBelakang);
        EditText edUmur = findViewById(R.id.edUmur);
        Button btnSimpan = findViewById(R.id.btnSimpan);

        ArrayList<String> daftar_nama = new ArrayList<>();

        @@ -31,19 +30,41 @@ protected void onCreate(Bundle savedInstanceState) {
            public void onClick(View view) {
                String isian_nama_depan = edNamaDepan.getText().toString();
                String isian_nama_belakang = edNamaBelakang.getText().toString();
                String isian_umur = edUmur.getText().toString();

                if(isian_nama_depan.isEmpty()){
                    if (isian_nama_depan.isEmpty() || isian_umur.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
                    }else{
                    } else {
                        int umur = Integer.parseInt(isian_umur);
                        String kategori_umur = getKategoriUmur(umur);

                        String nama_lengkap = isian_nama_depan.concat(" ").concat(isian_nama_belakang);
                        daftar_nama.clear();
                        daftar_nama.add(nama_lengkap);

                        // Menambahkan informasi urutan, nama, umur, dan status
                        for (int i = 1; i <= umur; i++) {
                            daftar_nama.add(i + ". " + nama_lengkap + " , Status: " + kategori_umur);
                        }

                        edNamaDepan.setText("");
                        edNamaBelakang.setText("");
                        edUmur.setText("");
                        intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);
                        startActivity(intent_list);
                    }
                }
            });
        }

        private String getKategoriUmur(int umur) {
            if (umur < 10) {
                return "Anak";
            } else if (umur < 20) {
                return "Remaja";
            } else if (umur < 40) {
                return "Dewasa";
            } else {
                return "Orang Tua";
            }
        }
    }
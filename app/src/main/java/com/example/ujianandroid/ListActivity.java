import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@@ -17,17 +16,23 @@ protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvNama = (ListView) findViewById(R.id.lvNama);

        ArrayList<String> daftar_nama = getIntent().getExtras().getStringArrayList("daftar_nama");

        if(daftar_nama.isEmpty()){
        daftar_nama.add("data masih kosong");
        ListView lvNama = findViewById(R.id.lvNama);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("daftar_nama")) {
        ArrayList<String> daftar_nama = intent.getStringArrayListExtra("daftar_nama");

        if (daftar_nama != null && !daftar_nama.isEmpty()) {
        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar_nama);
        lvNama.setAdapter(ad_nama);
        } else {
        daftar_nama = new ArrayList<>();
        daftar_nama.add("Data masih kosong");
        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar_nama);
        lvNama.setAdapter(ad_nama);
        }
        } else {
        // ...
        }

        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar_nama);

        lvNama.setAdapter(ad_nama);

        }
        }
        }
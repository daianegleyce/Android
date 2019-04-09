package br.usjt;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaLocActivity extends AppCompatActivity {

    private ListView locationsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_loc);
        Intent origemIntent = getIntent();
        final ArrayList<LatLong> locations = (ArrayList<LatLong>) origemIntent.getSerializableExtra("locations");

        locationsListView = findViewById(R.id.locListView);
        ArrayAdapter<LatLong> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locations);
        locationsListView.setAdapter(adapter);

        locationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LatLong location = locations.get(position);

                Uri gmmIntentUri = Uri.parse(String.format("geo:%f,%f", location.getLongitude(), location.getLatitude()));

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });



    }
}

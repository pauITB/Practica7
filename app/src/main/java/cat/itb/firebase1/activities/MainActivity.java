package cat.itb.firebase1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cat.itb.firebase1.R;
import cat.itb.firebase1.adapter.ComicsAdapter;
import cat.itb.firebase1.model.Comic;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    RecyclerView rvComics;
    ComicsAdapter adapter;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Comic");

        floatingActionButton = findViewById(R.id.floatingActionButton);
        rvComics = findViewById(R.id.rvComics);
        rvComics.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Comic> options = new  FirebaseRecyclerOptions.Builder<Comic>().setQuery(myRef,Comic.class).build();
        adapter=new ComicsAdapter(options);
        rvComics.setAdapter(adapter);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EditActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
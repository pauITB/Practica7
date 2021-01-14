package cat.itb.firebase1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditActivity extends AppCompatActivity {
    TextView textView;
    EditText titulo, editorial;
    RatingBar ratingBar;
    Button buttonEdit;

    FirebaseDatabase database;
    DatabaseReference myRef;
    Boolean editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Comic");
        textView = findViewById(R.id.textView);
        titulo = findViewById(R.id.tituloEditText);
        editorial = findViewById(R.id.tituloEditText);
        ratingBar = findViewById(R.id.ratingBar);
        buttonEdit = findViewById(R.id.buttonEdit);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            titulo.setText(bundle.getString("Titulo"));
            editorial.setText(bundle.getString("Editorial"));
            ratingBar.setRating(bundle.getFloat("Nota"));
            buttonEdit.setText("Editar");
            editar=true;
        }
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editar){
            }
        });
    }
}
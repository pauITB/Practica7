package cat.itb.firebase1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import cat.itb.firebase1.R;
import cat.itb.firebase1.database.FirebaseAPI;
import cat.itb.firebase1.model.Comic;

public class EditActivity extends AppCompatActivity {
    TextView textView;
    EditText titulo, editorial;
    RatingBar ratingBar;
    Button buttonEdit;

    FirebaseAPI firebaseAPI = new FirebaseAPI();
    Boolean editar=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        textView = findViewById(R.id.textView);
        titulo = findViewById(R.id.tituloEditText);
        editorial = findViewById(R.id.editorialEditText);
        ratingBar = findViewById(R.id.ratingBar);
        buttonEdit = findViewById(R.id.buttonEdit);
        final Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            textView.setText(R.string.modifComic);
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
                    String key = bundle.getString("Key");
                    Comic comic = new Comic(key,titulo.getText().toString(),editorial.getText().toString(),ratingBar.getRating());
                    firebaseAPI.editItem(comic);
                    finish();
                }else {
                    Comic comic = new Comic(titulo.getText().toString(),editorial.getText().toString(),ratingBar.getRating());
                    firebaseAPI.insert(comic);
                    finish();
                }
            }
        });
    }
}
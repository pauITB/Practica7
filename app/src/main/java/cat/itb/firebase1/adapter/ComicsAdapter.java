package cat.itb.firebase1.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import cat.itb.firebase1.EditActivity;
import cat.itb.firebase1.MainActivity;
import cat.itb.firebase1.R;
import cat.itb.firebase1.model.Comic;

public class ComicsAdapter  extends FirebaseRecyclerAdapter<Comic, ComicsAdapter.ComicHolder> {


    public ComicsAdapter(@NonNull FirebaseRecyclerOptions<Comic> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ComicsAdapter.ComicHolder holder, int position, @NonNull Comic model) {
        holder.nombre.setText(model.getNombre());
        holder.editorial.setText(model.getEditorial());
        holder.nota.setText(Float.toString(model.getNota()));

    }

    @NonNull
    @Override
    public ComicsAdapter.ComicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic_view,parent,false);
        return new ComicsAdapter.ComicHolder(v);
    }

    public class ComicHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView editorial;
        TextView nota;

        public ComicHolder(@NonNull final View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreTextView);
            editorial = itemView.findViewById(R.id.editorialTextView);
            nota = itemView.findViewById(R.id.notaTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), EditActivity.class);
                    intent.putExtra("Titulo",nombre.getText().toString());
                    intent.putExtra("Editorial",editorial.getText().toString());
                    intent.putExtra("Nota",Float.parseFloat(nota.getText().toString()));
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}
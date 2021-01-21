package cat.itb.firebase1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import cat.itb.firebase1.activities.EditActivity;
import cat.itb.firebase1.R;
import cat.itb.firebase1.database.FirebaseAPI;
import cat.itb.firebase1.model.Comic;

public class ComicsAdapter  extends FirebaseRecyclerAdapter<Comic, ComicsAdapter.ComicHolder> {

    private FirebaseRecyclerOptions<Comic> comics;
    private Context context ;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ComicsAdapter(@NonNull FirebaseRecyclerOptions<Comic> options) {
        super(options);
        comics=options;
    }

    @Override
    protected void onBindViewHolder(@NonNull ComicsAdapter.ComicHolder holder, int position, @NonNull Comic model) {
        holder.bind(model);

    }

    @NonNull
    @Override
    public ComicsAdapter.ComicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic_view,parent,false);
        return new ComicsAdapter.ComicHolder(v);
    }




    public void deleteItem(int position) {
        FirebaseAPI firebaseAPI = new FirebaseAPI();
        firebaseAPI.deleteItem(comics.getSnapshots().get(position).getIdComic());

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


        }

        public void bind(final Comic model) {
            nombre.setText(model.getNombre());
            editorial.setText(model.getEditorial());
            nota.setText(Float.toString(model.getNota()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), EditActivity.class);
                    intent.putExtra("Key",model.getIdComic());
                    intent.putExtra("Titulo",nombre.getText().toString());
                    intent.putExtra("Editorial",editorial.getText().toString());
                    intent.putExtra("Nota",Float.parseFloat(nota.getText().toString()));
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}

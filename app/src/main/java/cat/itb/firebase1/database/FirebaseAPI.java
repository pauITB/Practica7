package cat.itb.firebase1.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cat.itb.firebase1.model.Comic;

public class FirebaseAPI {
     FirebaseDatabase database = FirebaseDatabase.getInstance();
     DatabaseReference reference= database.getReference("Comic");

    public FirebaseAPI() {
    }

    public DatabaseReference getReference() {
        return reference;
    }

    public DatabaseReference getReference(String s) {
        return database.getReference(s);
    }

    public void setReference(String comic) {
        reference= database.getReference(comic);
    }

    public void deleteItem(String key){
        reference.child(key).removeValue();
    }

    public void editItem(Comic comic){
        reference.child(comic.getIdComic()).setValue(comic);
    }

    public void insert(Comic comic){
        String key = reference.push().getKey();
        comic.setIdComic(key);
        reference.child(key).setValue(comic);
    }
}

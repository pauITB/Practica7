package cat.itb.firebase1;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import cat.itb.firebase1.adapter.ComicsAdapter;

public class SwipeToDeleteCallBack extends ItemTouchHelper.SimpleCallback {
    private ComicsAdapter comicsAdapter;

    public SwipeToDeleteCallBack(ComicsAdapter adapter) {
        super(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        comicsAdapter = adapter;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }
}

package com.indeco.trainingandroid.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.indeco.trainingandroid.R;
import com.indeco.trainingandroid.entities.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private final List<Note> list;
    private OnClickListener listener;

    public NotesAdapter() {
        list = new ArrayList<>();
    }

    public void setList(List<Note> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);

        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note item = list.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvContent.setText(item.getContent());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(item, position);
            }
        });

        holder.deleteView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void add(Note note) {
        list.add(note);
        notifyDataSetChanged();
    }

    public void setOnClickedListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void update(Note note, int position) {
        list.set(position, note);
        notifyDataSetChanged();
    }

    public interface OnClickListener {
        void onItemClicked(Note note, int position);
    }

    public static class NotesViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvContent;
        View cv;
        View deleteView;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvContent);

            cv = itemView.findViewById(R.id.cv);

            deleteView = itemView.findViewById(R.id.delete);
        }
    }
}

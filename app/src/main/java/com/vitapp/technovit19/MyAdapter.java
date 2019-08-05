package com.vitapp.technovit19;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public CardView imgView;
        public MyViewHolder(CardView v) {
            super(v);
            imgView = v;
        }

    }

    public MyAdapter()
    {}

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_image_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ImageView img = (ImageView) holder.imgView.findViewById(R.id.displayimg);
        img.setImageResource(R.drawable.tcvit19logo);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

}

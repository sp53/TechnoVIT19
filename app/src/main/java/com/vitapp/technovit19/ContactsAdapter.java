package com.vitapp.technovit19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private List<ContactsData> contactsData;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView pic;
        public TextView name, number;

        public MyViewHolder(View view) {
            super(view);
            pic = view.findViewById(R.id.contacts_pic);
            name = view.findViewById(R.id.contacts_name);
            number= view.findViewById(R.id.contacts_number);
        }
    }

    public ContactsAdapter(List<ContactsData> contactsData) {
        this.contactsData = contactsData;
    }

    public ContactsAdapter(List<ContactsData> contactsData, Context context) {
        this.contactsData = contactsData;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contacts_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ContactsData data = contactsData.get(position);
        /*Picasso.get().load("https://imgur.com/uoqKFKq").error(R.drawable.power).into(holder.pic, new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(Exception e) {
                Log.d("ERROR", e.toString());
            }
        });*/
        Picasso.get().load(data.getUrl()).into(holder.pic);
        holder.name.setText(data.getName());
        holder.number.setText(data.getNumber());

    }

    @Override
    public int getItemCount() {
        return contactsData.size();
    }
}

package com.vitapp.technovit19;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
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
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap bmp = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                bmp = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bmp;
        }
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
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
        //holder.pic.setImageResource(data.getImageID());
        /*Picasso.get().load("https://imgur.com/uoqKFKq").error(R.drawable.power).into(holder.pic, new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(Exception e) {
                Log.d("ERROR", e.toString());
            }
        });*/
        //new DownloadImageTask(holder.pic).execute("https://imgur.com/undefined");
        //Picasso.with(context).load(data.getUrl()).into(holder.pic);
        Picasso.get().load(data.getUrl()).into(holder.pic);
        holder.name.setText(data.getName());
        holder.number.setText(data.getNumber());

    }

    @Override
    public int getItemCount() {
        return contactsData.size();
    }
}

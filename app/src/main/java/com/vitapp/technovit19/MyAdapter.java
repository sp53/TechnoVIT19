package com.vitapp.technovit19;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {




    ArrayList<Bitmap> bmp= new ArrayList<Bitmap>();
    download obj=new download();


    public MyAdapter()
    {
        start();
    }


    public void start()
    {
        try {
            obj.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public class download extends AsyncTask<String, Void, Integer>
    {
        String myurl[]={"https://homepages.cae.wisc.edu/~ece533/images/airplane.png","https://homepages.cae.wisc.edu/~ece533/images/airplane.png","https://homepages.cae.wisc.edu/~ece533/images/airplane.png"};

        @Override
        protected Integer doInBackground(String... urls) {
            Log.d("yoyo","10000"+myurl.length);


            try {
                Bitmap myBitmap;

                for(int i=0;i<myurl.length;i++)
                {
                    URL url = new URL(myurl[i]);
                    HttpURLConnection httpc = (HttpURLConnection) url.openConnection();
                    httpc.connect();

                    InputStream is = httpc.getInputStream();
                    myBitmap = BitmapFactory.decodeStream(is);
                    Log.d("yoyo","00000");
                    bmp.add(myBitmap);
                    publishProgress();
                }
                return 0;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.d("yoyo","00002");
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("yoyo","00003");
            }
            return 1;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            notifyDataSetChanged();
            Log.d("makemachine", "onProgressUpdate(): ");
        }

        @Override
        protected void onPostExecute(Integer integer) {

            Log.d("yoyo","00001");
            notifyDataSetChanged();



        }
    }

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
        ImageView img = holder.imgView.findViewById(R.id.displayimg);
        try
        {
            img.setImageBitmap(bmp.get(position));
            ProgressBar pbr = holder.imgView.findViewById(R.id.pbr);
            pbr.setVisibility(View.INVISIBLE);
        }
        catch (Exception e)
        {
            img.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public CardView imgView;
        public MyViewHolder(CardView v) {
            super(v);
            imgView = v;
        }

    }

}

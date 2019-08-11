package com.vitapp.technovit19;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class home_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home,container,false);

        ImageView qubit = view.findViewById(R.id.qubitimage);
        Picasso.get().load("https://imgur.com/9vV4yVY.png").into(qubit);

        ImageView vsplash = view.findViewById(R.id.imageView2);
        Picasso.get().load("https://imgur.com/svJr9mr.png").into(vsplash);

        ImageView diseno = view.findViewById(R.id.imageView3);
        Picasso.get().load("https://imgur.com/wgt9SJa.png").into(diseno);

        ImageView glitz = view.findViewById(R.id.img_glitz);
        Picasso.get().load("https://imgur.com/TdTSMof.png").into(glitz);

        ImageView connectiviti = view.findViewById(R.id.imageView4);
        Picasso.get().load("https://imgur.com/zIkhWDU.png").into(connectiviti);

        ImageView vitness = view.findViewById(R.id.vitness_img);
        Picasso.get().load("https://imgur.com/W08rj0Z.png").into(vitness);

        ImageView taikuun = view.findViewById(R.id.imageView5);
        Picasso.get().load("https://imgur.com/9eVU5gn.png").fit().into(taikuun);

        return view;
    }
}

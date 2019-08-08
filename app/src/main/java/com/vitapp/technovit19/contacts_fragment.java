package com.vitapp.technovit19;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class contacts_fragment extends Fragment {

    ArrayList<ContactsData> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts,container,false);

        prepareContactsData();

        RecyclerView recyclerView = view.findViewById(R.id.contacts_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ContactsAdapter contactsAdapter = new ContactsAdapter(data, getContext());
        recyclerView.setAdapter(contactsAdapter);

        return view;
    }

    private void prepareContactsData() {
        data = new ArrayList<>();

        data.add(new ContactsData("https://imgur.com/fd8yNky.jpg", "Vydeki D", "9754567155"));
        data.add(new ContactsData("https://imgur.com/WPawec9.jpg", "Luke Gerard Christie", "9754567155"));
        data.add(new ContactsData("https://imgur.com/jNAlYzO.jpg", "Devashish Srivastava", "9754567155"));
        data.add(new ContactsData("https://imgur.com/O9xAKRd.jpg", "Ananya Srinath", "9754567155"));
        data.add(new ContactsData("https://imgur.com/vRk8kOR.jpg", "Saharsh Oswal", "9754567155"));
        data.add(new ContactsData("https://imgur.com/IiiAGWr.jpg", "Ananda Krishnan", "9754567155"));
        data.add(new ContactsData("https://imgur.com/k4f2Htn.jpg", "Devabrat Mahapatra", "9754567155"));
    }
}

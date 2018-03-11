package com.example.marci.apk_kozienalia.Fragmenty_ViewHoldery;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.marci.apk_kozienalia.Common.Common;
import com.example.marci.apk_kozienalia.DB.Kategorie_MENU;
import com.example.marci.apk_kozienalia.Interface.ItemClickListener;
import com.example.marci.apk_kozienalia.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class str_glowna_fragment extends Fragment {

    //Firebase
    FirebaseDatabase database;
    DatabaseReference category;
    //View
    RecyclerView recycler_menu;
    RecyclerView.LayoutManager layoutManager;
    //FireBase UI ADAPTER
    FirebaseRecyclerAdapter<Kategorie_MENU,str_glowna_viewholder> adapter;
    FirebaseRecyclerOptions<Kategorie_MENU> options;

    private static str_glowna_fragment INSTANCE=null;

    public str_glowna_fragment() {
        database = FirebaseDatabase.getInstance();
        category = database.getReference(Common.STR_Kategorie_MENU);

        options = new FirebaseRecyclerOptions.Builder<Kategorie_MENU>()
                .setQuery(category, Kategorie_MENU.class).build();

        adapter = new FirebaseRecyclerAdapter<Kategorie_MENU, str_glowna_viewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final str_glowna_viewholder holder, int position, @NonNull final Kategorie_MENU model) {
                Picasso.with(getActivity())
                        .load(model.getObrazek())
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        Picasso.with(getActivity())
                                .load(model.getObrazek())
                                .error(R.drawable.ic_notifications_black_24dp)
                                .into(holder.imageView, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {
                                Log.e("ERROR", "Nie udało się pobrać obrazka.");
                            }
                        });
                    }
                });

                holder.txtMenuName.setText(model.getNazwa_kat());

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //pozniej
                    }
                });
            }

            @Override
            public str_glowna_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.str_glowna_item, parent, false);
                return new str_glowna_viewholder(itemView);
            }
        };
    }

    public static str_glowna_fragment getInstance(){
        if(INSTANCE==null){
            INSTANCE = new str_glowna_fragment();
        }
        return INSTANCE;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_str__glowna, container, false);



        recycler_menu=(RecyclerView)view.findViewById(R.id.recycler_menu);
        recycler_menu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recycler_menu.setLayoutManager(layoutManager);

        setCategory();
        
        return view;


    }

    private void setCategory() {
        adapter.startListening();
        recycler_menu.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(adapter!=null){
            adapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(adapter!=null){
            adapter.stopListening();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter!=null){
            adapter.startListening();
        }
    }
}

package com.team3990.techportail.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.team3990.techportail.Activities.EventDetailActivity;
import com.team3990.techportail.Adapters.EventsListAdapter;
import com.team3990.techportail.R;

import butterknife.BindView;

/**
 * Created by Anas Merbouh on 17-12-30.
 */

public class EventsFragment extends Fragment implements EventsListAdapter.OnEventSelectedListener {

    // Déclaration des éléments de l'interface du Fragment
    private RecyclerView mEventsRecycler;
    private EventsListAdapter mAdapter;

    // Firestore
    private FirebaseFirestore mFirestore;
    private Query mQuery;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        initFirestore();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //
        View view = inflater.inflate(R.layout.fragment_events, null);

        // Initialisation du Recyler View des évènements
        mEventsRecycler = (RecyclerView) view.findViewById(R.id.events_list);

        //
        initRecyclerView();

        //
        return view;
    }

    private void initFirestore() {
        mFirestore = FirebaseFirestore.getInstance();

        // TODO: 17-12-31  Ajouter un filtre pour récupérer les évènements selon la date

        // Query des évènements
        mQuery = mFirestore.collection("events");
    }


    private  void initRecyclerView() {
        if (mQuery == null) {

        }

        mAdapter = new EventsListAdapter(mQuery, this) {

            @Override
            protected  void onDataChanged() {
                if (getItemCount() == 0) {
                    mEventsRecycler.setVisibility(View.GONE);
                } else {
                    mEventsRecycler.setVisibility(View.VISIBLE);
                }
            }
        };

        mEventsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mEventsRecycler.setAdapter(mAdapter);

        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(mEventsRecycler.getContext(), DividerItemDecoration.VERTICAL);
        mEventsRecycler.addItemDecoration(mDividerItemDecoration);
    }

    @Override
    public void onStart() {
        super.onStart();

        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    @Override
    public void onEventSelected(DocumentSnapshot event) {
        Intent intent = new Intent(getActivity(), EventDetailActivity.class);
        intent.putExtra(EventDetailActivity.KEY_EVENT_ID, event.getId());

        startActivity(intent);
    }
}

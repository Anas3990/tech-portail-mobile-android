package com.team3990.techportail.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.team3990.techportail.Activities.EventDetailActivity;
import com.team3990.techportail.Adapters.EventAttendancesListAdapter;
import com.team3990.techportail.R;

/**
 * Created by Anas Merbouh on 17-12-31.
 */

public class EventAttendancesFragment extends Fragment implements EventAttendancesListAdapter.OnEventAttendanceSelectedListener {

    // Déclaration des éléments de l'interface du Fragment
    private RecyclerView mEventAttendancesRecycler;
    private EventAttendancesListAdapter mAdapter;

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
        View view = inflater.inflate(R.layout.fragment_event_attendances, null);

        // Initialisation du Recyler View des présences de l'évènement
        mEventAttendancesRecycler = (RecyclerView) view.findViewById(R.id.event_attendances_list);

        //
        initRecyclerView();

        //
        return view;
    }

    private void initFirestore() {
        mFirestore = FirebaseFirestore.getInstance();

        // Query des présences de l'évènement
        mQuery = mFirestore.collection("events").document(EventDetailActivity.KEY_EVENT_ID).collection("attendances");
    }

    private  void initRecyclerView() {
        if (mQuery == null) {

        }

        mAdapter = new EventAttendancesListAdapter(mQuery, this) {

            @Override
            protected  void onDataChanged() {
                if (getItemCount() == 0) {
                    mEventAttendancesRecycler.setVisibility(View.GONE);
                } else {
                    mEventAttendancesRecycler.setVisibility(View.VISIBLE);
                }
            }
        };

        mEventAttendancesRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mEventAttendancesRecycler.setAdapter(mAdapter);
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
    public void onEventAttendanceSelected(DocumentSnapshot attendance) {

    }
}

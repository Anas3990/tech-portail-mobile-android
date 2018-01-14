package com.team3990.techportail.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.team3990.techportail.Adapters.AttendancesListAdapter;
import com.team3990.techportail.R;

/**
 * Created by Anas Merbouh on 17-12-30.
 */

public class MyAttendancesFragment extends Fragment implements AttendancesListAdapter.OnAttendanceSelectedListener {

    // Déclaration des éléments de l'interface du Fragment
    private RecyclerView mAttendancesRecyler;
    private AttendancesListAdapter mAdapter;

    // Firestore
    private FirebaseFirestore mFirestore;
    private Query mQuery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //
        View view = inflater.inflate(R.layout.fragment_my_attendances, null);

        // Initialisation du Recyler View des présences
        mAttendancesRecyler = (RecyclerView) view.findViewById(R.id.attendances_list);


        return view;
    }

    @Override
    public void onAttendanceSelected(DocumentSnapshot attendance) {

    }
}

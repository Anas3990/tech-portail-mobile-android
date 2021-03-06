package com.team3990.techportail.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.team3990.techportail.Activities.NewDetailActivity;
import com.team3990.techportail.Adapters.NewsListAdapter;
import com.team3990.techportail.R;

import butterknife.BindView;

/**
 * Created by Anas Merbouh on 17-12-30.
 */

public class NewsFragment extends Fragment implements NewsListAdapter.OnNewSelectedListener {

    // Déclaration des éléments de l'interface du Fragment
    private RecyclerView mNewsRecycler;
    private NewsListAdapter mAdapter;

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
        View view = inflater.inflate(R.layout.fragment_news, null);

        // Associer le Recycler View à l'interface appropriée
        mNewsRecycler = (RecyclerView) view.findViewById(R.id.news_list);

        //
        initRecyclerView();

        return view;
    }

    private void initFirestore() {
        mFirestore = FirebaseFirestore.getInstance();

        // Query des nouvelles selon leur date de création
        mQuery = mFirestore.collection("news").orderBy("timestamp", Query.Direction.DESCENDING);
    }

    private  void initRecyclerView() {
        if (mQuery == null) {

        }

        mAdapter = new NewsListAdapter(mQuery, this) {

            @Override
            protected  void onDataChanged() {
                if (getItemCount() == 0) {
                    mNewsRecycler.setVisibility(View.GONE);
                } else {
                    mNewsRecycler.setVisibility(View.VISIBLE);
                }
            }
        };

        mNewsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mNewsRecycler.setAdapter(mAdapter);

        //
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(mNewsRecycler.getContext(), DividerItemDecoration.VERTICAL);
        mNewsRecycler.addItemDecoration(mDividerItemDecoration);
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
    public void onNewSelected(DocumentSnapshot _new) {
        Intent intent = new Intent(getActivity(), NewDetailActivity.class);
        intent.putExtra(NewDetailActivity.KEY_NEW_ID, _new.getId());

        startActivity(intent);
    }
}

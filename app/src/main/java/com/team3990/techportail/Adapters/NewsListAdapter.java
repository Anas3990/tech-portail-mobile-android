package com.team3990.techportail.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.team3990.techportail.Models.NewObject;
import com.team3990.techportail.R;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
     * Created by Anas Merbouh on 17-12-30.
 */

public class NewsListAdapter extends FirestoreAdapter<NewsListAdapter.ViewHolder> {

    //
    public interface OnNewSelectedListener {
        void onNewSelected(DocumentSnapshot _new);
    }

    private NewsListAdapter.OnNewSelectedListener mListener;

    public NewsListAdapter(Query query, NewsListAdapter.OnNewSelectedListener listener) {
        super(query);
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.news_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(NewsListAdapter.ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }

    //
    static class ViewHolder extends RecyclerView.ViewHolder {

        //
        @BindView(R.id.new_title)
        TextView titleView;

        @BindView(R.id.new_body)
        TextView bodyView;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final DocumentSnapshot snapshot, final  OnNewSelectedListener listener) {
            NewObject _new = snapshot.toObject(NewObject.class);

            titleView.setText(_new.getTitle());
            bodyView.setText(_new.getBody());

            // Click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onNewSelected(snapshot);
                    }
                }
            });
        }
    }
}

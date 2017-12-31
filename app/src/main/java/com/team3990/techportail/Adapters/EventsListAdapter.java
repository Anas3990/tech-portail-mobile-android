package com.team3990.techportail.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.team3990.techportail.Models.EventObject;
import com.team3990.techportail.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anas Merbouh on 17-12-30.
 */

public class EventsListAdapter extends FirestoreAdapter<EventsListAdapter.ViewHolder> {


    //
    public interface OnEventSelectedListener {
        void onEventSelected(DocumentSnapshot event);
    }

    private OnEventSelectedListener mListener;

    public EventsListAdapter(Query query, OnEventSelectedListener listener) {
        super(query);
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.events_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        //
        @BindView(R.id.event_title)
        TextView titleView;

        @BindView(R.id.event_body)
        TextView bodyView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final DocumentSnapshot snapshot, final  OnEventSelectedListener listener) {
            EventObject event = snapshot.toObject(EventObject.class);

            titleView.setText(event.getTitle());
            bodyView.setText(event.getBody());

            // Click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if (listener != null) {
                       listener.onEventSelected(snapshot);
                   }
                }
            });
        }
    }
}

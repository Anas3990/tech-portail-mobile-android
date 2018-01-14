package com.team3990.techportail.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.team3990.techportail.Models.UserAttendanceObject;
import com.team3990.techportail.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anas Merbouh on 17-12-31.
 */

public class AttendancesListAdapter extends FirestoreAdapter<AttendancesListAdapter.ViewHolder> {

    //
    public interface OnAttendanceSelectedListener {
        void onAttendanceSelected(DocumentSnapshot attendance);
    }

    //
    private OnAttendanceSelectedListener mListener;

    public AttendancesListAdapter(Query query, OnAttendanceSelectedListener listener) {
        super(query);
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.attendances_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        //
        @BindView(R.id.event_title)
        TextView eventTitleView;

        @BindView(R.id.event_body)
        TextView eventBodyView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final DocumentSnapshot snapshot, final OnAttendanceSelectedListener listener) {
            UserAttendanceObject attendance = snapshot.toObject(UserAttendanceObject.class);

            eventTitleView.setText(attendance.getEventTitle());
            eventBodyView.setText(attendance.getEventBody());

            // Click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onAttendanceSelected(snapshot);
                    }
                }
            });
        }
    }
}

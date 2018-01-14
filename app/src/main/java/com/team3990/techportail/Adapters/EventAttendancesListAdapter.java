package com.team3990.techportail.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.team3990.techportail.Models.AttendanceObject;
import com.team3990.techportail.R;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anas Merbouh on 18-01-01.
 */

public class EventAttendancesListAdapter extends FirestoreAdapter<EventAttendancesListAdapter.ViewHolder> {

    //
    public interface OnEventAttendanceSelectedListener {
        void onEventAttendanceSelected(DocumentSnapshot attendance);
    }

    //
    private OnEventAttendanceSelectedListener mListener;

    public EventAttendancesListAdapter(Query query, OnEventAttendanceSelectedListener listener) {
        super(query);
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.event_attendances_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        //
        @BindView(R.id.event_attendant_name)
        TextView eventAttendanceAttendantFullName;

        @BindView(R.id.event_attendance_schedule)
        TextView eventAttendanceSchedule;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final DocumentSnapshot snapshot, final OnEventAttendanceSelectedListener listener) {
            AttendanceObject attendance = snapshot.toObject(AttendanceObject.class);

            SimpleDateFormat simpleDate =  new SimpleDateFormat("HH:mm");

            //
            String attendanceStartDate = simpleDate.format(attendance.getAttendanceStartsAt());
            String attendanceEndDate = simpleDate.format(attendance.getAttendanceEndsAt());

            eventAttendanceAttendantFullName.setText(attendance.getAttendantName());
            eventAttendanceSchedule.setText("De " + attendanceStartDate + " à " + attendanceEndDate);

            // Click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onEventAttendanceSelected(snapshot);
                    }
                }
            });
        }
    }
}
